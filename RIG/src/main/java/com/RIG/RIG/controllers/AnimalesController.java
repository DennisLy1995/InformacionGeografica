package com.RIG.RIG.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RIG.RIG.domain.Animal;
import com.RIG.RIG.repository.AnimalRepository;


@RestController
@RequestMapping("/animals")
public class AnimalesController {

	
	@Autowired
	AnimalRepository repoA;
	
	@GetMapping
	public ResponseEntity<?> getAllAnimals() {
		try {
			return new ResponseEntity<>(repoA.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem with the retrieval of the list.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/searchAnimal")
	public ResponseEntity<?> getAnimalbyID(@RequestParam String busqueda) {
		try {
			List<Animal> listaAnimales = repoA.findAll();
			List<Animal> listaAnimalesFiltro = new ArrayList<>();
			
			for(Animal e: listaAnimales) {
				if(e.getNOMBRE_CIENTIFICO().contains(busqueda) || e.getNOMBRE_POPULAR().contains(busqueda)) {
					listaAnimalesFiltro.add(e);
				}
			}
			
			return new ResponseEntity<>(listaAnimalesFiltro, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem with the custom retrieval.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> insertAnimal(@RequestBody Animal animal) {
		try {
			return new ResponseEntity<>(repoA.save(animal), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem registering the animal", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
