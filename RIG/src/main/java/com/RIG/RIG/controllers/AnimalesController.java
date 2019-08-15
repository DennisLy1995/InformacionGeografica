package com.RIG.RIG.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RIG.RIG.repository.AnimalRepository;


@RestController
@RequestMapping("/animales")
public class AnimalesController {

	
	@Autowired
	AnimalRepository repo;
	
	@GetMapping
	public ResponseEntity<?> getAllAnimales() {
		try {
			return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
