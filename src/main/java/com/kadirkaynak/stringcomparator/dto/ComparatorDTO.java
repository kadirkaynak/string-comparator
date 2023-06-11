package com.kadirkaynak.stringcomparator.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class ComparatorDTO implements Serializable {
    private String s1;
    private String s2;
}
