package com.backend.rest;

import com.backend.rest.controllers.PlanetController;
import com.backend.rest.controllers.UserController;
import com.backend.rest.model.Planet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@SpringBootTest
@ExtendWith(SpringExtension.class)
class Project02BackEndApplicationTests {

	@Autowired
	PlanetController planetController;

	@Autowired
	UserController userController;


	@Test
	void contextLoads() {
		Assertions.assertNotEquals(planetController, null);
		Assertions.assertNotEquals(userController, null);
	}

}
