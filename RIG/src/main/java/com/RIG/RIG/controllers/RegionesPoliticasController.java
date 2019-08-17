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
import com.RIG.RIG.domain.REGB_X_REGP;
import com.RIG.RIG.domain.Region_Biologica;
import com.RIG.RIG.domain.Region_Politica;
import com.RIG.RIG.repository.RegBiologicaXRegionPoliticaRepository;
import com.RIG.RIG.repository.RegionPoliticaRepository;

@RestController
@RequestMapping("/regpol")
public class RegionesPoliticasController {

	@Autowired
	RegionPoliticaRepository repoRP;
	
	@Autowired
	RegBiologicaXRegionPoliticaRepository repoRBXRP;
	
	
	@GetMapping
	public ResponseEntity<?> getAllPoliticRegions() {
		try {
			return new ResponseEntity<>(repoRP.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/searchPoliticalRegion")
	public ResponseEntity<?> getPoliticRegionbyID(@RequestParam String busqueda) {
		try {
			List<Region_Politica> listaRegiones = repoRP.findAll();
			List<Region_Politica> listaRegionesFiltro = new ArrayList<>();
			
			for(Region_Politica e: listaRegiones) {
				if((e.getNOMBRE_RP().toLowerCase()).contains(busqueda.toLowerCase())) {
					listaRegionesFiltro.add(e);
				}
			}
			
			return new ResponseEntity<>(listaRegionesFiltro, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem with the custom retrieval.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/insertPoliticRegion")
	public ResponseEntity<?> insertPoliticRegion(@RequestBody Region_Politica region) {
		try {
			return new ResponseEntity<>(repoRP.save(region), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem with the register of the politic region.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> LinkBiologicRegion_PoliticRegion(@RequestBody REGB_X_REGP region) {
		try {
			return new ResponseEntity<>(repoRBXRP.save(region), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("There was a problem linking the Biologic region with the political region.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
