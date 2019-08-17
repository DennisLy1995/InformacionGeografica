package com.RIG.RIG.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RIG.RIG.domain.Pais;
import com.RIG.RIG.domain.Region_Biologica;
import com.RIG.RIG.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisesController {

	@Autowired
	PaisRepository repoP;
	
	@GetMapping
	public ResponseEntity<?> getAllCountries() {
		try {
			return new ResponseEntity<>(repoP.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem retrieving all the countries registered.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> insertCountry(@RequestBody Pais pais) {
		try {
			return new ResponseEntity<>(repoP.save(pais), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem with the register of the country.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
