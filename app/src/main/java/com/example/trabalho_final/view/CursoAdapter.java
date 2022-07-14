package com.example.trabalho_final.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.CursoBLL;
import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Curso;
import com.example.trabalho_final.dao.Periodo;
import com.example.trabalho_final.dao.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CursoAdapter extends BaseAdapter {
    private Context context;
    private List<Curso> cursos;

    public CursoAdapter(Context context, List<Curso> cursos){

        this.context = context;
        this.cursos = cursos;
    }


    public int getCount() {
        return this.cursos.size();
    }


    public Object getItem(int position) {
        return this.cursos.get(position);
    }


    public long getItemId(int position) {
        return this.cursos.get(position).getId();
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        HolderView holderView;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.cards_cursos_layout, parent, false);

            holderView = new HolderView(convertView);
            convertView.setTag(holderView);

        }else{
            holderView = (HolderView) convertView.getTag();

        }

        Curso curso = cursos.get(position);

        holderView.nomeDoCurso.setText(curso.getNomeCurso());

        List<Periodo> periodos = curso.getPeriodosCurso();

        if (periodos.size() == 0){
            holderView.periodo.setText("-");
        }

        Periodo periodoAtual = periodos.get(periodos.size() - 1);

        holderView.periodo.setText(periodoAtual.getNumeroPeriodo() + "");


        return convertView;

    }

    private static class HolderView{
        private final TextView nomeDoCurso;
        private final TextView periodo;

        public HolderView(View view){
            nomeDoCurso = view.findViewById(R.id.card_nome_do_curso);
            periodo = view.findViewById(R.id.card_periodo_exibido);

        }
    }


    public void updateList(String nome) {
        AppDB appDB = new AppDB(context,nome);
        CursoBLL cursoBLL = new CursoBLL(appDB);
        this.cursos = cursoBLL.getAll();
    }
}

