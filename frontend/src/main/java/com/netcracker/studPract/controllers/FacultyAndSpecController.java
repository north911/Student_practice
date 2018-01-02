package com.netcracker.studPract.controllers;


import com.netcracker.studPract.FormValidators.FacultyValidator;
import com.netcracker.studPract.FormValidators.SpecialityValidator;
import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;
import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import com.netcracker.studPract.beans.ErrorViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class FacultyAndSpecController {

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityService specialityService;

    @Autowired
    ErrorViewObject errorViewObject;


    @RequestMapping(value = "/createFaculty", method = RequestMethod.POST)
    @ResponseBody
    public Object addFaculty(@Valid @ModelAttribute FacultyValidator facultyValidator, BindingResult result){

        if (facultiesService.findFacultyByName(facultyValidator.getFacName()) != null) {
            errorViewObject.setErrorMsg("faculty already exist");
            return errorViewObject;
        }
        if (result.hasErrors()) {
            return result.getAllErrors();
        } else {
            FacultiesEntity facultiesEntity = new FacultiesEntity();
            facultiesEntity.setFacultyName(facultyValidator.getFacName());
            facultiesService.saveFaculty(facultiesEntity);
            return facultiesEntity;
        }
    }


    @RequestMapping(value = "/createSpeciality", method = RequestMethod.POST)
    @ResponseBody
    public Object addSpeciality(@Valid @ModelAttribute SpecialityValidator specialityValidator, BindingResult result){

        if (specialityService.findSpecialityByName(specialityValidator.getSpecName()) != null) {
            errorViewObject.setErrorMsg("speciality already exist");
            return errorViewObject;
        }
        if (result.hasErrors()) {
            return result.getAllErrors();
        } else {
            SpecialityEntity specialityEntity = new SpecialityEntity();
            specialityEntity.setIdFaculty(facultiesService.findFacultyById(Integer.parseInt(specialityValidator.getFacultyId())).getIdFaculty());
            specialityEntity.setNameSpec(specialityValidator.getSpecName());
            specialityService.saveSpeciality(specialityEntity);
            return specialityEntity;

        }
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/removeSpec/{id}")
    public String removeSpec(@PathVariable("id") int id){
        specialityService.deleteSpecialityById(id);

        return "redirect:/admin";
    }
}
