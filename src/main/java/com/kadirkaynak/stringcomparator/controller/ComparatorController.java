package com.kadirkaynak.stringcomparator.controller;


import com.kadirkaynak.stringcomparator.dto.ComparatorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/api/v1/string")
public interface ComparatorController {

    @PostMapping("/comparator")
    ResponseEntity<String> comparator(@RequestBody ComparatorDTO transferDTO);
}
