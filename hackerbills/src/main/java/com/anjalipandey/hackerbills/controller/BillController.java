package com.anjalipandey.hackerbills.controller;

import com.anjalipandey.hackerbills.dto.BillDetailsDTO;
import com.anjalipandey.hackerbills.services.BillServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller of the Project
 */
@RestController
@RequestMapping(value = "/hackerbills")
public class BillController {

    @Autowired
    private BillServiceImpl billServiceImpl;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "/status")
    public ResponseEntity checkBillServiceStatus() {

        return new ResponseEntity("active", HttpStatus.OK);
    }

    @PostMapping(value = "/bills", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity processBill(@RequestBody BillDetailsDTO billDetailsDTO) {

        return new ResponseEntity(billServiceImpl.createBills(billDetailsDTO), HttpStatus.CREATED);
    }

    @GetMapping(value="/bills/{billNumber}")
    public ResponseEntity getBill(@PathVariable(name = "billNumber") int billNumber) {

        return new ResponseEntity(billServiceImpl.getBills(billNumber), HttpStatus.OK);
    }

    @GetMapping(value="/bills/due/{billedDate}")
    public ResponseEntity getBillByDueDate(@PathVariable(name = "billedDate") String billedDate) {

        return new ResponseEntity(billServiceImpl.getBillsByDueDate(billedDate), HttpStatus.OK);
    }



}
