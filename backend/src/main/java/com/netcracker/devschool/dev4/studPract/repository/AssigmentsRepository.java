package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssigmentsRepository extends CrudRepository<AssigmentsEntity, Integer> {

    List<AssigmentsEntity> findAllByIdRequest(int id);
    List<AssigmentsEntity> findAllByIdUser(int id);
    @Transactional
    @Modifying
    @Query("delete from AssigmentsEntity s where s.idUser = :idUser")
    void deleteByIdUser(@Param("idUser") int idUser);

    @Transactional
    @Modifying
    @Query("delete from AssigmentsEntity s where s.idRequest = :idRequest")
    void deleteByIdRequest(@Param("idRequest") int idRequest);

    AssigmentsEntity findByIdUserAndIdRequest(int idS,int idR);
}
