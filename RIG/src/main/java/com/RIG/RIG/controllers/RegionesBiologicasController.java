package com.RIG.RIG.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RIG.RIG.domain.Region_Biologica;
import com.RIG.RIG.domain.Region_Politica;
import com.RIG.RIG.repository.RegionBiologicaRepository;

@RestController
@RequestMapping("/regbio")
public class RegionesBiologicasController {

	@Autowired
	RegionBiologicaRepository repoRB;
	
	@GetMapping
	public ResponseEntity<?> getAllRegBio() {		
		try {
			return new ResponseEntity<>(repoRB.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> insertRegionBiologica(@RequestBody Region_Biologica region) {
		try {
			return new ResponseEntity<>(repoRB.save(region), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem registering the biologica region.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
