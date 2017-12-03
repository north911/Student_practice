package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.repository.StudentsRepository;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentsServiceImpl implements StudentsService{

 @Autowired
    StudentsRepository studentsRepository;

    @Override
    public StudentsEntity saveStudent(StudentsEntity studentsEntity) {

        if(studentsEntity.getAvgBall() > 4 && studentsEntity.getAvgBall() < 10 &&
                studentsEntity.getIdSpec()!=0 && studentsEntity.getIdGroup() > 9999 &&
                studentsEntity.getIdGroup()<=99999 && studentsEntity.getIdUser() != 0 )
        return studentsRepository.save(studentsEntity);
        else return null;
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

    @Override
    public StudentsEntity findById(int id) {
        return studentsRepository.findOne(id);
    }
}
