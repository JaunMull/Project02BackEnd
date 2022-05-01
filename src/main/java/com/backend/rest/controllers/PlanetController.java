package com.backend.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.rest.model.Planet;
import com.backend.rest.repository.PlanetRepository;

@RestController
@CrossOrigin(origins = "*")
public class PlanetController {

	@Autowired
	PlanetRepository planetRepository;
	
	@PostMapping("/planet")
	public Planet postPlanet(@RequestBody Planet planet1) {
		return planetRepository.save(planet1);
	}
	
	@GetMapping("/planet")
	public List<Planet> getPlanet(Planet planet1) {
		return planetRepository.findAll();
	}
	
	
	@GetMapping("/planet/{name}")
	public List<Planet> getPlanetinfo(@PathVariable("name") String n1) {
		return planetRepository.findPlanetinfo(n1);
	}
	
}
