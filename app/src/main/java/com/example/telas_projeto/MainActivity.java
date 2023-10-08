package com.example.telas_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLista = findViewById(R.id.btLista);
        btLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crie um Intent para abrir a Activity de destino
                Intent intent = new Intent(MainActivity.this, ListaActivity.class);

                // Inicie a Activity de destino
                startActivity(intent);
            }
        });
    }
}