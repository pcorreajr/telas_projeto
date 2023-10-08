package com.example.telas_projeto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);

        //toast onCreate
        Context contexto = getApplicationContext(); //para toast
        String texto1 = "toast ao entrar";
        int duracao = Toast.LENGTH_SHORT; //para toast
        Toast toast = Toast.makeText(contexto, texto1,duracao);
        toast.show();
        //toast fim

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Crie um objeto LoginRequest com os dados de login
                LoginRequest loginRequest = new LoginRequest(username, password);

                ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

                Call<JwtResponse> call = apiService.login(loginRequest);

                call.enqueue(new Callback<JwtResponse>() {
                    @Override
                    public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {
                        if (response.isSuccessful()) {
                            JwtResponse jwtResponse = response.body();
                            String token = jwtResponse.getToken();
                            String message = jwtResponse.getMessage();
                            //toast inicio
                            Context contexto = getApplicationContext(); //para toast
                            int duracao = Toast.LENGTH_SHORT; //para toast
                            Toast toast = Toast.makeText(contexto, message,duracao);
                            toast.show();
                            //toast fim
                            // Armazene o token JWT no SharedPreferences ou outro local seguro
                            SharedPreferences preferences = getSharedPreferences("my_prefs", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("jwt_token", token);
                            editor.apply();

                            // Redirecione para a próxima tela ou realize outras ações
                            Intent intent = new Intent(LoginActivity.this, ListaActivity.class);

                            // Inicie a Activity de destino
                            startActivity(intent);

                        } else {
                            // Trate erros de login aqui
                            //toast Erro
                            Context contexto = getApplicationContext(); //para toast
                            String erro1 = "Erro de login";
                            int duracao = Toast.LENGTH_SHORT; //para toast
                            Toast toast = Toast.makeText(contexto, erro1,duracao);
                            toast.show();
                            //toast fim
                            // ...
                        }
                    }

                    @Override
                    public void onFailure(Call<JwtResponse> call, Throwable t) {
                        // Trate erros de conexão aqui
                        //toast Erro de conexão
                        Context contexto = getApplicationContext(); //para toast
                        String erro2 = "Erro de conexão";
                        int duracao = Toast.LENGTH_SHORT; //para toast
                        Toast toast = Toast.makeText(contexto, erro2,duracao);
                        toast.show();
                        //toast fim
                        // ...
                    }
                });
            }
        });
    }
}
