package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.repository.StudentsRepository;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentsServiceImpl implements StudentsService{

 @Autowired
    StudentsRepository studentsRepository;

    @Override
    public StudentsEntity saveStudent(StudentsEntity studentsEntity) {
        return studentsRepository.save(studentsEntity);
    }

    @Override
    public void deleteStudentById(int id) {
        studentsRepository.delete(id);
    }

    @Override
    public List<StudentsEntity> findAllStudents() {
        return (List<StudentsEntity>) studentsRepository.findAll();
    }

    @Override
    public List<StudentsEntity> findStudentByName(String name) {
        return null;
    }
}
