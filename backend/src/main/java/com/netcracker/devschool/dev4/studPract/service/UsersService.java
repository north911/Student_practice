package com.netcracker.devschool.dev4.studPract.service;


import com.netcracker.devschool.dev4.studPract.entity.Users;

import java.util.List;

public interface UsersService {
    Users addUser(Users user);
    void delete(long id);
   // Users getByName(String name);
    Users editUser(Users user);
    List<Users> getAll();
}
