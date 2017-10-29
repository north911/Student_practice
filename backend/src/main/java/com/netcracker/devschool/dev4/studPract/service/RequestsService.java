package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;

import java.util.List;

public interface RequestsService {
    RequestsEntity save(RequestsEntity requestsEntity);
    void deleteById(long id);
    List<RequestsEntity> findAll();
    List<RequestsEntity> findUserByUserName(String name);
}
