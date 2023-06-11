package com.kadirkaynak.stringcomparator.controller.impl;

import com.kadirkaynak.stringcomparator.dto.ComparatorDTO;
import com.kadirkaynak.stringcomparator.service.ComparatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ComparatorControllerImplTest {
    @Mock
    private ComparatorService comparatorService;
    @InjectMocks
    private ComparatorControllerImpl comparatorController;

    @BeforeEach
    public void init() {
        comparatorController = new ComparatorControllerImpl(comparatorService);
    }

    @Test
    public void Given_LoginRequest_When_Login_Then_ReturnString() {
        //
        // Given
        //
        ComparatorDTO comparatorDTO = new ComparatorDTO("Are the kids at home? aaaaa fffff", "Yes they are here! aaaaa fffff");

        //
        // When
        //
        ResponseEntity<String> comparator = comparatorController.comparator(comparatorDTO);

        //
        // Then
        //
        Assertions.assertEquals(200, comparator.getStatusCode().value());
    }

}