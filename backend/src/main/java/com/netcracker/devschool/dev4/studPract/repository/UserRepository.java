package com.netcracker.devschool.dev4.studPract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.netcracker.devschool.dev4.studPract.entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findUsersByFirstName(String fiestName);
}
