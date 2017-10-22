package com.netcracker.devschool.dev4.studPract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.netcracker.devschool.dev4.studPract.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
