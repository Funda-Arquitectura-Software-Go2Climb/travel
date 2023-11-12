package com.go2climb.travel.api;

import com.go2climb.travel.domain.entity.Travel;
import com.go2climb.travel.domain.service.TravelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/travel")
@AllArgsConstructor
public class TravelController {
    @Autowired
    private TravelService travelService;

    @PostMapping
    public Travel save(@RequestBody Travel travel){
        return travelService.save(travel);
    }

    @GetMapping
    public List<Travel> getAll() {return travelService.getAll();}

    @GetMapping("{id}")
    public Optional<Travel> getById(@PathVariable Integer id) {
        return travelService.getById(id);
    }

    @GetMapping("/agency/{id}")
    public List<Travel> getByAgencyId(@PathVariable Integer id) {
        return travelService.getByAgencyId(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Travel> update (@PathVariable Integer id, @RequestBody Travel travel  ){
        if (id.equals(travel.getId())){
            travelService.update(travel);
            return new ResponseEntity<>(travel, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Travel> delete(@PathVariable Integer id){
        if (travelService.deleteById(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}