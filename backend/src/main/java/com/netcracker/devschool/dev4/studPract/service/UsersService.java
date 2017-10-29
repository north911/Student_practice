package com.netcracker.devschool.dev4.studPract.service;


import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;

import java.util.List;

public interface UsersService {
    UsersEntity save(UsersEntity user);
    void deleteById(long id);
    List<UsersEntity> findAll();
    List<UsersEntity> findUserByUserName(String name);
}
