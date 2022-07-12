package com.example.trabalho_final.view;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.UsuarioBLL;
import com.example.trabalho_final.dao.AppDB;

public class HomeFragment extends Fragment {

    private static final String APP_PREF_ID = "MeuAppPrefID";
    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}