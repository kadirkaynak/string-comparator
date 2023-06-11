package com.kadirkaynak.stringcomparator.controller.impl;

import com.kadirkaynak.stringcomparator.controller.ComparatorController;
import com.kadirkaynak.stringcomparator.dto.ComparatorDTO;
import com.kadirkaynak.stringcomparator.service.ComparatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ComparatorControllerImpl implements ComparatorController {

    private final ComparatorService comparatorService;

    @Override
    public ResponseEntity<String> comparator(@RequestBody ComparatorDTO comparatorDTO) {
        return new ResponseEntity<>(comparatorService.compare(comparatorDTO), HttpStatus.OK);
    }
}
