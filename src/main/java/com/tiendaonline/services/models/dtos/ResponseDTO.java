package com.tiendaonline.services.models.dtos;

public class ResponseDTO {

    private int numOfErrors;
    private String message;

    //Getters & Setters
    public int getNumOfErrors() {
        return numOfErrors;
    }

    public void setNumOfErrors(int numOfErrors) {
        this.numOfErrors = numOfErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
