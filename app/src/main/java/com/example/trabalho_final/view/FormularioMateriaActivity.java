package com.example.trabalho_final.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.trabalho_final.R;

public class FormularioMateriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_materia);

        Button btnSalvar = findViewById(R.id.btn_salvar_nova_materia);

//        Spinner spinnerDiasDaSemana= findViewById(R.id.spinner_diaDaSemana1);
//        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(), R.array.diasDaSemanaArray, android.R.layout.simple_spinner_item);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//
//        spinnerDiasDaSemana.setAdapter(adapter);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioMateriaActivity.this, AdicionarMateriaActivity.class);
                startActivity(intent);
            }
        });

    }
}