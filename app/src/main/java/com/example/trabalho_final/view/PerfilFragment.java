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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.UsuarioBLL;
import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Usuario;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class PerfilFragment extends Fragment {


    private static final String APP_PREF_ID = "MeuAppPrefID";


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_perfil, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnCursando = getView().findViewById(R.id.btn_cursando);
        TextView txtNome = getView().findViewById(R.id.txt_perfil_nome);
        TextView txtEmail = getView().findViewById(R.id.txt_perfil_email);


        SharedPreferences pref = getActivity().getBaseContext().getSharedPreferences(APP_PREF_ID, 0);

        String email = pref.getString("email", "");

        AppDB appDB = new AppDB(getActivity().getBaseContext(), email + "_DB");

        UsuarioBLL usuarioBLL = new UsuarioBLL(appDB);

         Usuario usuario = usuarioBLL.getUsuario(email);



//        List<Usuario> usuarios = usuarioBLL.getAll();
//
//        Usuario usuario = usuarios.get(0);

        String emailString = usuario.getEmail();
        String nomeString = usuario.getNome();

        txtEmail.setText(emailString);
        txtNome.setText(nomeString);

        btnCursando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CursandoActivity.class);
                startActivity(intent);
            }
        });

    }
}