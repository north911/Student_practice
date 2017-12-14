package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;
import com.netcracker.devschool.dev4.studPract.repository.AssigmentsRepository;
import com.netcracker.devschool.dev4.studPract.service.AssigmentsService;
import com.netcracker.devschool.dev4.studPract.service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class AssigmentsServiceImpl implements AssigmentsService {

    @Autowired
    AssigmentsRepository assigmentsRepository;

    @Autowired
    RequestsService requestsService;


    @Override
    public AssigmentsEntity saveAssigment(AssigmentsEntity assigmentsEntity) {
        return assigmentsRepository.save(assigmentsEntity);
    }

    @Override
    public Iterable<AssigmentsEntity> saveListAssigments(List<AssigmentsEntity> assigmentsEntities){
        return assigmentsRepository.save(assigmentsEntities);
    }

    @Override
    public List<AssigmentsEntity> findByIdUser(int id) {
        return assigmentsRepository.findAllByIdUser(id);
    }

    @Override
    public List<AssigmentsEntity> findByIdRequest(int id) {
        return assigmentsRepository.findAllByIdRequest(id);
    }

    @Override
    public AssigmentsEntity findCurrentPracticeByIdUser(int id) {

        List<AssigmentsEntity> assigmentsEntities = assigmentsRepository.findAllByIdUser(id);
        for (AssigmentsEntity entity : assigmentsEntities) {
            if(requestsService.findRequestById(entity.getIdRequest()).getDateFrom().before(new Date()) &&
                    requestsService.findRequestById(entity.getIdRequest()).getDateTo().after(new Date())){
                return entity;
            }
            else {
                return null;
            }
        }
        return null;
    }
}
