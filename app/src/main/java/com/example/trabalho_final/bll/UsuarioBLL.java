package com.example.trabalho_final.bll;

import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Tarefa;
import com.example.trabalho_final.dao.TarefaDAO;
import com.example.trabalho_final.dao.Usuario;
import com.example.trabalho_final.dao.UsuarioDAO;

import java.util.List;

public class UsuarioBLL {

    private AppDB appDB;

    public UsuarioBLL(AppDB appDB){
        this.appDB = appDB;
    }

    public boolean create(String nome, String email) {
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.appDB);

        Usuario newUsuario = new Usuario(nome, email);

        if (!newUsuario.isValid())
            return false;

        Usuario usuario = usuarioDAO.getById(newUsuario);
        if (usuario != null)
            return false;

        boolean result = usuarioDAO.create(newUsuario);
        return result;
    }

    public Usuario getUsuario(String email) {

        UsuarioDAO usuarioDAO = new UsuarioDAO(this.appDB);
        Usuario usuario = new Usuario(email);

        return usuarioDAO.getByEmail(usuario);
    }

    public List<Usuario> getAll() {
        List<Usuario> usuarios;

        UsuarioDAO usuarioDAO = new UsuarioDAO(this.appDB);
        usuarios = usuarioDAO.getAll();

        return usuarios;
    }

}
