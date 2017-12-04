package com.netcracker.studPract.controllers;
import com.netcracker.devschool.dev4.studPract.entity.*;
import com.netcracker.devschool.dev4.studPract.service.*;
import com.netcracker.studPract.beans.HopViewModel;
import com.netcracker.studPract.beans.SpecialityViewModel;
import com.netcracker.studPract.beans.StudentViewModel;
import com.netcracker.studPract.converters.HopConverter;
import com.netcracker.studPract.converters.SpecialityConverter;
import com.netcracker.studPract.converters.StudentConverter;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
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

    @Autowired
    RequestsService requestsService;

    @Autowired
    SpecialityConverter specialityConverter;

    @Autowired
    StudentConverter studentConverter;

    @Autowired
    HopConverter hopConverter;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listAllTables(Model model){

        model.addAttribute("faculty", new FacultiesEntity());
        model.addAttribute("listFaculties", facultiesService.findAllFaculties());
        model.addAttribute("listSpecialities",new ArrayList<SpecialityViewModel>(specialityConverter.convert(specialityService.findAllSpecialities())));
        model.addAttribute("listStudents",new ArrayList<StudentViewModel>(studentConverter.convert(usersService.findAllUsers(),studentsService.findAllStudents())));
        model.addAttribute("listRequests",requestsService.findAllRequests());
        model.addAttribute("listHops",new ArrayList<HopViewModel>(hopConverter.convert(usersService.findByRole("ROLE_HEAD"))));
        return "/admin";
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
