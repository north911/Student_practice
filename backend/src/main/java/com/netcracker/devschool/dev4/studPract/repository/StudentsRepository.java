package com.netcracker.devschool.dev4.studPract.repository;

import com.netcracker.devschool.dev4.studPract.entity.StudentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StudentsRepository extends CrudRepository<StudentsEntity,Integer> {

    @Query("select l from StudentsEntity l where l.idSpec = :sid and l.avgBall >= :minavg and l.isBudget= :isBudget" +
            " and not exists (select p from RequestsEntity p where p.idRequest in (select a.idRequest from AssigmentsEntity a where " +
            "a.idUser = l.idUser) and ((:start between p.dateFrom and p.dateTo) or (:endd between p.dateFrom and p.dateTo)))")
    List<StudentsEntity> findStudentsForRequest(@Param("minavg") double minavg,
                                                @Param("sid") int sid,
                                                @Param("start") Date start,
                                                @Param("endd") Date end,
                                                @Param("isBudget") byte isBudget);

}
