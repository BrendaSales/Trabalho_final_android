package com.example.trabalho_final.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trabalho_final.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Provas_e_trabalhosFormulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas_e_trabalhos_formulario);

        FloatingActionButton btnPlus = findViewById(R.id.btn_plus);

        //inserir a lista de tarefas


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(,MainActivity.class);
                //startActivity(intent);
            }
        });

    }
}