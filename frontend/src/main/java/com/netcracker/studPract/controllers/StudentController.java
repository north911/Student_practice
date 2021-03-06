package com.netcracker.studPract.controllers;


import com.netcracker.studPract.FormValidators.StudentFormValidator;
import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.AssigmentsService;
import com.netcracker.devschool.dev4.studPract.service.RequestsService;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import com.netcracker.studPract.beans.ErrorViewObject;
import com.netcracker.studPract.converters.RequestConverter;
import com.netcracker.studPract.converters.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentsService studentsService;

    @Autowired
    UsersService usersService;

    @Autowired
    StudentConverter studentConverter;

    @Autowired
    RequestsService requestsService;

    @Autowired
    RequestConverter requestConverter;

    @Autowired
    AssigmentsService assigmentsService;

    @Autowired
    ErrorViewObject errorViewObject;


    @RequestMapping("/profile/{id}")
    public String studentData(@PathVariable("id") int id, Model model){

        if (studentsService.findById(id) != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            model.addAttribute("currentAuth", usersService.findByUserLogin(name));
            List<StudentsEntity> studentsEntities = new ArrayList<StudentsEntity>();
            studentsEntities.add(studentsService.findById(id));
            model.addAttribute("student", (studentConverter.convert(studentsEntities)).get(0));
            model.addAttribute("listPractices", requestConverter.convert(requestsService.findByIdStudent(id)));
            return "profile";
        } else {
            return "redirect:/login";
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/removeCheckedStudents", method = RequestMethod.POST)
    public String removeCheckedStudents(@RequestParam(value = "id[]", required = false) List<String> id) {

        for (String s : id) {
            studentsService.deleteStudentById(Integer.parseInt(s));
        }
        return "redirect:/admin";
    }


    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object addStudent(@Valid @ModelAttribute StudentFormValidator studentFormValidator, BindingResult result) {

        if (usersService.findByUserLogin(studentFormValidator.getLogin()) != null) {
            errorViewObject.setErrorMsg("login already exist");
            return errorViewObject;
        }
        if (result.hasErrors()) {
            return result.getAllErrors();
        } else {
            StudentsEntity studentsEntity = new StudentsEntity();
            UsersEntity usersEntity = new UsersEntity();
            studentsEntity.setAvgBall(Double.parseDouble(studentFormValidator.getAvgBall()));
            studentsEntity.setIdGroup(Integer.parseInt(studentFormValidator.getIdGroup()));
            studentsEntity.setIdSpec(Integer.parseInt(studentFormValidator.getIdSpec()));
            studentsEntity.setIsBudget(Byte.parseByte(studentFormValidator.getIsBudget()));
            usersEntity.setFirstName(studentFormValidator.getFirstName());
            usersEntity.setLastName(studentFormValidator.getLastName());
            usersEntity.setusername(studentFormValidator.getLogin());
            usersEntity.setPassword(org.apache.commons.codec.digest.DigestUtils.sha256Hex(studentFormValidator.getPassword()));
            usersEntity.setEnabled(1);
            studentsService.saveStudent(studentsEntity, usersEntity);
            return studentsEntity;
        }
    }


    @RequestMapping(value = "removeStudentFromPractice",method = RequestMethod.POST)
    @PreAuthorize("hasRole('HEAD')")
    public String removeStudentFromPractice(@RequestParam("id[]") List<Integer> idR,
                                            @RequestParam("id2") int idS){

        for (Integer idReq : idR) {
            assigmentsService.deleteById(assigmentsService.findByIdStudentAndRequest(idS,idReq).getId());
        }
        return "redirect:/profile/"+idS;
    }
}
