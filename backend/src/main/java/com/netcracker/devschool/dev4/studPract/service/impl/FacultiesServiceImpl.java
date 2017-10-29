package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;
import com.netcracker.devschool.dev4.studPract.repository.FacultiesRepository;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FacultiesServiceImpl implements FacultiesService {

    @Autowired
    FacultiesRepository facultiesRepository;

    @Override
    public FacultiesEntity save(FacultiesEntity facultiesEntity) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<FacultiesEntity> findAll() {
        return null;
    }

    @Override
    public List<FacultiesEntity> findUserByUserName(String name) {
        return null;
    }
}
