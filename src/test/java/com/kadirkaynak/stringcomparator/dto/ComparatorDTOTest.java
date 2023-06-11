package com.kadirkaynak.stringcomparator.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparatorDTOTest {

    @Test
    public void Given_Strings_When_DTO_Then_ConstructorAndGetters() {
        //
        // Given
        //
        String s1 = "a";
        String s2 = "a";

        //
        // When
        //
        ComparatorDTO dto = new ComparatorDTO(s1, s2);

        //
        // Then
        //
        Assertions.assertEquals(s1, dto.getS1());
        Assertions.assertEquals(s2, dto.getS2());
    }

    @Test
    public void Given_Strings_When_DTO_Then_ConstructorAndSetters() {
        //
        // Given
        //
        String s1 = "a";
        String s2 = "a";

        //
        // When
        //
        ComparatorDTO dto = new ComparatorDTO(s1, s2);
        dto.setS1("b");
        dto.setS2("b");
        //
        // Then
        //
        Assertions.assertEquals("b", dto.getS1());
        Assertions.assertEquals("b", dto.getS2());
    }


}