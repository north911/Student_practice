package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {


}
