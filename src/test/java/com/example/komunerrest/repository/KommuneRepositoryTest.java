package com.example.komunerrest.repository;

import com.example.komunerrest.model.Kommune;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KommuneRepositoryTest {

    @Autowired
    KommuneRepository kommuneRepository;

    @Test
    void findAllKommuner() {
        List<Kommune> lst = kommuneRepository.findAll();
        assertEquals(99, lst.size());

    }

    @Test
    void findKommuneByRegion() {

    }
}