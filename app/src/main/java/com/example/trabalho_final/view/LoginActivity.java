package com.example.trabalho_final.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.LoginBLL;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class LoginActivity extends AppCompatActivity {
    private boolean respostaValidacao = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnCadastro = findViewById(R.id.btn_cadastro);
        Button btnEntrar = findViewById(R.id.btn_login);

        EditText txtEmail = findViewById(R.id.txt_login_email);
        EditText txtSenha = findViewById(R.id.txt_login_password);


        LoginBLL loginBLL = new LoginBLL();

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                respostaValidacao = loginBLL.validacaoCampos(email, senha);

                if (respostaValidacao == false) {
                    Toast.makeText(LoginActivity.this, "Preencha todos os campos!!", Toast.LENGTH_LONG).show();
                } else {

                    OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Login feito com sucesso", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                try {
                                    throw task.getException();
                                } catch (FirebaseAuthInvalidCredentialsException e) {
                                    Toast.makeText(LoginActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show();
                                } catch (FirebaseAuthInvalidUserException e) {
                                    Toast.makeText(LoginActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    Toast.makeText(LoginActivity.this, "Erro inesperado ao logar usuário!", Toast.LENGTH_LONG).show();
                                }
                            }

                        }
                    };

                    loginBLL.logarUsuario(email, senha, listener);

                }
            }
        });




    }
}