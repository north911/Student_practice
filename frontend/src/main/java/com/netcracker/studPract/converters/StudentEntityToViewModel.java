package com.netcracker.studPract.converters;


import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import com.netcracker.studPract.beans.SpecialityViewModel;
import com.netcracker.studPract.beans.StudentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentEntityToViewModel implements StudentConverter{

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityService specialityService;

    @Autowired
    UsersService usersService;

    @Override
    public List<StudentViewModel> convert( List<StudentsEntity> studentsEntities) {

        List<StudentViewModel> studentViewModels = new ArrayList<>();


        for (StudentsEntity studentsEntity : studentsEntities) {
            StudentViewModel studentViewModel = new StudentViewModel();
            studentViewModel.setFirstName(usersService.findById(studentsEntity.getIdUser()).getFirstName());
            studentViewModel.setLastName(usersService.findById(studentsEntity.getIdUser()).getLastName());
            studentViewModel.setAvgBall(Integer.toString(studentsEntity.getAvgBall()));
            studentViewModel.setIsBudget(Byte.toString(studentsEntity.getIsBudget()));
            studentViewModel.setIdGroup(Integer.toString(studentsEntity.getIdGroup()));
            studentViewModel.setSpecName(specialityService.findById(studentsEntity.getIdSpec()).getNameSpec());
            studentViewModel.setFacName(facultiesService.findFacultyById(specialityService.findById(studentsEntity.getIdSpec()).getIdFaculty()).getFacultyName());
            studentViewModel.setIdUser(Integer.toString(studentsEntity.getIdUser()));
            studentViewModels.add(studentViewModel);
        }
        return studentViewModels;
    }

   /* public StudentViewModel soloConvert(StudentsEntity studentsEntity, FacultiesService facultiesService, SpecialityService specialityService){

        return studentViewModel;
    }*/
}
