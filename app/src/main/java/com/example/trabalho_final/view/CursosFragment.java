package com.example.trabalho_final.view;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.CursoBLL;
import com.example.trabalho_final.bll.UsuarioBLL;
import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Curso;
import com.example.trabalho_final.dao.CursoDAO;
import com.example.trabalho_final.dao.Usuario;
import com.example.trabalho_final.dao.UsuarioDAO;

import java.util.ArrayList;
import java.util.List;

public class CursosFragment extends Fragment {
    private List<Curso> cursos;
    private static final String APP_PREF_ID = "MeuAppPrefID";

    public CursosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cursos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listCursos = getView().findViewById(R.id.list_lista_dos_cursos);


        SharedPreferences pref = getActivity().getBaseContext().getSharedPreferences(APP_PREF_ID, 0);
        String email = pref.getString("email", "");
        AppDB appDB = new AppDB(getActivity().getBaseContext(), email + "_DB");

        UsuarioBLL usuarioBll = new UsuarioBLL(appDB);

        Usuario usuario = usuarioBll.getUsuario(email);

        cursos = usuario.getCursosUsuario();


        CursoAdapter cursoAdapter = new CursoAdapter(getActivity().getBaseContext(), cursos);
        listCursos.setAdapter(cursoAdapter);

    }


    public void updateList() {

        SharedPreferences pref = getActivity().getBaseContext().getSharedPreferences(APP_PREF_ID, 0);
        String email = pref.getString("email", "");
        AppDB appDB = new AppDB(getActivity().getBaseContext(), email + "_DB");

        CursoBLL cursoBLL = new CursoBLL(appDB);
        this.cursos = cursoBLL.getAll();
    }
}