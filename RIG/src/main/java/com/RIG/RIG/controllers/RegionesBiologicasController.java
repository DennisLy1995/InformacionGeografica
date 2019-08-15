package com.RIG.RIG.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RIG.RIG.repository.RegionBiologicaRepository;

@RestController
@RequestMapping("/regbio")
public class RegionesBiologicasController {

	@Autowired
	RegionBiologicaRepository repo;
	
	@GetMapping
	public ResponseEntity<?> getAllRegBio() {		
		try {
			return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
