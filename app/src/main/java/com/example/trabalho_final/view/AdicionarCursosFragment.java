package com.example.trabalho_final.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.trabalho_final.R;


public class AdicionarCursosFragment extends Fragment {

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

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CursandoActivity.class);
                startActivity(intent);
            }
        });
    }
}