package com.squad2.CentralDeErros.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final String authenticatedUserName;

    public JwtResponse(String jwttoken, String authenticatedUserName) {
        this.jwttoken = jwttoken;
        this.authenticatedUserName = authenticatedUserName;
    }

    public String getToken() {return this.jwttoken;}
    public String getAuthenticatedUserName() {return this.authenticatedUserName;}

}