package com.example.trabalho_final.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabalho_final.R;

public class AdicionarMateriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_materia);


        Button btnAdicionarMateria = findViewById(R.id.btn_adicionar_nova_materia);
        Button btnSalvarMaterias = findViewById(R.id.btn_salvar_materias);

        btnAdicionarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdicionarMateriaActivity.this, FormularioMateriaActivity.class);
                startActivity(intent);
            }
        });

        btnSalvarMaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdicionarMateriaActivity.this, CursandoActivity.class);
                startActivity(intent);
            }
        });


    }


}