package com.example.project.repository;

import com.example.project.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge, Long> {

    List<Charge> findByUserId(Long id);

    @Query(value = "SELECT * FROM demo.event WHERE user_id=?1 AND MONTH(date)=?2", nativeQuery = true)
    List<Charge> findByUserIdAndMonth(Long id, Integer month);

    @Query(value = "SELECT SUM(amount) FROM demo.event WHERE user_id=?1 GROUP BY user_id;", nativeQuery = true)
    Double getTotalCharges(Long id);
}