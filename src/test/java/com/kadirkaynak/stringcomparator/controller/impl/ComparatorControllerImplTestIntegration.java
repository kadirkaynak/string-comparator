package com.kadirkaynak.stringcomparator.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kadirkaynak.stringcomparator.dto.ComparatorDTO;
import com.kadirkaynak.stringcomparator.service.ComparatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class ComparatorControllerImplTestIntegration {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void Given_LoginRequest_When_Login_Then_Return200() throws Exception {
        //
        // Given
        //
        ComparatorDTO comparatorDTO = new ComparatorDTO("Are the kids at home? aaaaa fffff", "Yes they are here! aaaaa fffff");

        //
        // When
        //
        MvcResult result = mockMvc.perform(post("/api/v1/string/comparator")
                .content(objectMapper.writeValueAsString(comparatorDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        //
        // Then
        //
        assertEquals(200, result.getResponse().getStatus());
    }

}