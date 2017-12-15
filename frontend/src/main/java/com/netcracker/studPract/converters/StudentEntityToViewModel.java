package com.netcracker.studPract.converters;


import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.*;
import com.netcracker.studPract.beans.SpecialityViewModel;
import com.netcracker.studPract.beans.StudentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class StudentEntityToViewModel implements StudentConverter{

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityService specialityService;

    @Autowired
    UsersService usersService;

    @Autowired
    AssigmentsService assigmentsService;

    @Autowired
    RequestsService requestsService;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd", Locale.getDefault());

    @Override
    public List<StudentViewModel> convert( List<StudentsEntity> studentsEntities) {

        List<StudentViewModel> studentViewModels = new ArrayList<>();


        for (StudentsEntity studentsEntity : studentsEntities) {
            StudentViewModel studentViewModel = new StudentViewModel();
            studentViewModel.setFirstName(usersService.findById(studentsEntity.getIdUser()).getFirstName());
            studentViewModel.setLastName(usersService.findById(studentsEntity.getIdUser()).getLastName());
            studentViewModel.setAvgBall(Double.toString(studentsEntity.getAvgBall()));
            studentViewModel.setIsBudget(Byte.toString(studentsEntity.getIsBudget()));
            studentViewModel.setIdGroup(Integer.toString(studentsEntity.getIdGroup()));
            studentViewModel.setSpecName(specialityService.findById(studentsEntity.getIdSpec()).getNameSpec());
            studentViewModel.setFacName(facultiesService.findFacultyById(specialityService.findById(studentsEntity.getIdSpec()).getIdFaculty()).getFacultyName());
            studentViewModel.setIdUser(Integer.toString(studentsEntity.getIdUser()));
            AssigmentsEntity assigmentsEntity = assigmentsService.findCurrentPracticeByIdUser(studentsEntity.getIdUser());
            if(assigmentsEntity!=null){
                studentViewModel.setCompanyName(requestsService.findRequestById(assigmentsEntity.getIdRequest()).getCompanyName());
                studentViewModel.setStatus("is on practice");
                studentViewModel.setPeriod("from "+simpleDateFormat.format(requestsService.findRequestById( assigmentsEntity.getIdRequest()).getDateFrom())+ " to "
                        + simpleDateFormat.format(requestsService.findRequestById(assigmentsEntity.getIdRequest()).getDateTo()));
            }
            else{
                studentViewModel.setStatus("available");
            }
            studentViewModels.add(studentViewModel);
        }
        return studentViewModels;
    }

}
