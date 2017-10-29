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
    public UsersEntity save(UsersEntity user) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<UsersEntity> findAll() {
        return null;
    }

    @Override
    public List<UsersEntity> findUserByUserName(String name) {
        return null;
    }
}

