package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;

import java.util.List;

public interface AssigmentsService {

    AssigmentsEntity saveAssigment(AssigmentsEntity assigmentsEntity);
    public Iterable<AssigmentsEntity> saveListAssigments(List<AssigmentsEntity> assigmentsEntities);
}
