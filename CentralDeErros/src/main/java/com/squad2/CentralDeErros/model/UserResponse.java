package com.squad2.CentralDeErros.model;

public class UserResponse {

    private final boolean success;
    private final String message;
    private final String userEmail;


    public UserResponse(boolean success, String message, String userEmail) {
        this.success = success;
        this.message = message;
        this.userEmail = userEmail;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
