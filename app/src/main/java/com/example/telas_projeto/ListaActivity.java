package com.example.telas_projeto;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.ImageButton;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DadosLoginAdapter dadosLoginAdapter;
    private List<DadosLogin> listaDadosLogin;

    private Button btAdicionar;
    private Button btEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        ImageButton btSair = findViewById(R.id.btSair);
        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoDeConfirmacao();
            }
        });
        recyclerView = findViewById(R.id.listaLogins); // Substitua R.id.recyclerView pelo ID do seu RecyclerView no layout XML

        // Inicialize a lista de DadosLogin (você pode carregá-la de sua fonte de dados)
        listaDadosLogin = new ArrayList<>();
        listaDadosLogin.add(new DadosLogin(1, "usuario1", "senha123", "admin", "admin", new Date(), new Date()));
        listaDadosLogin.add(new DadosLogin(2, "usuario2", "senha456", "admin", "admin", new Date(), new Date()));

        // Inicialize o adaptador e configure-o com a lista de DadosLogin
        dadosLoginAdapter = new DadosLoginAdapter(this, listaDadosLogin);

        // Configure o RecyclerView com um LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Defina o adaptador no RecyclerView
        recyclerView.setAdapter(dadosLoginAdapter);
    }

    private void mostrarDialogoDeConfirmacao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente fechar o aplicativo?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity(); // Fecha todas as Activities e encerra o aplicativo
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Não faz nada, apenas fecha o diálogo
                    }
                })
                .show();
    }
}