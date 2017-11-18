package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.entity.*;
import com.netcracker.devschool.dev4.studPract.repository.StudentsRepository;
import com.netcracker.devschool.dev4.studPract.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    @Autowired
    RequestsService requestsService;

    @RequestMapping(value = "/addf", method = RequestMethod.POST)
    public FacultiesEntity addFaculty( @RequestParam(value = "fname", required = false) String fname){
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

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listAllTables(Model model){
        model.addAttribute("faculty", new FacultiesEntity());
        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("listSpecialities", specialityService.findAllSpecialities());
        model.addAttribute("listStudents",studentsService.findAllStudents());
        model.addAttribute("listUsersStudents",usersService.findUsersByRole("student"));
        model.addAttribute("listRequests",requestsService.findAllRequests());
        return "/admin";
    }

    @RequestMapping(value = "/adds", method = RequestMethod.POST)
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
        try{
        studentsEntity.setAvgBall(avgBall);
        studentsEntity.setIdGroup(group);
        studentsEntity.setIdSpec(Integer.parseInt(speciality));
        if(isBudget.equals("budget"))
        studentsEntity.setIsBudget((byte)1);
        usersEntity.setFirstName(fname);
        usersEntity.setLastName(lname);
        usersEntity.setRole("student");
        usersEntity.seteMail(login);
        usersEntity.setPassword(pass);
        usersService.saveUser(usersEntity);
        studentsEntity.setIdUser(usersService.findByUserLogin(login).getIdUsers());
        studentsService.saveStudent(studentsEntity);}
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return studentsEntity;
    }

    @RequestMapping(value = "/getAllFaculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultiesEntity> getAllFaculties() {
        return facultiesService.findAllFaculties();
    }

    @RequestMapping(value = "/addreq", method = RequestMethod.POST)
    public RequestsEntity addRequest(@RequestParam(value = "company", required = false) String compName,
                                     @RequestParam(value = "dateFrom", required = false) String fromDate,
                                     @RequestParam(value = "dateTo", required = false) String toDate,
                                     @RequestParam(value = "idFac", required = false) String idFac,
                                     @RequestParam(value = "idSpec", required = false) String idSpec,
                                     @RequestParam(value = "quantity", required = false) String quantity,
                                     @RequestParam(value = "minAvg", required = false) String minAvg){


        RequestsEntity requestsEntity = new RequestsEntity();

        try{
        DateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
        try {
            Date start = format.parse(fromDate);
            requestsEntity.setDateFrom(start);
            Date end = format.parse(toDate);
            requestsEntity.setDateTo(end);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        requestsEntity.setCompanyName(compName);
        requestsEntity.setIdFaculty(Integer.parseInt(idFac));
        requestsEntity.setIdSpec(Integer.parseInt(idSpec));
        requestsEntity.setQuantity(Integer.parseInt(quantity));
        requestsEntity.setMinAvg(Double.parseDouble(minAvg));
        requestsService.save(requestsEntity);}
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return requestsEntity;
    }
}
