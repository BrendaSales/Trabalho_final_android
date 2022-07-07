package com.example.trabalho_final.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.trabalho_final.R;
import com.example.trabalho_final.databinding.ActivityCursandoBinding;
import com.example.trabalho_final.databinding.ActivityMainBinding;

public class CursandoActivity extends AppCompatActivity {

    ActivityCursandoBinding binding;

    CursosFragment cursosFragment = new CursosFragment();
    AdicionarCursosFragment adicionarCursosFragment = new AdicionarCursosFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCursandoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(cursosFragment);

        binding.bottomNavigationViewCursando.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.cursos:
                    replaceFragment(cursosFragment);
                    break;
                case R.id.adicionar_cursos:
                    replaceFragment(adicionarCursosFragment);
                    break;

            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragmentCursando, fragment);
        fragmentTransaction.commit();
    }
}