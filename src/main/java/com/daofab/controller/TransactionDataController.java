package com.daofab.controller;

import com.daofab.model.TransactionData;
import com.daofab.model.UserData;
import com.daofab.response.TransactionDataResponse;
import com.daofab.response.UserDataResponse;
import com.daofab.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Author : shubham
*/
@RestController
@RequestMapping("/transactiondata")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionDataController {

    @Autowired
    TransactionDataService transactionDataService;
    /**
     * Creates a new user data entry.
     *
     * @param transactionDataResponse The UserDataResponse object containing the data to be created.
     * @return A ResponseEntity containing the created UserDataResponse object and an HTTP status code 200 (OK).
     */
    @PostMapping
    public ResponseEntity<TransactionDataResponse> createData(@RequestBody TransactionDataResponse transactionDataResponse){
        TransactionData transactionData= transactionDataService.addUserData(transactionDataResponse);
        TransactionDataResponse response = transactionDataService.response(transactionData);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping(value = "/{id}")
    public List<TransactionDataResponse> getAllUserData(@PathVariable("id") long id){
        return   transactionDataService.getAllUserData( id);
    }
}
