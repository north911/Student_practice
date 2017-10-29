package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;

import java.util.List;

public interface FacultiesService {

    FacultiesEntity save(FacultiesEntity facultiesEntity);
    void deleteById(long id);
    List<FacultiesEntity> findAll();
    List<FacultiesEntity> findUserByUserName(String name);
}
