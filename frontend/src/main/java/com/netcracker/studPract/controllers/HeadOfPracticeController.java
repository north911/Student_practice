package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.FormValidators.HopValidator;
import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.*;
import com.netcracker.studPract.beans.RequestsViewModel;
import com.netcracker.studPract.beans.SpecialityViewModel;
import com.netcracker.studPract.beans.StudentViewModel;
import com.netcracker.studPract.converters.RequestConverter;
import com.netcracker.studPract.converters.SpecialityConverter;
import com.netcracker.studPract.converters.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HeadOfPracticeController {

    @Autowired
    UsersService usersService;

    @Autowired
    StudentConverter studentConverter;

    @Autowired
    StudentsService studentsService;

    @Autowired
    RequestConverter requestConverter;

    @Autowired
    RequestsService requestsService;

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityConverter specialityConverter;

    @Autowired
    SpecialityService specialityService;



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
        usersEntity.setPassword( org.apache.commons.codec.digest.DigestUtils.sha256Hex( hopValidator.getHopPassword()));
        userRolesEntity.setUserrole("ROLE_HEAD");
        userRolesEntity.setusername(hopValidator.getHopLogin());
        usersService.saveUser(usersEntity,userRolesEntity);
        return usersEntity;}
    }

    @RequestMapping("/head/{id}")
    public String headData(@PathVariable("id") int id, Model model){

        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("listSpecialities",new ArrayList<SpecialityViewModel>(specialityConverter.convert(specialityService.findAllSpecialities())));
        model.addAttribute("hop", usersService.findById(id));
        model.addAttribute("visible", "hidden");
        model.addAttribute("listStudents",new ArrayList<StudentViewModel>(studentConverter.convert(studentsService.findForIdHead(id))));
        model.addAttribute("listRequests",new ArrayList<RequestsViewModel>(requestConverter.convert(requestsService.findByHeadOfPractice(id))));
        return "head";
    }
}
