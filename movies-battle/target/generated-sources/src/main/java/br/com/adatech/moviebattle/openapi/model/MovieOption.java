package br.com.adatech.moviebattle.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Objeto que representa uma opção de filmes para escolha em cada rodada. 
 */
@ApiModel(description = "Objeto que representa uma opção de filmes para escolha em cada rodada. ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-17T14:21:08.981220400+01:00[Europe/Lisbon]")
public class MovieOption   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("opcao")
  private Integer opcao;

  @JsonProperty("plot")
  private String plot;

  public MovieOption title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Título do filme.
   * @return title
  */
  @ApiModelProperty(value = "Título do filme.")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public MovieOption opcao(Integer opcao) {
    this.opcao = opcao;
    return this;
  }

  /**
   * Opção do filme.
   * @return opcao
  */
  @ApiModelProperty(required = true, value = "Opção do filme.")
  @NotNull


  public Integer getOpcao() {
    return opcao;
  }

  public void setOpcao(Integer opcao) {
    this.opcao = opcao;
  }

  public MovieOption plot(String plot) {
    this.plot = plot;
    return this;
  }

  /**
   * Resumo sobre o filme.
   * @return plot
  */
  @ApiModelProperty(value = "Resumo sobre o filme.")


  public String getPlot() {
    return plot;
  }

  public void setPlot(String plot) {
    this.plot = plot;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MovieOption movieOption = (MovieOption) o;
    return Objects.equals(this.title, movieOption.title) &&
        Objects.equals(this.opcao, movieOption.opcao) &&
        Objects.equals(this.plot, movieOption.plot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, opcao, plot);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MovieOption {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    opcao: ").append(toIndentedString(opcao)).append("\n");
    sb.append("    plot: ").append(toIndentedString(plot)).append("\n");
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

