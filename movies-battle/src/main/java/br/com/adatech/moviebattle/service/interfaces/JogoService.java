package br.com.adatech.moviebattle.service.interfaces;

import br.com.adatech.moviebattle.entities.Jogo;

public interface JogoService {

    Jogo inicializarJogo();

    Jogo findJogoByUsuario();

    String finalizarJogo(Jogo jogo);

}
