package com.vuluong.fraud;

import lombok.Data;

@Data
public class FraudCheckResponse {

    private Boolean isFraudster;

    public FraudCheckResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
}
