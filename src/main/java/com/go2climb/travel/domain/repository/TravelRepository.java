package com.go2climb.travel.domain.repository;

import com.go2climb.travel.domain.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {
    List<Travel> findByAgency(Integer id);
}
