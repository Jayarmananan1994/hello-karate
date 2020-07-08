package com.daasworld.hellokarate.services;

import com.daasworld.hellokarate.entities.ClaimRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;

//@Service
public class ClaimApprovalService {
    private static String sigimUrl = "http://127.0.0.1:9000";
    private RestTemplate restTemplate;

   // @Autowired
    public ClaimApprovalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String getRequestApprovalStatus(String requestId){
        ResponseEntity<String> serviceResponse =  restTemplate.getForEntity(sigimUrl+"/claim-status/"+requestId, String.class);
        return serviceResponse.getBody();
    }

    public String addClaimRequest(ClaimRequest requestBody){
        ResponseEntity<String> serviceResponse =  restTemplate.postForEntity(sigimUrl+"/add-claim/", requestBody, String.class);
        return serviceResponse.getBody();
    }

    public String getClaimRequest(String requestId){
        ResponseEntity<String> serviceResponse =  restTemplate.getForEntity(sigimUrl+"/claim/"+requestId, String.class);
        return serviceResponse.getBody();
    }

}
