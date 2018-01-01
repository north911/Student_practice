package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.FormValidators.HopValidator;
import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.*;
import com.netcracker.studPract.beans.ErrorViewObject;
import com.netcracker.studPract.beans.RequestsViewModel;
import com.netcracker.studPract.beans.SpecialityViewModel;
import com.netcracker.studPract.beans.StudentViewModel;
import com.netcracker.studPract.converters.RequestConverter;
import com.netcracker.studPract.converters.SpecialityConverter;
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

    @Autowired
    ErrorViewObject errorViewObject;

    @Autowired
    AssigmentsService assigmentsService;


    @RequestMapping(value = "/addhead", method = RequestMethod.POST)
    @ResponseBody
    public Object addHead(@Valid @ModelAttribute HopValidator hopValidator, BindingResult result){

        if (usersService.findByUserLogin(hopValidator.getHopLogin()) != null) {
            errorViewObject.setErrorMsg("login already exist");
            return errorViewObject;
        }
        if (result.hasErrors()) {
            return result.getAllErrors();
        } else {

            UsersEntity usersEntity = new UsersEntity();
            UserRolesEntity userRolesEntity = new UserRolesEntity();
            usersEntity.setusername(hopValidator.getHopLogin());
            usersEntity.setFirstName(hopValidator.getHopFirstName());
            usersEntity.setLastName(hopValidator.getHopLastName());
            usersEntity.setEnabled(1);
            usersEntity.setPassword(org.apache.commons.codec.digest.DigestUtils.sha256Hex(hopValidator.getHopPassword()));
            userRolesEntity.setUserrole("ROLE_HEAD");
            userRolesEntity.setusername(hopValidator.getHopLogin());
            usersService.saveUser(usersEntity, userRolesEntity);
            return usersEntity;
        }
    }

    @RequestMapping("/head/{id}")
    public String headData(@PathVariable("id") int id, Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (usersService.findByUserLogin(name).getIdUsers() == id) {
            model.addAttribute("currentAuth", usersService.findByUserLogin(name));
            model.addAttribute("listFaculties", facultiesService.findAllFaculties());
            model.addAttribute("listSpecialities", new ArrayList<SpecialityViewModel>(specialityConverter.convert(specialityService.findAllSpecialities())));
            model.addAttribute("hop", usersService.findById(id));
            model.addAttribute("visible", "hidden");
            model.addAttribute("listStudents", studentConverter.convert(studentsService.findForIdHead(id)));
            model.addAttribute("listRequests", requestConverter.convert(requestsService.findByHeadOfPractice(id)));
            return "head";
        } else return "redirect:/login";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/removeHead/{id}")
    public String removeHead(@PathVariable("id") int id){

        usersService.deleteUserById(id);
        requestsService.deleteByIdHead(id);

        return "redirect:/admin";
    }


    @RequestMapping("/findForRequest/{idR}")
    public String assignRequest(@PathVariable("idR") int idR, Model model) {

        if(requestsService.findRequestById(idR)!=null){
            List<RequestsEntity> requestsEntities = new ArrayList<>();
            model.addAttribute("listStudents", new ArrayList<StudentViewModel>(studentConverter.convert(studentsService.findForRequest(
                    requestsService.findRequestById(idR).getMinAvg(),
                    requestsService.findRequestById(idR).getIdSpec(),
                    requestsService.findRequestById(idR).getDateFrom(),
                    requestsService.findRequestById(idR).getDateTo(),
                    requestsService.findRequestById(idR).getIsBudget()))));
            model.addAttribute("requestId", idR);
            model.addAttribute("visible", "visible");
            requestsEntities.add(requestsService.findRequestById(idR));
            model.addAttribute("availableQ", requestConverter.convert(requestsEntities).get(0).getAvailableQuantity());
            return "head";}
        else return "redirect:/head/"+idR;
    }


    @RequestMapping(value = "/assignRequest/{id}", method = RequestMethod.POST)
    public String assignRequest(@PathVariable("id") int ida,
                                @RequestParam(value = "id[]", required = false) List<String> ids) {

        List<AssigmentsEntity> assigmentsEntityList = new ArrayList<>();

        for (String s : ids) {
            AssigmentsEntity assigmentsEntity = new AssigmentsEntity();
            assigmentsEntity.setIdUser(Integer.parseInt(s));
            assigmentsEntity.setIdRequest(ida);
            assigmentsEntityList.add(assigmentsEntity);
        }
        assigmentsService.saveListAssigments(assigmentsEntityList);
        return "redirect:/head/" + ida;
    }
}
