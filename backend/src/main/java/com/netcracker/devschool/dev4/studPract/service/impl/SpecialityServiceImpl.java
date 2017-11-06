package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import com.netcracker.devschool.dev4.studPract.repository.SpecialityRepository;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpecialityServiceImpl implements SpecialityService{

@Autowired
    SpecialityRepository specialityRepository;

    @Override
    public SpecialityEntity saveSpeciality(SpecialityEntity specialityEntity) {
        return specialityRepository.save(specialityEntity);
    }

    @Override
    public void deleteSpecialityById(int id) {
        specialityRepository.delete(id);

    }

    @Override
    public List<SpecialityEntity> findAllSpecialities() {
        return (List<SpecialityEntity>)specialityRepository.findAll();
    }

    @Override
    public List<SpecialityEntity> findSpecialityByName(String name) {
        return null;
    }
}
