package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestsRepository extends CrudRepository<RequestsEntity,Integer> {

    List<RequestsEntity> findAllByIdHead(int id);
}
