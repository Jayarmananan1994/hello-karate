package com.daasworld.hellokarate.controllers;

import com.daasworld.hellokarate.entities.ClaimRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimRequestHandlerController {

    @PostMapping("api/claim-request")
    public ResponseEntity<ClaimRequest> createRequest(@RequestBody ClaimRequest claimRequest){
        if(claimRequest.getName().equals("Bad Request"))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(claimRequest, HttpStatus.OK);
    }
}
