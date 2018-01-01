package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;

import java.util.Date;
import java.util.List;

public interface StudentsService {

 StudentsEntity saveStudent(StudentsEntity studentsEntity, UsersEntity usersEntity);

 void deleteStudentById(int id);

 List<StudentsEntity> findAllStudents();

 List<StudentsEntity> findStudentByName(String name);

 StudentsEntity findById(int id);

 List<StudentsEntity> findForRequest(double minAvg, int idSpec, Date startdate, Date enddate, byte isBudget);

 List<StudentsEntity> findForIdHead(int idHEad);

 void deleteByIdSpec(int id);

 List<StudentsEntity> findAllByIdSpec(int id);
}
