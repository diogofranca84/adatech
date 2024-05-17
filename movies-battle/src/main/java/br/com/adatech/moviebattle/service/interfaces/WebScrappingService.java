package br.com.adatech.moviebattle.service.interfaces;

import java.util.List;

import br.com.adatech.moviebattle.entities.Movie;

public interface WebScrappingService {

    List<Movie> getMoviesFromWebScrapping();

}
