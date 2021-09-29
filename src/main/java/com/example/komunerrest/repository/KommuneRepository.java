package com.example.komunerrest.repository;

import com.example.komunerrest.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KommuneRepository extends JpaRepository<Kommune, Integer> {

    List<Kommune> findKommuneByRegionKode(String regionKode);

    List<Kommune> findKommuneByKommune(String kommune);



}
