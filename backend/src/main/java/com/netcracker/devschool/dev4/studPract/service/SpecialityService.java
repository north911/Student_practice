package com.netcracker.devschool.dev4.studPract.service;

import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;

import java.util.List;

public interface SpecialityService {

    SpecialityEntity saveSpeciality(SpecialityEntity specialityEntity);
    void deleteSpecialityById(int id);
    List<SpecialityEntity> findAllSpecialities();
    List<SpecialityEntity> findSpecialityByName(String name);
}
