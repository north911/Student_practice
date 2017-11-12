package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;
import com.netcracker.devschool.dev4.studPract.repository.FacultiesRepository;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FacultiesServiceImpl implements FacultiesService {

    @Autowired
    FacultiesRepository facultiesRepository;

    @Override
    public FacultiesEntity saveFaculty(FacultiesEntity facultiesEntity) {
        return facultiesRepository.save(facultiesEntity);
    }

    @Override
    public void deleteFacultyById(int id) {
        facultiesRepository.delete(id);
    }

    @Override
    public List<FacultiesEntity> findAllFaculties() {
        return (List<FacultiesEntity>)facultiesRepository.findAll();
    }

    @Override
    public FacultiesEntity  findFacultyByName(String name) {
        return facultiesRepository.findFacultyByName(name);
    }
}
