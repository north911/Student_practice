package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.Users;
import com.netcracker.devschool.dev4.studPract.repository.UserRepository;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users addUser(Users user){

    Users savedUser = userRepository.saveAndFlush(user);
    return savedUser;
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    /*@Override
    public Users getByName(String name) {
        return userRepository.findByName(name);
    }*/

    @Override
    public Users editUser(Users user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }
}

