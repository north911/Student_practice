package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.repository.AssigmentsRepository;
import com.netcracker.devschool.dev4.studPract.repository.StudentsRepository;
import com.netcracker.devschool.dev4.studPract.repository.UserRolesRepository;
import com.netcracker.devschool.dev4.studPract.repository.UsersRepository;
import com.netcracker.devschool.dev4.studPract.service.AssigmentsService;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    AssigmentsService assigmentsService;


    @Override
    public StudentsEntity saveStudent(StudentsEntity studentsEntity, UsersEntity usersEntity) {

        UserRolesEntity userRolesEntity = new UserRolesEntity();
        userRolesEntity.setusername(usersEntity.getusername());
        userRolesEntity.setUserrole("ROLE_STUDENT");
        usersService.saveUser(usersEntity,userRolesEntity);
        studentsEntity.setIdUser(usersService.findByUserLogin(usersEntity.getusername()).getIdUsers());
        return studentsRepository.save(studentsEntity);

    }

    @Override
    public void deleteStudentById(int id) {
        usersService.deleteUserById(id);
        studentsRepository.delete(id);
        if(!assigmentsService.findByIdUser(id).isEmpty())
        assigmentsService.deleteByIdUser(id);
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

    @Override
    public List<StudentsEntity> findForRequest(double minAvg, int idSpec, Date startdate, Date enddate, byte isBudget) {
        return studentsRepository.findStudentsForRequest(minAvg, idSpec, startdate, enddate, isBudget);
    }

    @Override
    public List<StudentsEntity> findForIdHead(int idHEad) {
        return studentsRepository.findStudentsForHead(idHEad);
    }

    @Override
    public void deleteByIdSpec(int id) {
        if (!findAllByIdSpec(id).isEmpty())
            for (StudentsEntity studentsEntity : findAllByIdSpec(id)) {
                deleteStudentById(studentsEntity.getIdUser());
            }
    }

    @Override
    public List<StudentsEntity> findAllByIdSpec(int id) {
        return studentsRepository.findAllByIdSpec(id);
    }
}
