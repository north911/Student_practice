package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.FormValidators.StudentFormValidator;
import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentsService studentsService;

    @Autowired
    UsersService usersService;




    @RequestMapping(value = "/removeCheckedStudents", method = RequestMethod.POST)
    public String testCB(@RequestParam(value = "id[]",required = false)List<String> id){

        for (String s : id) {
            studentsService.deleteStudentById(Integer.parseInt(s));

        }
        return "redirect:/admin";
    }

    @RequestMapping("/profile/{id}")
    public String studentData(@PathVariable("id") int id, Model model){
     /*   model.addAttribute("user",usersService.findById(id));
        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("student", studentsService.findById(id));
        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("listSpecialities", specialityService.findAllSpecialities());
        model.addAttribute("listStudents",studentsService.findAllStudents());
        model.addAttribute("listRequests",requestsService.findAllRequests());*/
        return "profile";
    }

    @RequestMapping("/removeStudent/{id}")
    public String removeStudent(@PathVariable("id") int id){
        studentsService.deleteStudentById(id);
        usersService.deleteUserById(id);

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
            studentsEntity.setAvgBall(Integer.parseInt(studentFormValidator.getAvgBall()));
            studentsEntity.setIdGroup(Integer.parseInt(studentFormValidator.getIdGroup()));
            studentsEntity.setIdSpec(Integer.parseInt(studentFormValidator.getIdSpec()));
            if(studentFormValidator.getAvgBall().equals("budget"))
                studentsEntity.setIsBudget((byte)1);
            usersEntity.setFirstName(studentFormValidator.getFirstName());
            usersEntity.setLastName(studentFormValidator.getLastName());
            usersEntity.setusername(studentFormValidator.getLogin());
            usersEntity.setPassword(studentFormValidator.getPassword());
            userRolesEntity.setusername(studentFormValidator.getLogin());
            userRolesEntity.setUserrole("ROLE_STUDENT");
            usersEntity.setEnabled(1);
            usersService.saveUser(usersEntity,userRolesEntity);
            studentsEntity.setIdUser(usersService.findByUserLogin(studentFormValidator.getLogin()).getIdUsers());
            studentsService.saveStudent(studentsEntity);
        return studentsEntity;}
    }
}
