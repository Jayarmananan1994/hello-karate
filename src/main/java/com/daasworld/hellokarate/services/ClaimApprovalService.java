package com.daasworld.hellokarate.services;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;

//@Service
public class ClaimApprovalService {
    private static String sigimUrl = "http://127.0.0.1:9000/claim-status";
    private RestTemplate restTemplate;

   // @Autowired
    public ClaimApprovalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String getRequestApprovalStatus(String requestId){
        ResponseEntity<String> serviceResponse =  restTemplate.getForEntity(sigimUrl+"/"+requestId, String.class);
        return serviceResponse.getBody();
    }

    public String create() {
        try {
            HttpURLConnection con = getConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");


            int status = con.getResponseCode();
            if (status != 200) {
                throw new RuntimeException("status code was " + status);
            }
            String content = IOUtils.toString(con.getInputStream(), "utf-8");
            return content;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private HttpURLConnection getConnection() throws Exception {
        URL url = new URL(sigimUrl);

            return (HttpURLConnection) url.openConnection();
    }
}
