package br.com.adatech.moviebattle.openapi.model;

import java.util.Objects;
import br.com.adatech.moviebattle.openapi.model.MovieOption;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Objeto que representa uma rodada no jogo.
 */
@ApiModel(description = "Objeto que representa uma rodada no jogo.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-17T14:33:04.672888700+01:00[Europe/Lisbon]")
public class Rodada   {
  @JsonProperty("message")
  private String message;

  @JsonProperty("movies")
  @Valid
  private List<MovieOption> movies = null;

  public Rodada message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Mensagem do sistema a cada rodada.
   * @return message
  */
  @ApiModelProperty(value = "Mensagem do sistema a cada rodada.")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Rodada movies(List<MovieOption> movies) {
    this.movies = movies;
    return this;
  }

  public Rodada addMoviesItem(MovieOption moviesItem) {
    if (this.movies == null) {
      this.movies = new ArrayList<>();
    }
    this.movies.add(moviesItem);
    return this;
  }

  /**
   * Filmes que representam as opções nesta rodada.
   * @return movies
  */
  @ApiModelProperty(value = "Filmes que representam as opções nesta rodada.")

  @Valid

  public List<MovieOption> getMovies() {
    return movies;
  }

  public void setMovies(List<MovieOption> movies) {
    this.movies = movies;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rodada rodada = (Rodada) o;
    return Objects.equals(this.message, rodada.message) &&
        Objects.equals(this.movies, rodada.movies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, movies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rodada {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    movies: ").append(toIndentedString(movies)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

