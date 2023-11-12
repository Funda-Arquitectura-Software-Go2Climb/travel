package com.go2climb.travel.service;

import com.go2climb.travel.domain.entity.Travel;
import com.go2climb.travel.domain.repository.TravelRepository;
import com.go2climb.travel.domain.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {
    @Autowired
    private TravelRepository travelRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Travel> getAll() {
        return travelRepository.findAll();
    }

    @Override
    public List<Travel> getByAgencyId(Integer id) {
        return travelRepository.findByAgency(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Travel> getById(Integer id) {
        if (travelRepository.existsById(id)){
            return travelRepository.findById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Transactional
    @Override
    public Travel save(Travel entity) {
        return travelRepository.save(entity);
    }

    @Transactional
    @Override
    public Travel update(Travel entity) {
        return travelRepository.save(entity);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (travelRepository.existsById(id)){
            travelRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
