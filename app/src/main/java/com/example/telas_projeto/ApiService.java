package com.example.telas_projeto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("Usuarios/login")
    Call<JwtResponse> login(@Body LoginRequest loginRequest);
    @GET("Usuarios")
    Call<List<Usuario>> getUsuarios();
}
