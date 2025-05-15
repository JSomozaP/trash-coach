package com.example.back.repository;

import com.example.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value="SELECT COUNT(u) FROM User u WHERE u.status = true AND u.date BETWEEN :start AND :end")
    public Integer countPositif(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query(value="SELECT COUNT(u) FROM User u WHERE u.status = false AND u.date BETWEEN :start AND :end")
    public Integer countNegatif(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query(value="SELECT COUNT(u) FROM User u WHERE u.date BETWEEN :start AND :end")
    public Integer countAll(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
