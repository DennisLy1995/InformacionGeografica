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
import com.RIG.RIG.domain.Pais;
import com.RIG.RIG.domain.Region_Biologica;
import com.RIG.RIG.domain.Region_Politica;
import com.RIG.RIG.repository.AnimalRepository;
import com.RIG.RIG.repository.Animal_RB_Repository;
import com.RIG.RIG.repository.PaisRepository;
import com.RIG.RIG.repository.RegionBiologicaRepository;
import com.RIG.RIG.repository.RegionPoliticaRepository;

@RestController
@RequestMapping("/paises")
public class PaisesController {

	@Autowired
	PaisRepository repoP;
	
	@Autowired
	RegionPoliticaRepository repoRP;
	
	@Autowired
	RegionBiologicaRepository repoRB;
	
	@Autowired
	Animal_RB_Repository repoA_X_RB;
	
	@Autowired
	AnimalRepository repoA;
	
	@GetMapping
	public ResponseEntity<?> getAllCountries() {
		try {
			return new ResponseEntity<>(repoP.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem retrieving all the countries registered.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllCountriesWithRIG")
	public ResponseEntity<?> getAllCountriesWithRIG() {
		try {
			
			List<Pais> listaPaises = repoP.findAll();
			List<Pais> listaPaisesFiltrados = new ArrayList<>();
			
			for(Pais e:listaPaises) {
				if(e.getRIG() == 1) {
					listaPaisesFiltrados.add(e);
				}
			}
			
			return new ResponseEntity<>(listaPaisesFiltrados, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem retrieving all the countries registered.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/searchAllPoliticalRegionsByCountry")
	public ResponseEntity<?> getPoliticRegionByCountryID(@RequestParam String busqueda) {
		try {
			List<Region_Politica> listaRegiones = repoRP.findAll();
			List<Region_Politica> listaRegionesFiltro = new ArrayList<>();
			
			for(Region_Politica e: listaRegiones) {
				if((e.getNOMBRE_P().toLowerCase()).contains(busqueda.toLowerCase())) {
					listaRegionesFiltro.add(e);
				}
			}
			
			return new ResponseEntity<>(listaRegionesFiltro, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem with the custom retrieval.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/searchAllBiologicalRegionsByCountry")
	public ResponseEntity<?> getBiologicalRegionByCountryID(@RequestParam String busqueda) {
		try {
			List<Region_Biologica> listaRegiones = repoRB.findAll();
			List<Region_Biologica> listaRegionesFiltro = new ArrayList<>();
			
			for(Region_Biologica e: listaRegiones) {
				if((e.getNOMBRE_P().toLowerCase()).contains(busqueda.toLowerCase())) {
					listaRegionesFiltro.add(e);
				}
			}
			
			return new ResponseEntity<>(listaRegionesFiltro, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem with the custom retrieval.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getAllBiodiversityByCountry")
	public ResponseEntity<?> getAllBiodiversityByCountry(@RequestParam String busqueda) {
		try {
			List<Region_Biologica> listaRegiones = repoRB.findAll();
			List<Region_Biologica> listaRegionesFiltro = new ArrayList<>();
			List<Animales_RB> animalesTotal = repoA_X_RB.findAll();
			List<Animal> listaAnimales = new ArrayList<>();
			
			
			for(Region_Biologica e: listaRegiones) {
				if((e.getNOMBRE_P().toLowerCase()).contains(busqueda.toLowerCase())) {
					listaRegionesFiltro.add(e);
				}
			}
			
			
			if(animalesTotal.size() <= 0) {
				return new ResponseEntity<>(repoA.findAll(), HttpStatus.OK);
			}else {
				
				for(Region_Biologica e:listaRegionesFiltro) {
					for(Animales_RB a: animalesTotal) {
						if(a.getNOMBRE_RB().equals(e.getNOMBRE_RB())) {
							Optional<Animal> temp = repoA.findById(a.getNOMBRE_CIENTIFICO());
							Animal tempA = new Animal();
							tempA.setNOMBRE_CIENTIFICO(temp.get().getNOMBRE_CIENTIFICO());
							tempA.setNOMBRE_POPULAR(temp.get().getNOMBRE_POPULAR());
							tempA.setPELIGRO_EXT(temp.get().getPELIGRO_EXT());
							listaAnimales.add(tempA);
						}
					}
				}
				
				return new ResponseEntity<>(listaAnimales, HttpStatus.OK);
			}
			
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem with the custom retrieval.", HttpStatus.INTERNAL_SERVER_ERROR);
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
