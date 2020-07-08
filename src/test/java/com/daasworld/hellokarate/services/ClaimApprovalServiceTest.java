package com.daasworld.hellokarate.services;

import com.daasworld.hellokarate.entities.ClaimRequest;
import com.daasworld.hellokarate.entities.Person;
import com.intuit.karate.netty.FeatureServer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ClaimApprovalServiceTest {
    private RestTemplate restTemplate = new RestTemplate();
    private ClaimApprovalService claimApprovalService= new ClaimApprovalService(restTemplate);
    private static FeatureServer server;

    @BeforeClass
    public static void beforeClass(){
        //ClassLoader classLoader = getClass().getClassLoader();
        File file = new File("/Users/jayaramananan/Documents/code/generali-welion/hello-karate/src/test/java/karate/sigim/sigim-mock.feature");
        server = FeatureServer.start(file,9000,false, null);
    }

    @Test
    public void GivenValidfRequestGetApprovalStatusShouldReturnClaimStatus(){
        String response = claimApprovalService.getRequestApprovalStatus("CLAI100");
        assertEquals("Should return Approved Message","Approved", response);
    }

    @Test
    public void GivenValidRequestAddClaimRequestShouldAddClaimRequest(){
        ClaimRequest claimRequest = new ClaimRequest("Valid cliam","Some tyoe",1000);
        String response = claimApprovalService.addClaimRequest(claimRequest);
        assertEquals("Should return Created Claim Message","{\"name\":\"Valid cliam\",\"additionalNotes\":\"Some tyoe\",\"amount\":1000.0}", response);
    }

    @Test
    public void GivenValidRequestGetClaimRequestShouldAddClaimRequest(){
        ClaimRequest claimRequest = new ClaimRequest("Valid cliam","Some tyoe",1000);
        claimApprovalService.addClaimRequest(claimRequest);
        String response = claimApprovalService.getClaimRequest("1");
        assertEquals("Should return Created Claim Message","{\"name\":\"Valid cliam\",\"additionalNotes\":\"Some tyoe\",\"amount\":1000.0}", response);
    }
}
