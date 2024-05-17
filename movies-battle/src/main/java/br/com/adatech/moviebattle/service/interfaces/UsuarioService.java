package br.com.adatech.moviebattle.service.interfaces;

import java.util.List;

import br.com.adatech.moviebattle.entities.Usuario;

public interface UsuarioService {

    Usuario getUsuario(String string);

    List<Usuario> getScoreBoard();

    String getUsernameUsuarioLogado();
}
