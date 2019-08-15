package com.RIG.RIG.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RIG.RIG.domain.Pais;
import com.RIG.RIG.repository.PaisRepository;

@RestController
@RequestMapping("Paises")
public class PaisesController {

	@Autowired
	PaisRepository repo;
	
	@GetMapping
	public List<Pais> getAllPaises() {
		return repo.findAll();
	}
	
}
