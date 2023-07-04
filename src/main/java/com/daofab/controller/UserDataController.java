package com.daofab.controller;

import com.daofab.model.UserData;
import com.daofab.response.UserDataResponse;
import com.daofab.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
Author : shubham
*/
@RestController
@RequestMapping("/userdata")
public class UserDataController {
    @Autowired
    UserDataService userDataService;


    /**
     * Creates a new user data entry.
     *
     * @param userDataResponse The UserDataResponse object containing the data to be created.
     * @return A ResponseEntity containing the created UserDataResponse object and an HTTP status code 200 (OK).
     */
    @PostMapping
    public ResponseEntity<UserDataResponse> createData(@RequestBody UserDataResponse userDataResponse){
        UserData userData= userDataService.addUserData(userDataResponse);
        UserDataResponse response = userDataService.response(userData);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Retrieves a paginated list of user data.
     *
     * @param size   The number of items to include in each page (default: 2).
     * @param offset The offset value for pagination (default: 0).
     * @return A Page object containing the user data for the specified page and size.
     */
    @GetMapping
    public Page<UserDataResponse> getAllUserData(@RequestParam(value = "size", defaultValue = "2") int size,
            @RequestParam(value = "offset", defaultValue = "0") int offset){
        Pageable pageable = PageRequest.of(size, offset);
        List<UserDataResponse> userDataResponsesList = userDataService.getAllUserData(pageable);
        return new PageImpl<>(userDataResponsesList, pageable,userDataResponsesList.size());
    }
}
