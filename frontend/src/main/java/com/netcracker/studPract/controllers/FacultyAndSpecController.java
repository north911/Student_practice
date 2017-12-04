package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;
import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FacultyAndSpecController {

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityService specialityService;

    @RequestMapping(value = "/createFaculty", method = RequestMethod.POST)
    @ResponseBody
    public FacultiesEntity addFaculty(@RequestParam(value = "fname", required = false) String fname){
        FacultiesEntity facultiesEntity = new FacultiesEntity();

        try{
            facultiesEntity.setFacultyName(fname);
            facultiesService.saveFaculty(facultiesEntity);}
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return facultiesEntity;
    }

    @RequestMapping(value = "/createSpeciality", method = RequestMethod.POST)
    @ResponseBody
    public SpecialityEntity addSpeciality(@RequestParam(value = "sname", required = false) String sname,
                                          @RequestParam(value = "facname", required = false)  int facname){
        SpecialityEntity specialityEntity = new SpecialityEntity();
        try{
            specialityEntity.setIdFaculty(facultiesService.findFacultyById(facname).getIdFaculty());
            specialityEntity.setNameSpec(sname);
            specialityService.saveSpeciality(specialityEntity);}
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return specialityEntity;
    }

    @RequestMapping("/removeSpec/{id}")
    public String removeSpec(@PathVariable("id") int id){
        specialityService.deleteSpecialityById(id);

        return "redirect:/admin";
    }
}
