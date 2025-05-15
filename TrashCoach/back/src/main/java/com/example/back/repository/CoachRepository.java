package com.example.back.repository;

import com.example.back.model.Coach;
import com.example.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long>, CrudRepository<Coach, Long> {
}
