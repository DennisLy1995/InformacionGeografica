package com.RIG.RIG.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.RIG.RIG.domain.Animales_RB;
import com.RIG.RIG.domain.Region_Biologica;
import com.RIG.RIG.domain.Region_Politica;
import com.RIG.RIG.repository.AnimalRepository;
import com.RIG.RIG.repository.Animal_RB_Repository;
import com.RIG.RIG.repository.RegionBiologicaRepository;

@RestController
@RequestMapping("/regbio")
public class RegionesBiologicasController {

	@Autowired
	RegionBiologicaRepository repoRB;
	
	@Autowired
	Animal_RB_Repository repoA_X_RB;
	
	@Autowired
	AnimalRepository repoA;
	
	@GetMapping
	public ResponseEntity<?> getAllBiologicRegions() {		
		try {
			return new ResponseEntity<>(repoRB.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> insertBiologicRegion(@RequestBody Region_Biologica region) {
		try {
			return new ResponseEntity<>(repoRB.save(region), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem registering the biologica region.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllAnimalsByBiologicRegion")
	public ResponseEntity<?> getAllAnimalsByBiologicRegion(@RequestParam String region){
		
		try {
			List<Animales_RB> animalesRegion = repoA_X_RB.findAll();
			if(animalesRegion.size() <= 0) {
				return new ResponseEntity<>(repoA.findAll(), HttpStatus.OK);
			}else {
				
				List<Animal> listaAnimales = new ArrayList<>();
				for(Animales_RB e: animalesRegion) {
					if(e.getNOMBRE_RB().equals(region)) {
						Optional<Animal> temp = repoA.findById(e.getNOMBRE_CIENTIFICO());
						Animal tempA = new Animal();
						tempA.setNOMBRE_CIENTIFICO(temp.get().getNOMBRE_CIENTIFICO());
						tempA.setNOMBRE_POPULAR(temp.get().getNOMBRE_POPULAR());
						tempA.setPELIGRO_EXT(temp.get().getPELIGRO_EXT());
						listaAnimales.add(tempA);
					}
				}
				return new ResponseEntity<>(listaAnimales, HttpStatus.OK);
				
			}
			
			
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem registering the biologica region.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
