package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HeadOfPracticeController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/addhead", method = RequestMethod.POST)
    @ResponseBody
    public UsersEntity addHead(@RequestParam(value = "firstName", required = false) String fname,
                               @RequestParam(value = "lastName", required = false)  String lname,
                               @RequestParam(value = "login", required = false)  String login,
                               @RequestParam(value = "password", required = false)  String password){

        UsersEntity usersEntity = new UsersEntity();
        UserRolesEntity userRolesEntity = new UserRolesEntity();
        usersEntity.setusername(login);
        usersEntity.setFirstName(fname);
        usersEntity.setLastName(lname);
        usersEntity.setEnabled(1);
        usersEntity.setPassword(password);
        userRolesEntity.setUserrole("ROLE_HEAD");
        userRolesEntity.setusername(login);
        usersService.saveUser(usersEntity,userRolesEntity);
        return usersEntity;
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
