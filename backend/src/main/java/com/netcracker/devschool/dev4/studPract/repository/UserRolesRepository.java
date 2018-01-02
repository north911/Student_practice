package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.UserRolesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRolesRepository extends CrudRepository<UserRolesEntity, Integer> {

    @Query("select b from UserRolesEntity b where b.username = :username")
    UserRolesEntity findByUsername(@Param("username") String username);
}
