package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;

import java.util.List;

public interface RequestsService {
    RequestsEntity save(RequestsEntity requestsEntity);

    void deleteRequestById(int id);

    List<RequestsEntity> findAllRequests();

    List<RequestsEntity> findRequestByName(String name);

    List<RequestsEntity> findByHeadOfPractice(int id);

    RequestsEntity findRequestById(int id);

    List<RequestsEntity> findByIdStudent(int id);

    void deleteByIdHead(int id);

    List<RequestsEntity> findByIdSpec(int id);

    void deleteByIdSpec(int id);
}
