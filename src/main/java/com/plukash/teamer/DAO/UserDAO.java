package com.plukash.teamer.DAO;


import com.plukash.teamer.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    @Transactional
    @Query(value = "Select * from Teamer.users where teamed=false", nativeQuery = true)
    List<User> GetAllNotTeamed();


    @Transactional
    @Query(value = "Select * from Teamer.users join Teamer.user_comp on users.id=user_comp.user_id where user_comp.comp_id=1 or user_comp.comp_id=2 and teamed=false", nativeQuery = true)
    List<User> GetFront();

    @Transactional
    @Query(value = "Select * from Teamer.users join Teamer.user_comp on users.id=user_comp.user_id where user_comp.comp_id=67 or user_comp.comp_id=16 and teamed=false", nativeQuery = true)
    List<User> GetBack();

    @Transactional
    @Query(value = "Select * from Teamer.users join Teamer.user_comp on users.id=user_comp.user_id where user_comp.comp_id=81 or user_comp.comp_id=27 and teamed=false", nativeQuery = true)
    List<User> GetFund();

    @Transactional
    @Query(value = "Select * from Teamer.users join Teamer.user_comp on users.id=user_comp.user_id where user_comp.comp_id=63 or user_comp.comp_id=64 and teamed=false", nativeQuery = true)
    List<User> GetGame();

    @Transactional
    @Query(value = "Select * from Teamer.users join Teamer.user_comp on users.id=user_comp.user_id where user_comp.comp_id=43 or user_comp.comp_id=44 or user_comp.comp_id=41 and teamed=false", nativeQuery = true)
    List<User> GetManage();

    @Transactional
    @Query(value = "Select * from Teamer.users join Teamer.user_comp on users.id=user_comp.user_id where user_comp.comp_id=46 or user_comp.comp_id=47 or user_comp.comp_id=52 and teamed=false", nativeQuery = true)
    List<User> GetDesign();

    @Transactional
    @Query(value = "Select * from Teamer.users join Teamer.user_comp on users.id=user_comp.user_id where user_comp.comp_id=59 or user_comp.comp_id=11 and teamed=false", nativeQuery = true)
    List<User> GetML();


    @Transactional
    @Modifying
    @Query(value = "update Teamer.users set teamed=true where id=:id", nativeQuery = true)
    void SetInTeam(@Param("id") long id);


}
