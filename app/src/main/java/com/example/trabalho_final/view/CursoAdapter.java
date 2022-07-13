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
import com.example.trabalho_final.dao.Usuario;

import java.util.List;

public class CursoAdapter extends BaseAdapter {
    private Context context;
    private List<Curso> cursos;


    //fiz essa modificação para pegar o banco da pessoa que esta logada
    public CursoAdapter(Context context,String email){
        AppDB appDB = new AppDB(context,email);
        CursoBLL cursoBLL = new CursoBLL(appDB);

        this.context = context;
        this.cursos = cursoBLL.getAll();
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
        Curso curso = this.cursos.get(position);

        View cursoView = LayoutInflater.from(this.context).inflate(R.layout.adapter_curso, parent, false);
        TextView cardViewNome = cursoView.findViewById(R.id.card_nome_do_curso);
        TextView cardViewNomePeriodo = cursoView.findViewById(R.id.txt_card_periodo_);
        TextView cardViewPeriodoExibido = cursoView.findViewById(R.id.card_periodo_exibido);

        cardViewNome.setText(curso.getNomeCurso());
        //aqui tinha que pegar o nome ultmo item da lista periodos
        cardViewNomePeriodo.setText(curso.getPeriodosCurso().get);
        //aqui tinha que pergar o numero do utimo item da lista periodo
        cardViewPeriodoExibido.setText(curso.getPeriodosCurso().get);
        return cursoView;
    }

    //tive que colocar essa parte do nome para ele saber em qual banco vai guardar
    public void updateList(String nome) {
        AppDB appDB = new AppDB(context,nome);
        CursoBLL cursoBLL = new CursoBLL(appDB);
        this.cursos = cursoBLL.getAll();
    }
}

