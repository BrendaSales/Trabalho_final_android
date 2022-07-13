package com.example.trabalho_final.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trabalho_final.R;
import com.example.trabalho_final.bll.CursoBLL;
import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Curso;
import com.example.trabalho_final.dao.Usuario;

import java.util.List;

public class CursoAdapter {
    private Context context;
    private List<Curso> cursos;

    private static final String APP_PREF_ID = "MeuAppPrefID";
    SharedPreferences pref = new LoginActivity().getBaseContext().getSharedPreferences(APP_PREF_ID, 0);
    String email = pref.getString("email", "");

    //fiz essa modificação para pegar o banco da pessoa que esta logada
    public CursoAdapter(Context context){
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
        TextView cursoNome = cursoView.findViewById(R.id.adp_curso_name);
        //TextView usuarioCurso = cursoView.findViewById(R.id.adp_usuario_curso);

        cursoNome.setText(curso.getNomeCurso());
        //usuarioCurso.setText(curso.getUsuarioId().getNome());

        return cursoView;
    }

    //tive que colocar essa parte do nome para ele saber em qual banco vai guardar
    public void updateList(String nome) {
        AppDB appDB = new AppDB(context,nome);
        CursoBLL cursoBLL = new CursoBLL(appDB);
        this.cursos = cursoBLL.getAll();
    }
}


}
