package com.example.back.repository;

import com.example.back.model.Coach;
import com.example.back.model.CoachCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoachCustomRepository extends JpaRepository<CoachCustom, Long>, CrudRepository<CoachCustom, Long> {

    @Query(value="SELECT c.message FROM CoachCustom c WHERE c.ratio = :ratio AND c.custom = :custom")
    public List<String> getMessages(@Param("ratio") Integer ratio, @Param("custom") Integer custom);
}
