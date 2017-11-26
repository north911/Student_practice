package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FacultiesRepository extends CrudRepository<FacultiesEntity,Integer> {

    @Query("select s from FacultiesEntity s where s.facultyName = :facultyName")
    FacultiesEntity findFacultyByName(@Param("facultyName") String facultyName);

}
