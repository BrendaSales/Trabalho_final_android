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
import com.example.trabalho_final.bll.CadastroBLL;
import com.example.trabalho_final.bll.UsuarioBLL;
import com.example.trabalho_final.dao.AppDB;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {
    private boolean respostaValidacao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btnCadastrar = findViewById(R.id.btn_realizar_cadastro);
        EditText txtNome = findViewById(R.id.txt_cadastro_nome);
        EditText txtEmail = findViewById(R.id.txt_cadastro_email);
        EditText txtSenha = findViewById(R.id.txt_cadastro_password);


        CadastroBLL cadastroBLL = new CadastroBLL();


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = txtNome.getText().toString();
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                respostaValidacao = cadastroBLL.validacaoCampos(nome, senha, email);

                if (respostaValidacao == false) {
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos!!", Toast.LENGTH_LONG).show();
                } else {

                    OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();

                                AppDB appDB = new AppDB(getBaseContext(), email + "_DB");
                                UsuarioBLL usuarioBLL = new UsuarioBLL(appDB);

                                boolean wasCreated = usuarioBLL.create(nome, email);

                                if (wasCreated) {
                                    Toast.makeText(CadastroActivity.this, "Usuário cadastrado no banco!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(CadastroActivity.this, "Erro ao cadastrar o usuario no banco", Toast.LENGTH_SHORT).show();
                                }

                                Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                                startActivity(intent);

                            }else{
                                try {
                                    throw task.getException();
                                }catch (FirebaseAuthWeakPasswordException e) {
                                    Toast.makeText(CadastroActivity.this, "A senha deve ter no mínimo 6 caracteres!", Toast.LENGTH_LONG).show();
                                }catch (FirebaseAuthUserCollisionException e) {
                                    Toast.makeText(CadastroActivity.this, "O email já possui um cadastro!", Toast.LENGTH_LONG).show();
                                }catch (FirebaseAuthInvalidCredentialsException e){
                                    Toast.makeText(CadastroActivity.this, "Email inválido!", Toast.LENGTH_LONG).show();
                                }catch (Exception e) {
                                    Log.e("CADASTRO","Erro inesperado ao realizar cadastro");
                                }
                            }
                        }
                    };

                    cadastroBLL.cadastrar(email, senha, listener);

                }
            }
        });





    }
}