package com.dbservice.models;

public class ResponseUpdateDetailEntity {
    private boolean isSucceded;
    private String message;

//    public ResponseUpdateDetailEntity(boolean isSucceded, String message) {
//        this.isSucceded = isSucceded;
//        this.message = message;
//    }


    public ResponseUpdateDetailEntity() {
        isSucceded=true;
        message="Transaction executed successfully";
    }

    public boolean isSucceded() {
        return isSucceded;
    }

    public void setSucceded(boolean succeded) {
        isSucceded = succeded;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
