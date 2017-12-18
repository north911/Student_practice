package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.repository.AssigmentsRepository;
import com.netcracker.devschool.dev4.studPract.repository.RequestsRepository;
import com.netcracker.devschool.dev4.studPract.service.AssigmentsService;
import com.netcracker.devschool.dev4.studPract.service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RequestsServiceImpl implements RequestsService{

    @Autowired
    RequestsRepository requestsRepository;

    @Autowired
    AssigmentsService assigmentsService;

    @Override
    public RequestsEntity save(RequestsEntity requestsEntity) {

       return requestsRepository.save(requestsEntity);

    }

    @Override
    public void deleteRequestById(int id) {
        if(!assigmentsService.findByIdRequest(id).isEmpty())
        assigmentsService.deleteByIdRequest(id);
        requestsRepository.delete(id);

    }

    @Override
    public List<RequestsEntity> findAllRequests() {
        return (List<RequestsEntity>)requestsRepository.findAll();
    }

    @Override
    public List<RequestsEntity> findRequestByName(String name) {
        return null;
    }

    @Override
    public List<RequestsEntity> findByHeadOfPractice(int id) {
        return requestsRepository.findAllByIdHead(id);
    }

    @Override
    public List<RequestsEntity> findByIdStudent(int id) {
        return requestsRepository.findAllByIdUser(id);
    }

    @Override
    public RequestsEntity findRequestById(int id) {
        return requestsRepository.findOne(id);
    }

    @Override
    public void deleteByIdHead(int id) {
        requestsRepository.deleteByIdHead(id);
    }

    @Override
    public List<RequestsEntity> findByIdSpec(int id) {
        return requestsRepository.findAllByIdSpec(id);
    }

    @Override
    public void deleteByIdSpec(int id) {
        requestsRepository.deleteByIdSpec(id);
    }
}
