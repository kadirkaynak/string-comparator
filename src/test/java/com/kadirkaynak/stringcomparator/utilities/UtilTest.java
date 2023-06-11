package com.kadirkaynak.stringcomparator.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtilTest {

    @Test
    public void Given_Inputs_When_RepeatAppend_Then_ReturnResponse() {
        //
        // Given
        //
        StringBuilder result = new StringBuilder();

        //
        // When
        //
        Util.repeatAppend(result, 3, 'a');

        //
        // Then
        //
        Assertions.assertEquals("aaa", result.toString());
    }

    @Test
    public void Given_String_When_FrequencyCalculator_Return_Map() {
        //
        // Given
        //
        String str = "aabbc";

        //
        // When
        //
        Map<Character, Integer> frequencies = Util.frequencyCalculator(str);

        //
        // Then
        //
        assertAll(
            () -> Assertions.assertEquals(2, frequencies.get('a')),
            () -> Assertions.assertEquals(2, frequencies.get('b')),
            () -> Assertions.assertEquals(1, frequencies.get('c')),
            () -> Assertions.assertNull(frequencies.get('d'))
        );
    }

}