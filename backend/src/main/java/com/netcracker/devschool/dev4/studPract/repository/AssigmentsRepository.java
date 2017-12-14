package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssigmentsRepository extends CrudRepository<AssigmentsEntity, Integer> {

    List<AssigmentsEntity> findAllByIdRequest(int id);
    List<AssigmentsEntity> findAllByIdUser(int id);
}
