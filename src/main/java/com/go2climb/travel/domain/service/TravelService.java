package com.go2climb.travel.domain.service;

import com.go2climb.travel.domain.entity.Travel;

import java.util.List;
import java.util.Optional;

public interface TravelService {
    List<Travel> getAll();
    List<Travel> getByAgencyId(Integer id);
    Optional<Travel> getById(Integer id);
    Travel save(Travel entity);
    Travel update(Travel entity);
    boolean deleteById(Integer id);
}
