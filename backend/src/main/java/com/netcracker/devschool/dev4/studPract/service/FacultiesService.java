package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;

import java.util.List;

public interface FacultiesService {

    FacultiesEntity saveFaculty(FacultiesEntity facultiesEntity);
    void deleteFacultyById(int id);
    List<FacultiesEntity> findAllFaculties();
    FacultiesEntity findFacultyByName(String name);
    FacultiesEntity findFacultyById(int id);
}
