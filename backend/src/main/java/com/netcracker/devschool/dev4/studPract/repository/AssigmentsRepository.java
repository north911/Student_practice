package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssigmentsRepository extends CrudRepository<AssigmentsEntity, Integer> {

    List<AssigmentsEntity> findAllByIdRequest(int id);
    List<AssigmentsEntity> findAllByIdUser(int id);
    @Query("delete from AssigmentsEntity s where s.idUser = :idUser")
    void deleteByIdUser(@Param("idUser") int idUser);

    @Query("delete from AssigmentsEntity s where s.idRequest = :idRequest")
    void deleteByIdRequest(@Param("idRequest") int idRequest);
}
