package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<StudentsEntity,Integer> {
}
