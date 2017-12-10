package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;

import java.util.Date;
import java.util.List;

public interface StudentsService {

   StudentsEntity saveStudent(StudentsEntity studentsEntity);
    void deleteStudentById(int id);
    List<StudentsEntity> findAllStudents();
    List<StudentsEntity> findStudentByName(String name);
    StudentsEntity findById(int id);
    List<StudentsEntity> findForRequest(double minAvg, int idSpec, Date startdate, Date enddate, byte isBudget);
}
