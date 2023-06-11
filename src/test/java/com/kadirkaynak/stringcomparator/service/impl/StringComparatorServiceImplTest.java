package com.kadirkaynak.stringcomparator.service.impl;

import com.kadirkaynak.stringcomparator.dto.ComparatorDTO;
import com.kadirkaynak.stringcomparator.utilities.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StringComparatorServiceImplTest {

    @InjectMocks
    private StringComparatorServiceImpl stringComparatorService;

    @Test
    public void Given_DTO_When_Compare_Then_ReturnString() {
        //
        // Given
        //
        ComparatorDTO comparatorDTO1 = new ComparatorDTO("Are the kids at home? aaaaa fffff", "Yes they are here! aaaaa fffff");
        ComparatorDTO comparatorDTO2 = new ComparatorDTO("mmmmm m nnnnn y&friend&Paul has heavy hats! &", "my frie n d Joh n has ma n y ma n y frie n ds n&");
        ComparatorDTO comparatorDTO3 = new ComparatorDTO("my&friend&Paul has heavy hats! &", "my friend John has many many friends &");

        //
        // When
        //
        String compare1 = stringComparatorService.compare(comparatorDTO1);
        String compare2 = stringComparatorService.compare(comparatorDTO2);
        String compare3 = stringComparatorService.compare(comparatorDTO3);

        //
        // Then
        //
        Assertions.assertEquals("=:aaaaaa/2:eeeee/=:fffff/=:hh/2:rr/1:tt", compare1);
        Assertions.assertEquals("1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/=:ee/2:ff/2:ii/2:rr/=:ss/", compare2);
        Assertions.assertEquals("2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/=:ee/2:ff/2:ii/2:rr/=:ss/", compare3);
    }

}