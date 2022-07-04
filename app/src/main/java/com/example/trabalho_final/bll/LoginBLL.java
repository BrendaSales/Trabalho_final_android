package com.example.trabalho_final.bll;

import com.example.trabalho_final.dao.LoginDAO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

public class LoginBLL {

    LoginDAO loginDAO = new LoginDAO();

    public boolean validacaoCampos (String email, String senha){
        if (senha.isEmpty() || email.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public void logarUsuario (String email, String senha, OnCompleteListener<AuthResult> listener){
       loginDAO.autenticarUsuario(email, senha, listener);

    }
}
