package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {


    @Query("select b from UsersEntity b where b.username = :username")
    UsersEntity findByUsername(@Param("username") String username);

    @Query("select b from UsersEntity b where b.username in(select c.username from UserRolesEntity c where c.role = :role)")
    List<UsersEntity> findUsersByRole(@Param("role") String role);

}
