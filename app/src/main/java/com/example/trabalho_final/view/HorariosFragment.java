package com.example.trabalho_final.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trabalho_final.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HorariosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HorariosFragment extends Fragment {


    public HorariosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horarios, container, false);
    }
}