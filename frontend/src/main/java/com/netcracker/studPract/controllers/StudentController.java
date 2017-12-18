package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.FormValidators.StudentFormValidator;
import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.AssigmentsService;
import com.netcracker.devschool.dev4.studPract.service.RequestsService;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import com.netcracker.studPract.beans.StudentViewModel;
import com.netcracker.studPract.converters.RequestConverter;
import com.netcracker.studPract.converters.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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


    @RequestMapping("/profile/{id}")
    public String studentData(@PathVariable("id") int id, Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("currentAuth", usersService.findByUserLogin(name));
        List<StudentsEntity> studentsEntities = new ArrayList<StudentsEntity>();
        studentsEntities.add(studentsService.findById(id));
        model.addAttribute("student",(studentConverter.convert(studentsEntities)).get(0));
        model.addAttribute("listPractices", requestConverter.convert(requestsService.findByIdStudent(id)));
        return "profile";
    }

    @RequestMapping("/removeStudent/{id}")
    public String removeStudent(@PathVariable("id") int id){
        studentsService.deleteStudentById(id);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/removeCheckedStudents", method = RequestMethod.POST)
    public String removeCheckedStudents(@RequestParam(value = "id[]",required = false)List<String> id){

        for (String s : id) {
            studentsService.deleteStudentById(Integer.parseInt(s));
        }
        return "redirect:/admin";
    }

    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object addStudent(@Valid @ModelAttribute StudentFormValidator studentFormValidator, BindingResult result){

        if (result.hasErrors()) {
            return result.getAllErrors();
        } else{
            StudentsEntity studentsEntity = new StudentsEntity();
            UsersEntity usersEntity = new UsersEntity();
            UserRolesEntity userRolesEntity = new UserRolesEntity();
            studentsEntity.setAvgBall(Double.parseDouble(studentFormValidator.getAvgBall()));
            studentsEntity.setIdGroup(Integer.parseInt(studentFormValidator.getIdGroup()));
            studentsEntity.setIdSpec(Integer.parseInt(studentFormValidator.getIdSpec()));
            studentsEntity.setIsBudget(Byte.parseByte(studentFormValidator.getIsBudget()));
            usersEntity.setFirstName(studentFormValidator.getFirstName());
            usersEntity.setLastName(studentFormValidator.getLastName());
            usersEntity.setusername(studentFormValidator.getLogin());
            usersEntity.setPassword( org.apache.commons.codec.digest.DigestUtils.sha256Hex(studentFormValidator.getPassword()));
            userRolesEntity.setusername(studentFormValidator.getLogin());
            userRolesEntity.setUserrole("ROLE_STUDENT");
            usersEntity.setEnabled(1);
            usersService.saveUser(usersEntity,userRolesEntity);
            studentsEntity.setIdUser(usersService.findByUserLogin(studentFormValidator.getLogin()).getIdUsers());
            studentsService.saveStudent(studentsEntity);
        return studentsEntity;}
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
