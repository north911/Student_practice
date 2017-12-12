package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;
import com.netcracker.devschool.dev4.studPract.repository.AssigmentsRepository;
import com.netcracker.devschool.dev4.studPract.service.AssigmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AssigmentsServiceImpl implements AssigmentsService {

    @Autowired
    AssigmentsRepository assigmentsRepository;

    @Override
    public AssigmentsEntity saveAssigment(AssigmentsEntity assigmentsEntity) {
        return assigmentsRepository.save(assigmentsEntity);
    }

    @Override
    public Iterable<AssigmentsEntity> saveListAssigments(List<AssigmentsEntity> assigmentsEntities){
        return assigmentsRepository.save(assigmentsEntities);
    }
}
