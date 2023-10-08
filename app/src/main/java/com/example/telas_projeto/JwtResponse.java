package com.example.telas_projeto;

import com.google.gson.annotations.SerializedName;

public class JwtResponse {
    @SerializedName("token")
    private String token;

    @SerializedName("message")
    private String message;

    public String getToken() {
        return token;
    }
    public String getMessage() {
        return message;
    }
}
