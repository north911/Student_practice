package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecialityRepository extends CrudRepository<SpecialityEntity,Integer> {

    @Query("select s from SpecialityEntity s where s.idFaculty = :idFaculty")
    List<SpecialityEntity> findByFacultyId(@Param("idFaculty") int idFaculty);

    @Query("select s from SpecialityEntity s where s.nameSpec = :nameSpec")
    SpecialityEntity findIdByNameSpec(@Param("nameSpec") String nameSpec);


}
