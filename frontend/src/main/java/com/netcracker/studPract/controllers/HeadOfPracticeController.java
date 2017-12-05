package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.FormValidators.HopValidator;
import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HeadOfPracticeController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/addhead", method = RequestMethod.POST)
    @ResponseBody
    public Object addHead(@Valid @ModelAttribute HopValidator hopValidator, BindingResult result){


        if (result.hasErrors()) {
            return result.getAllErrors();
        } else{
        UsersEntity usersEntity = new UsersEntity();
        UserRolesEntity userRolesEntity = new UserRolesEntity();
        usersEntity.setusername(hopValidator.getHopLogin());
        usersEntity.setFirstName(hopValidator.getHopFirstName());
        usersEntity.setLastName(hopValidator.getHopLastName());
        usersEntity.setEnabled(1);
        usersEntity.setPassword(hopValidator.getHopPassword());
        userRolesEntity.setUserrole("ROLE_HEAD");
        userRolesEntity.setusername(hopValidator.getHopLogin());
        usersService.saveUser(usersEntity,userRolesEntity);
        return usersEntity;}
    }

    @RequestMapping("/head/{id}")
    public String headData(@PathVariable("id") int id, Model model){
       /* model.addAttribute("user",usersService.findById(id));
        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("student", studentsService.findById(id));
        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("listSpecialities", specialityService.findAllSpecialities());
        model.addAttribute("listStudents",studentsService.findAllStudents());
        model.addAttribute("listRequests",requestsService.findAllRequests());*/
        return "head";
    }
}
