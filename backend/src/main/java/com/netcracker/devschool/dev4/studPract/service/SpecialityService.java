package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;

import java.util.List;

public interface SpecialityService {

    SpecialityEntity save(SpecialityEntity specialityEntity);
    void deleteById(long id);
    List<SpecialityEntity> findAll();
    List<SpecialityEntity> findUserByUserName(String name);
}
