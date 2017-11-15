package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.repository.StudentsRepository;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import org.springframework.stereotype.Controller;
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
public class AdminPageController {

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityService specialityService;

    @Autowired
    UsersService usersService;

    @Autowired
    StudentsService studentsService;

    @RequestMapping(value = "/addf", method = RequestMethod.POST)
    public FacultiesEntity addFaculty( @RequestParam(value = "fname", required = false) String fname){
        FacultiesEntity facultiesEntity = new FacultiesEntity();
        facultiesEntity.setFacultyName(fname);
        facultiesService.saveFaculty(facultiesEntity);
        return facultiesEntity;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listAllTables(Model model){
        model.addAttribute("faculty", new FacultiesEntity());
        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("listSpecialities", specialityService.findAllSpecialities());
        //model.addAttribute("listStudents",st
        return "/admin";
    }

    @RequestMapping(value = "/adds", method = RequestMethod.POST)
    public SpecialityEntity addSpeciality(@RequestParam(value = "sname", required = false) String sname,
                                          @RequestParam(value = "facname", required = false)  int facname){
        SpecialityEntity specialityEntity = new SpecialityEntity();
        specialityEntity.setIdFaculty(facultiesService.findFacultyById(facname).getIdFaculty());
        specialityEntity.setNameSpec(sname);
        specialityService.saveSpeciality(specialityEntity);
        return specialityEntity;
    }

    @RequestMapping(value = "/getSpecialitiesByFacultyId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityEntity> getSpecilaitiesByFacultyId(@PathVariable int id) {
        return specialityService.findByFacultyId(id);
    }

    @RequestMapping(value = "/addstud", method = RequestMethod.POST)
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
        studentsEntity.setAvgBall(avgBall);
        studentsEntity.setIdGroup(group);
        studentsEntity.setIdSpec(specialityService.findSpecialityByName(speciality).getIdSpec());
        if(!isBudget.equals(null))
        studentsEntity.setIsBudget((byte)1);
        usersEntity.setFirstName(fname);
        usersEntity.setLastName(lname);
        usersEntity.setRole("student");
        usersEntity.seteMail(login);
        usersEntity.setPassword(pass);
        usersEntity.setIdUsers(Integer.parseInt(login));
        usersService.saveUser(usersEntity);
        studentsEntity.setIdUser(Integer.parseInt(login));
        studentsService.saveStudent(studentsEntity);
        return studentsEntity;
    }

    @RequestMapping(value = "/getAllFaculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultiesEntity> getAllFaculties() {
        return facultiesService.findAllFaculties();
    }
}
