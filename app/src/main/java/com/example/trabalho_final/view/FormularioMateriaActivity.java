package com.example.trabalho_final.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.CursoBLL;
import com.example.trabalho_final.bll.MateriaBLL;
import com.example.trabalho_final.bll.PeriodoBLL;
import com.example.trabalho_final.bll.UsuarioBLL;
import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Usuario;

public class FormularioMateriaActivity extends AppCompatActivity {

    private static final String APP_PREF_ID = "MeuAppPrefID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_materia);

        Button btnSalvar = findViewById(R.id.btn_salvar_nova_materia);

        EditText nomeDaMateria = findViewById(R.id.lbl_nome_da_materia);
        EditText salaTeoria = findViewById(R.id.lbl_sala_teoria);
        EditText salaPratica = findViewById(R.id.lbl_sala_pratica);



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

                SharedPreferences pref = FormularioMateriaActivity.this.getSharedPreferences(APP_PREF_ID, 0);
                String email = pref.getString("email", "");
                AppDB appDB = new AppDB(getBaseContext(), email + "_DB");

                PeriodoBLL periodoBLL = new PeriodoBLL(appDB);
                MateriaBLL materiaBLL = new MateriaBLL(appDB);






            }
        });

    }
}