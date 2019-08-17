package com.RIG.RIG.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RIG.RIG.domain.Animal;
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
	
	@PostMapping
	public ResponseEntity<?> insertAnimal(@RequestBody Animal animal) {
		try {
			return new ResponseEntity<>(repo.save(animal), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem registering the animal", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
