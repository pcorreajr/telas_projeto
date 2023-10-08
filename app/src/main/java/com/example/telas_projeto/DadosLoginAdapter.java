package com.example.telas_projeto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class DadosLoginAdapter extends RecyclerView.Adapter<DadosLoginAdapter.DadosLoginViewHolder> {

    private Context context;
    private List<DadosLogin> listaDadosLogin;

    public DadosLoginAdapter(Context context, List<DadosLogin> listaDadosLogin) {
        this.context = context;
        this.listaDadosLogin = listaDadosLogin;
    }

    @NonNull
    @Override
    public DadosLoginViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new DadosLoginViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DadosLoginViewHolder holder, int position) {
        DadosLogin dadosLogin = listaDadosLogin.get(position);

        holder.textViewSeqLogin.setText("SeqLogin: " + dadosLogin.getSeqLogin());
        holder.textViewLogin.setText("Login: " + dadosLogin.getLogin());
        holder.textViewSenha.setText("Senha: " + dadosLogin.getSenha());
        holder.textViewLoginAlteracao.setText("Login de Alteração: " + dadosLogin.getLoginAlteracao());
        holder.textViewLoginCadastro.setText("Login de Cadastro: " + dadosLogin.getLoginCadastro());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        String dtaCriacao = dateFormat.format(dadosLogin.getDtaCriacao());
        String dtaAlteracao = dateFormat.format(dadosLogin.getDtaAlteracao());

        holder.textViewDtaCriacao.setText("Data de Criação: " + dtaCriacao);
        holder.textViewDtaAlteracao.setText("Data de Alteração: " + dtaAlteracao);
    }

    @Override
    public int getItemCount() {
        return listaDadosLogin.size();
    }

    public static class DadosLoginViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSeqLogin;
        TextView textViewLogin;
        TextView textViewSenha;
        TextView textViewLoginAlteracao;
        TextView textViewLoginCadastro;
        TextView textViewDtaCriacao;
        TextView textViewDtaAlteracao;

        public DadosLoginViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSeqLogin = itemView.findViewById(R.id.tVSeqLogin);
            textViewLogin = itemView.findViewById(R.id.tVLogin);
            textViewSenha = itemView.findViewById(R.id.tVSenha);
            textViewLoginAlteracao = itemView.findViewById(R.id.tVLoginAlt);
            textViewLoginCadastro = itemView.findViewById(R.id.tVLoginCadastro);
            textViewDtaCriacao = itemView.findViewById(R.id.tVDtaCriacao);
            textViewDtaAlteracao = itemView.findViewById(R.id.tVDtaAlteracao);
        }
    }
}
