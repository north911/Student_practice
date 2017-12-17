package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RequestsRepository extends CrudRepository<RequestsEntity,Integer> {

    List<RequestsEntity> findAllByIdHead(int id);

    @Query("select s from RequestsEntity s where s.idRequest in (select p.idRequest from AssigmentsEntity p where p.idUser= :idUser)")
    List<RequestsEntity> findAllByIdUser(@Param("idUser")int idUser);

    @Transactional
    @Modifying
    @Query("delete from RequestsEntity s where s.idHead = :idHead")
    void deleteByIdHead(@Param("idHead") int idHead);
}
