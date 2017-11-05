package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.repository.UsersRepository;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UsersEntity saveUser(UsersEntity user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        usersRepository.deleteById(id);
    }

    @Override
    public List<UsersEntity> findAllUsers() {
        return (List<UsersEntity>)usersRepository.findAll();
    }

    @Override
    public List<UsersEntity> findUserByName(String name) {
        return null;
    }
}

