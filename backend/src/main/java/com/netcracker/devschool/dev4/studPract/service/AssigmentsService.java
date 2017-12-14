package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;

import java.util.List;

public interface AssigmentsService {

    AssigmentsEntity saveAssigment(AssigmentsEntity assigmentsEntity);

    Iterable<AssigmentsEntity> saveListAssigments(List<AssigmentsEntity> assigmentsEntities);
    List<AssigmentsEntity> findByIdRequest(int id);
    List<AssigmentsEntity> findByIdUser(int id);
    AssigmentsEntity findCurrentPracticeByIdUser (int id);

}
