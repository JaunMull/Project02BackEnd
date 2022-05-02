package com.backend.rest.controllers;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.backend.rest.model.Planet;
import com.backend.rest.repository.PlanetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.nl.Stel;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.springframework.http.MediaType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.management.PlatformManagedObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlanetController.class)
public class PlanetControllertest {
    @MockBean
    PlanetRepository planetRepository;
    PlanetController planetController;

    /*@MockBean
    */

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception{
        Planet planet = new Planet("Pluto","planet",55.4,.3,.4,1,12236478, 456667378);
        List<Planet> planets = Arrays.asList(planet);

        when(planetRepository.findAll()).thenReturn(planets);

        mockMvc.perform(get("/planet"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].size", Matchers.is(.4)));

    }

    @Test
    public void testsave() throws Exception{

        /*Planet planet = new Planet("eris","planet",55.4,.3,.4,1,12236478, 456667378);*/
        Planet planet = new Planet();
        planet.setId(1);
        planet.setName("Eris");
        planet.setType("DwarfPlanet");
        planet.setDensity(54);
        planet.setGravity(.3);
        planet.setSize(.4);
        planet.setMoons(0);
        planet.setSundistance(457778390);
        planet.setPlanetyears(155);
        List<Planet> planets = Arrays.asList(planet);

        Mockito.when(planetRepository.save(any(Planet.class))).thenReturn(planet);

        mockMvc.perform(MockMvcRequestBuilders.post("/planet")
                        .content(new ObjectMapper().writeValueAsString(planet))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size").value(.4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Eris"));

    }


  @Test
    public void testfindPlanetinfo() throws Exception{
        Planet planet = new Planet("Pluto","planet",55.4,.3,.4,1,12236478, 456667378);
        List<Planet> planets = Arrays.asList(planet);

        when(planetRepository.findPlanetinfo(ArgumentMatchers.anyString())).thenReturn(planets);

        mockMvc.perform(get("/planet/Pluto"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Pluto")));

    }/* */

   /* @Test
    public void testgetname() throws Exception{

       Planet planet = new Planet("eris","planet",55.4,.3,.4,1,12236478, 456667378);
         Planet planet = new Planet();
        planet.setId(1);
        planet.setName("Eris");
        planet.setType("DwarfPlanet");
        planet.setDensity(54);
        planet.setGravity(.3);
        planet.setSize(.4);
        planet.setMoons(0);
        planet.setSundistance(457778390);
        planet.setPlanetyears(155);
        //List<Planet> planets = new ArrayList<Planet>();
        //planets.add(planet);
        List<Planet> planets = Arrays.asList(planet);

        //Mockito.when(planetRepository.save(planet)).thenReturn(planet);

        when(planetController.getPlanet(any(Planet.class))).thenReturn(planets);

        mockMvc.perform(post("/planet"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$.size", Matchers.is(.4)))
                .andExpect(jsonPath("$.name", Matchers.is("Eris")));

    }*/

   /*  @Test
     public void testpostname() throws Exception{

        // Planet planet = new Planet("eris","planet",55.4,.3,.4,1,12236478, 456667378);
        Planet planet = new Planet();
        planet.setId(1);
        planet.setName("Eris");
        planet.setType("DwarfPlanet");
        planet.setDensity(54);
        planet.setGravity(.3);
        planet.setSize(.4);
        planet.setMoons(0);
        planet.setSundistance(457778390);
        planet.setPlanetyears(155);
        List<Planet> planets = new ArrayList<Planet>();
        planets.add(planet);
        //List<Planet> planets = Arrays.asList(planet);

        //Mockito.when(planetRepository.save(planet)).thenReturn(planet);

        when(planetController.postPlanet(any(Planet.class))).thenReturn(planet);

        mockMvc.perform(MockMvcRequestBuilders.post("/planet")
                        .content(new ObjectMapper().writeValueAsString(planet))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size", Matchers.is(.4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Eris")));

    }*/

}
