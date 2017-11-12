package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.repository.RequestsRepository;
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

    @Override
    public RequestsEntity save(RequestsEntity requestsEntity) {
        return requestsRepository.save(requestsEntity);
    }

    @Override
    public void deleteRequestById(int id) {

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
}
