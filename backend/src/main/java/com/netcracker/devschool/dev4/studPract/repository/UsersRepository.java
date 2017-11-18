package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

    @Query("select b from UsersEntity b where b.role = :role")
    List<UsersEntity> findUsersByRole(@Param("role") String role);

    @Query("select b from UsersEntity b where b.eMail = :eMail")
    UsersEntity findByUserLogin(@Param("eMail") String eMail);

}
