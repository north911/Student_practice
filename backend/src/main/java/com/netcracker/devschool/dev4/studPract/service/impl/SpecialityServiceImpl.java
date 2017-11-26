package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import com.netcracker.devschool.dev4.studPract.repository.SpecialityRepository;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
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
    public SpecialityEntity findSpecialityByName(String name) {
        return specialityRepository.findIdByNameSpec(name);
    }

    @Override
    public List<SpecialityEntity> findByFacultyId(int id) {
        return specialityRepository.findByFacultyId(id);
    }

    @Override
    public SpecialityEntity findById(int id) {
        return specialityRepository.findOne(id);
    }
}
