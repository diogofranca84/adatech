package br.com.adatech.moviebattle.service.interfaces;

import br.com.adatech.moviebattle.entities.Rodada;
import br.com.adatech.moviebattle.entities.Usuario;

public interface RodadasService {

    Rodada inicializarRodada(Usuario usuario);

    String jogar(int numeroFilme);

}