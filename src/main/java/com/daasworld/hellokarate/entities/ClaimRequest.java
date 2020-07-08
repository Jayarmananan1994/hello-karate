package com.daasworld.hellokarate.entities;

import java.util.List;

public class ClaimRequest {
    String name;
    String additionalNotes;
    double amount;

    public ClaimRequest(){}
    public ClaimRequest(String name,String  additionalNotes,double amount){
        this.name = name;
        this.additionalNotes = additionalNotes;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public double getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

