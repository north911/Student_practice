package com.netcracker.studPract.converters;


import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import com.netcracker.studPract.beans.SpecialityViewModel;
import com.netcracker.studPract.beans.StudentViewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentEntityToViewModel implements StudentConverter{

    @Override
    public List<StudentViewModel> convert(List<UsersEntity> usersEntities, List<StudentsEntity> studentsEntities, FacultiesService facultiesService, SpecialityService specialityService) {

        List<StudentViewModel> studentViewModels = new ArrayList<>();
        StudentEntityToViewModel studentEntityToViewModel = new StudentEntityToViewModel();

        for (StudentsEntity studentsEntity : studentsEntities) {
            studentViewModels.add(studentEntityToViewModel.soloConvert(usersEntities.stream().filter(UsersEntity -> UsersEntity.getIdUsers()==studentsEntity.getIdUser()).findFirst().get(), studentsEntity, facultiesService, specialityService));
        }


        return studentViewModels;
    }

    public StudentViewModel soloConvert(UsersEntity usersEntity, StudentsEntity studentsEntity, FacultiesService facultiesService, SpecialityService specialityService){
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setFirstName(usersEntity.getFirstName());
        studentViewModel.setLastName(usersEntity.getLastName());
        studentViewModel.setAvgBall(Integer.toString(studentsEntity.getAvgBall()));
        studentViewModel.setIsBudget(Byte.toString(studentsEntity.getIsBudget()));
        studentViewModel.setIdGroup(Integer.toString(studentsEntity.getIdGroup()));
        studentViewModel.setSpecName(specialityService.findById(studentsEntity.getIdSpec()).getNameSpec());
        studentViewModel.setFacName(facultiesService.findFacultyById(studentsEntity.getIdSpec()).getFacultyName());
        studentViewModel.setIdUser(Integer.toString(usersEntity.getIdUsers()));
        return studentViewModel;
    }
}
