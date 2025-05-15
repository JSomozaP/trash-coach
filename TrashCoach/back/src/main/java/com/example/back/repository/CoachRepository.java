package com.example.back.repository;

import com.example.back.model.Coach;
import com.example.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long>, CrudRepository<Coach, Long> {

    @Query(value="SELECT c.message FROM Coach c WHERE c.ratio = :ratio")
    public List<String> getMessage(@Param("ratio") Integer ratio);
}
