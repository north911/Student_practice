package com.netcracker.devschool.dev4.studPract.service;


import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;

import java.util.List;

public interface UsersService {
    UsersEntity saveUser(UsersEntity user);
    void deleteUserById(int id);
    List<UsersEntity> findAllUsers();
    List<UsersEntity> findUserByName(String name);
    List<UsersEntity> findUsersByRole(String role);
    UsersEntity findByUserLogin(String login);
    UsersEntity findById(int id);
}
