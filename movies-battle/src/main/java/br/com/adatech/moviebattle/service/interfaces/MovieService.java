package br.com.adatech.moviebattle.service.interfaces;

import java.util.List;

import br.com.adatech.moviebattle.entities.Jogo;
import br.com.adatech.moviebattle.entities.Movie;

public interface MovieService {

    List<Movie> getTwoRandomMovies(Jogo jogo);

}

