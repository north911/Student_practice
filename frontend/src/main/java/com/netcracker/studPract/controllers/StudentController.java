package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public StudentsEntity addStudent(@RequestParam(value = "firstName", required = false) String fname,
                                     @RequestParam(value = "lastName", required = false) String lname,
                                     @RequestParam(value = "speciality", required = false) String speciality,
                                     @RequestParam(value = "facname", required = false) int fac,
                                     @RequestParam(value = "avgB", required = false) int avgBall,
                                     @RequestParam(value = "isBudget", required = false) String isBudget,
                                     @RequestParam(value = "group", required = false) int group,
                                     @RequestParam(value = "login", required = false)  String login,
                                     @RequestParam(value = "pass", required = false) String pass){
        StudentsEntity studentsEntity = new StudentsEntity();
        UsersEntity usersEntity = new UsersEntity();
        UserRolesEntity userRolesEntity = new UserRolesEntity();
        try{
            studentsEntity.setAvgBall(avgBall);
            studentsEntity.setIdGroup(group);
            studentsEntity.setIdSpec(Integer.parseInt(speciality));
            if(isBudget.equals("budget"))
                studentsEntity.setIsBudget((byte)1);
            usersEntity.setFirstName(fname);
            usersEntity.setLastName(lname);
            usersEntity.setusername(login);
            usersEntity.setPassword(pass);
            userRolesEntity.setusername(login);
            userRolesEntity.setUserrole("ROLE_STUDENT");
            usersEntity.setEnabled(1);
            usersService.saveUser(usersEntity,userRolesEntity);
            studentsEntity.setIdUser(usersService.findByUserLogin(login).getIdUsers());
            studentsService.saveStudent(studentsEntity);}
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return studentsEntity;
    }
}
