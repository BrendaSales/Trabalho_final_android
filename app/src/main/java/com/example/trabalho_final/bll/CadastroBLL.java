package com.example.trabalho_final.bll;

import android.widget.Toast;

import com.example.trabalho_final.dao.CadastroDAO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

public class CadastroBLL {

    CadastroDAO cadastroDAO = new CadastroDAO();

    public boolean validacaoCampos (String nome, String senha, String email){
        if (nome.isEmpty() || senha.isEmpty() || email.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public void cadastrar (String email, String senha,OnCompleteListener<AuthResult> listener){
        cadastroDAO.cadastrarUsuario(email, senha, listener);
    }
}
