package com.example.trabalho_final.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.TarefaBLL;
import com.example.trabalho_final.dao.AppDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Provas_e_trabalhosFormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas_e_trabalhos_formulario);

        //cadastrar tarefa: - usado apenas para teste

        AppDB appDB = new AppDB(this,"Lucas");

        EditText txtTafefaNome = this.findViewById(R.id.txt_nome_da_tarefa);
        EditText txtTarefaDescricao = this.findViewById(R.id.txt_descricao_da_tarefa);
        EditText txtTarefaMateria = this.findViewById(R.id.txt_materia_da_tarefa);
        EditText txtTarefaData = this.findViewById(R.id.txt_data_da_tarefa);
        FloatingActionButton btnPlus = findViewById(R.id.btn_save);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TafefaNome = txtTafefaNome.getText().toString();
                String TafefaDescricao = txtTarefaDescricao.getText().toString();
                String TarefaData = txtTarefaData.getText().toString();
                String TarefaMateria = txtTarefaMateria.getText().toString();

                TarefaBLL tarefaBll = new TarefaBLL(appDB);
                boolean wasCreated = tarefaBll.create(TafefaNome, TafefaDescricao, TarefaData,TarefaMateria);

                if (wasCreated) {
                    //Toast.makeText(this,"Tarefa cadastrada!", Toast.LENGTH_SHORT).show();
                    //this.finish();
                } else {
                    //Toast.makeText(this,"Erro no cadastro da tarefa", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}