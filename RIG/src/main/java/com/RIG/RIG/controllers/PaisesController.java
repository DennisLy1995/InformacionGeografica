package com.RIG.RIG.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RIG.RIG.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisesController {

	@Autowired
	PaisRepository repo;
	
	@GetMapping
	public ResponseEntity<?> getAllCountries() {
		try {
			return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem retrieving all the countries registered.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
