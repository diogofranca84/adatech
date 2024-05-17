package br.com.adatech.moviebattle.service.mappers;

import br.com.adatech.moviebattle.entities.Movie;
import br.com.adatech.moviebattle.openapi.model.MovieOption;
import br.com.adatech.moviebattle.openapi.model.Rodada;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-17T14:33:02+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class RodadaMapperImpl implements RodadaMapper {

    @Override
    public br.com.adatech.moviebattle.entities.Rodada map(Rodada openApiModel) {
        if ( openApiModel == null ) {
            return null;
        }

        br.com.adatech.moviebattle.entities.Rodada rodada = new br.com.adatech.moviebattle.entities.Rodada();

        rodada.setMovies( movieOptionListToMovieList( openApiModel.getMovies() ) );

        return rodada;
    }

    @Override
    public Rodada map(br.com.adatech.moviebattle.entities.Rodada entity) {
        if ( entity == null ) {
            return null;
        }

        Rodada rodada = new Rodada();

        rodada.setMovies( movieListToMovieOptionList( entity.getMovies() ) );

        setMessage( rodada, entity );

        return rodada;
    }

    protected Movie movieOptionToMovie(MovieOption movieOption) {
        if ( movieOption == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setOpcao( movieOption.getOpcao() );
        movie.setPlot( movieOption.getPlot() );

        return movie;
    }

    protected List<Movie> movieOptionListToMovieList(List<MovieOption> list) {
        if ( list == null ) {
            return null;
        }

        List<Movie> list1 = new ArrayList<Movie>( list.size() );
        for ( MovieOption movieOption : list ) {
            list1.add( movieOptionToMovie( movieOption ) );
        }

        return list1;
    }

    protected MovieOption movieToMovieOption(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieOption movieOption = new MovieOption();

        movieOption.setTitle( movie.getTitle() );
        movieOption.setOpcao( movie.getOpcao() );
        movieOption.setPlot( movie.getPlot() );

        return movieOption;
    }

    protected List<MovieOption> movieListToMovieOptionList(List<Movie> list) {
        if ( list == null ) {
            return null;
        }

        List<MovieOption> list1 = new ArrayList<MovieOption>( list.size() );
        for ( Movie movie : list ) {
            list1.add( movieToMovieOption( movie ) );
        }

        return list1;
    }
}
