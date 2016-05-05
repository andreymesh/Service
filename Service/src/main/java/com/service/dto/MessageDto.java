package com.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MessageDto {
    @JsonProperty (required = true)
    private String massage;

    public MessageDto() {
    }

    public MessageDto(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
