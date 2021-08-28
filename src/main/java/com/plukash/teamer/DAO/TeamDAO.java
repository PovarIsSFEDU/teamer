package com.plukash.teamer.DAO;

import com.plukash.teamer.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.beans.Transient;

public interface TeamDAO extends JpaRepository<Team, Long> {
//
//    @Transactional
//    @Modifying
//    @Query(value = "",nativeQuery = true)
//    void AddToTeam(@Param("userId") long id);
//
//    @Transactional
//    @Modifying
//    @Query(value = "",nativeQuery = true)
//    void DeleteFromTeam(@Param("userId") long id);

    @Transactional
    @Modifying
    @Query(value = "insert into Teamer.teams(id, captain, p1,p2,p3,p4) values(DEFAULT, :cap, :p1, :p2, :p3, :p4)", nativeQuery = true)
    void Gen5(@Param("cap") long id, @Param("p1") long p1, @Param("p2") long p2, @Param("p3") long p3, @Param("p4") long p4);

    @Transactional
    @Modifying
    @Query(value = "insert into Teamer.teams(id, captain, p1,p2,p3) values(DEFAULT, :cap, :p1, :p2, :p3)", nativeQuery = true)
    void Gen4(@Param("cap") long id, @Param("p1") long p1, @Param("p2") long p2, @Param("p3") long p3);

    @Transactional
    @Modifying
    @Query(value = "insert into Teamer.teams(id, captain, p1,p2) values(:id, :cap, :p1, :p2)", nativeQuery = true)
    void Gen3(@Param("cap") long cap_id, @Param("p1") long p1, @Param("p2") long p2, @Param("id") long id);
}
