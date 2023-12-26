package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.controller.entity.Cityzen;
import com.demo.controller.repositry.CityzenRepository;

@RestController
@RequestMapping("/cityzen")
public class CityzenController {
    @Autowired
    CityzenRepository cityzenRepository;

    @RequestMapping(path = "/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("hey", HttpStatus.OK);
    }

    @RequestMapping(path = "/id/{id}")
    public ResponseEntity<List<Cityzen>> getById(@PathVariable String id) {
        List<Cityzen> listCityzen = cityzenRepository.findByVaccine_Id(id);
        return new ResponseEntity<>(listCityzen, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Cityzen> addCityzen(@RequestBody Cityzen cityzen) {
        Cityzen savedCityzen = cityzenRepository.save(cityzen);
        return new ResponseEntity<>(savedCityzen, HttpStatus.CREATED);
    }
}
