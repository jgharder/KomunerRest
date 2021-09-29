package com.example.komunerrest.controller;

import com.example.komunerrest.model.Kommune;
import com.example.komunerrest.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class KommuneRESTController {

    @Autowired
    KommuneRepository kommuneRepository;

    @PostMapping(value = "/kommune", consumes = "application/json")
    public ResponseEntity<Kommune> newKommune(@RequestBody Kommune kommune) {
        kommuneRepository.save(kommune);
        return new ResponseEntity<Kommune>(kommune, HttpStatus.CREATED);
    }

    @PutMapping("/kommune/{kommuneKode}")
    public ResponseEntity<Kommune> updateKommune(@PathVariable int kommuneKode, @RequestBody Kommune kommune) {
        System.out.println(kommuneKode);
        Optional<Kommune> kommuneData = kommuneRepository.findById(kommuneKode);
        if (kommuneData.isPresent()) {
            Kommune _kommune = kommuneData.get();
            System.out.println(_kommune.getKommune());
            _kommune.setKommune(kommune.getKommune());
            _kommune = kommuneRepository.save(_kommune);
            System.out.println("gemt i databasen");
            System.out.println(_kommune.getKommune());
            return new ResponseEntity<>(_kommune, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/kommuner")
    public List<Kommune> allKommuner() {
        return kommuneRepository.findAll();
    }


    @GetMapping("/kommuneregid/{id}")
    public List<Kommune> allKommunerByRegiondId(@PathVariable String id) {
        return kommuneRepository.findKommuneByRegionKode(id);
    }

    @GetMapping("/kommunenavn/{kommune}")
    public List<Kommune> allKommunerByKommune(@PathVariable String kommune) {
        return kommuneRepository.findKommuneByKommune(kommune);
    }

    @DeleteMapping("/kommune/{id}")
    public ResponseEntity<Object> deleteKommune(@PathVariable int id) {
        try {
            kommuneRepository.deleteById(id);
        } catch (Exception err) {
            return new ResponseEntity<>("Kommune ikke fundet", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}


