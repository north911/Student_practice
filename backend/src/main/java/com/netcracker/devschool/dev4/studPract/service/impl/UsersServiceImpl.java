package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.repository.UserRolesRepository;
import com.netcracker.devschool.dev4.studPract.repository.UsersRepository;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    @Override
    public UsersEntity findByUserLogin(String login) {
        return usersRepository.findByUsername(login);
    }

    @Override
    public UsersEntity findById(int id) {
        return usersRepository.findOne(id);
    }

    @Override
    public List<UsersEntity> findByRole(String role) {
        return usersRepository.findUsersByRole(role);
    }

    @Override
    public UsersEntity saveUser(UsersEntity user, UserRolesEntity userRole) {

        userRolesRepository.save(userRole);
        return usersRepository.save(user);

    }

    @Override
    public void deleteUserById(int id) {
        userRolesRepository.delete(userRolesRepository.findByUsername(usersRepository.findOne(id).getusername()));
        usersRepository.delete(id);
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

