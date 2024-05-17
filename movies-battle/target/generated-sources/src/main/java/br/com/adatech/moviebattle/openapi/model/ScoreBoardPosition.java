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
 * ScoreBoardPosition
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-17T14:33:04.672888700+01:00[Europe/Lisbon]")
public class ScoreBoardPosition   {
  @JsonProperty("nome")
  private String nome;

  @JsonProperty("pontuacao")
  private Long pontuacao;

  @JsonProperty("posicao")
  private Integer posicao;

  public ScoreBoardPosition nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  @ApiModelProperty(value = "")


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ScoreBoardPosition pontuacao(Long pontuacao) {
    this.pontuacao = pontuacao;
    return this;
  }

  /**
   * Get pontuacao
   * @return pontuacao
  */
  @ApiModelProperty(value = "")


  public Long getPontuacao() {
    return pontuacao;
  }

  public void setPontuacao(Long pontuacao) {
    this.pontuacao = pontuacao;
  }

  public ScoreBoardPosition posicao(Integer posicao) {
    this.posicao = posicao;
    return this;
  }

  /**
   * Get posicao
   * @return posicao
  */
  @ApiModelProperty(value = "")


  public Integer getPosicao() {
    return posicao;
  }

  public void setPosicao(Integer posicao) {
    this.posicao = posicao;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScoreBoardPosition scoreBoardPosition = (ScoreBoardPosition) o;
    return Objects.equals(this.nome, scoreBoardPosition.nome) &&
        Objects.equals(this.pontuacao, scoreBoardPosition.pontuacao) &&
        Objects.equals(this.posicao, scoreBoardPosition.posicao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, pontuacao, posicao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScoreBoardPosition {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    pontuacao: ").append(toIndentedString(pontuacao)).append("\n");
    sb.append("    posicao: ").append(toIndentedString(posicao)).append("\n");
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

