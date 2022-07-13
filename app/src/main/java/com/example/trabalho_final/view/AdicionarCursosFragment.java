package com.example.trabalho_final.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.CursoBLL;
import com.example.trabalho_final.bll.PeriodoBLL;
import com.example.trabalho_final.bll.UsuarioBLL;
import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Curso;
import com.example.trabalho_final.dao.CursoDAO;
import com.example.trabalho_final.dao.Periodo;
import com.example.trabalho_final.dao.PeriodoDAO;
import com.example.trabalho_final.dao.Usuario;


public class AdicionarCursosFragment extends Fragment {

    private static final String APP_PREF_ID = "MeuAppPrefID";
    private Integer periodo = 0;

    public AdicionarCursosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adicionar_cursos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Spinner spinnerPeriodos=getActivity().findViewById(R.id.spinner_periodo);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.periodosArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerPeriodos.setAdapter(adapter);

        Button btnSalvar = getView().findViewById(R.id.btn_salvar_curso);
        EditText nomeCurso = getView().findViewById(R.id.txt_nome_do_curso);

        SharedPreferences pref = getActivity().getBaseContext().getSharedPreferences(APP_PREF_ID, 0);
        String email = pref.getString("email", "");
        AppDB appDB = new AppDB(getActivity().getBaseContext(), email + "_DB");

        CursoBLL cursoBLL = new CursoBLL(appDB);
        PeriodoBLL periodoBLL = new PeriodoBLL(appDB);
        UsuarioBLL usuarioBLL = new UsuarioBLL(appDB);

        Usuario usuario = usuarioBLL.getUsuario(email);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = nomeCurso.getText().toString();

                try {
                    periodo = Integer.parseInt(spinnerPeriodos.getSelectedItem().toString());
                    Log.d("ADICIONAR_CURSO_VIEW", "Periodo:" + periodo);
                } catch(NumberFormatException e) {
                    Log.d("ADICIONAR_CURSO_VIEW", "Não conseguiu transformar em integer");
                }


                boolean cursoWasCreated = cursoBLL.create(nome, email);

                if (cursoWasCreated) {
                    Toast.makeText(getActivity().getBaseContext(), "Curso cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                        Curso cursoCriado = cursoBLL.getCurso(nome);

                        usuario.adicionarCurso(cursoCriado);

                        boolean periodoWasCreated = periodoBLL.create(periodo, nome);

                        if (periodoWasCreated) {
                            Toast.makeText(getActivity().getBaseContext(), "Periodo cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                            Periodo periodoCriado = periodoBLL.getPeriodo(periodo);

                            cursoCriado.adicionarPeriodos(periodoCriado);

                        } else {
                            Toast.makeText(getActivity().getBaseContext(), "Erro ao cadastrar o periodo no banco", Toast.LENGTH_SHORT).show();
                        }

                } else {
                    Toast.makeText(getActivity().getBaseContext(), "Erro ao cadastrar o curso no banco", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(getActivity(), CursandoActivity.class);
                startActivity(intent);
            }
        });
    }
}