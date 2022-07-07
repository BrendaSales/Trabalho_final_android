package com.example.trabalho_final.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.example.trabalho_final.R;
import com.example.trabalho_final.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActivityMainBinding binding;
    HomeFragment homeFragment = new HomeFragment();
    HorariosFragment horariosFragment = new HorariosFragment();
    Provas_e_trabalhosFragment provasETrabalhosFragment = new Provas_e_trabalhosFragment();
    PerfilFragment perfilFragment = new PerfilFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(homeFragment);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

                switch (item.getItemId()) {
                    case R.id.home:
                        replaceFragment(homeFragment);
                        break;
                    case R.id.horarios:
                        replaceFragment(horariosFragment);
                        break;
                    case R.id.provasETrabalhos:
                        replaceFragment(provasETrabalhosFragment);
                        break;
                    case R.id.perfil:
                        replaceFragment(perfilFragment);
                        break;
                }
                return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }
}


