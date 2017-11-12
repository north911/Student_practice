/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
package com.netcracker.studPract.controllers;

import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;
import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TestController {

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityService specialityService;

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "loginpage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String pass){
        String result;
        switch (email){
            case "admin@gmail.com":
                result = "admin";
            break;
            case "head@gmail.com":
                result = "head";
                break;
                default:
                    result= "profile";
        }
        return result;

    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(){
                return "loginpage";
    }

    /*@RequestMapping(value = "/admin", method = RequestMethod.GET)
     public String goToAdmin() {
               return "admin";
           }*/

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String goToProfile() {
        return "profile";
    }

    @RequestMapping(value = "/head", method = RequestMethod.GET)
    public String goToHead() {
        return "head";
    }

    /*@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCabinet(@ModelAttribute("faculty")FacultiesEntity facultiesEntity){
        facultiesService.saveFaculty(facultiesEntity);
        return "/admin";
    }*/

    @RequestMapping(value = "/addf", method = RequestMethod.POST)
    public FacultiesEntity addFaculty( @RequestParam(value = "fname", required = false) String fname){
        FacultiesEntity facultiesEntity = new FacultiesEntity();
        facultiesEntity.setFacultyName(fname);
        facultiesService.saveFaculty(facultiesEntity);
        return facultiesEntity;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listFaculties(Model model){
        model.addAttribute("faculty", new FacultiesEntity());
        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("listSpecialities", specialityService.findAllSpecialities());
        return "/admin";
    }

    @RequestMapping(value = "/adds", method = RequestMethod.POST)
    public SpecialityEntity addSpeciality(@RequestParam(value = "sname", required = false) String sname,
                                          @RequestParam(value = "facname", required = false)  String facname){
        SpecialityEntity specialityEntity = new SpecialityEntity();
        specialityEntity.setIdFaculty(facultiesService.findFacultyByName(facname).getIdFaculty());
        specialityEntity.setNameSpec(sname);
        specialityService.saveSpeciality(specialityEntity);
        return specialityEntity;
    }

   @RequestMapping(value = "/getSpecialitiesByFacultyId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityEntity> getSpecilaitiesByFacultyId(@PathVariable int id) {
        return specialityService.findByFacultyId(id);
    }

    @RequestMapping(value = "/getAllFaculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultiesEntity> getAllFaculties() {
        return facultiesService.findAllFaculties();
    }



}

