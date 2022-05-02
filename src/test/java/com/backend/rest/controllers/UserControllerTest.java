package com.backend.rest.controllers;


import com.backend.rest.model.Planet;
import com.backend.rest.model.User;
import com.backend.rest.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void TestfindAllUsers() throws Exception{
        User user = new User();
        user.setName("Jaunzel");
        user.setPhone(847438665);
        user.setEmail("Jz@revature.com");
        user.setPassword("JJFish");
        List<User> users = Arrays.asList(user);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Jaunzel")));

    }

    @Test
    public void testsave() throws Exception{

        /*Planet planet = new Planet("eris","planet",55.4,.3,.4,1,12236478, 456667378);*/
        User user = new User();
        user.setName("Jaunzel");
        user.setPhone(847438665);
        user.setEmail("Jz@revature.com");
        user.setPassword("JJFish");
        List<User> users = Arrays.asList(user);

        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(new ObjectMapper().writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value(847438665))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jaunzel"));

    }

    @Test
    public void testfindUserinfo() throws Exception{

        /*Planet planet = new Planet("eris","planet",55.4,.3,.4,1,12236478, 456667378);*/
        User user = new User();
        user.setName("Jaunzel");
        user.setPhone(847438665);
        user.setEmail("Jz@revature.com");
        user.setPassword("JJFish");
        List<User> users = Arrays.asList(user);

        Mockito.when(userRepository.findUserinfo(anyString())).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/Jz@revature.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phone").value(847438665))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Jaunzel"));

    }
}
