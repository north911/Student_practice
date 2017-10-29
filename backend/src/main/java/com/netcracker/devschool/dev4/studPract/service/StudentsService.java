package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;

import java.util.List;

public interface StudentsService {

   StudentsEntity save(StudentsEntity studentsEntity);
    void deleteById(long id);
    List<StudentsEntity> findAll();
    List<StudentsEntity> findUserByUserName(String name);
}
