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
 * Objeto que representa um usuário no jogo.
 */
@ApiModel(description = "Objeto que representa um usuário no jogo.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-17T14:21:08.981220400+01:00[Europe/Lisbon]")
public class User   {
  @JsonProperty("nome")
  private String nome;

  @JsonProperty("senha")
  private String senha;

  @JsonProperty("usuario")
  private String usuario;

  public User nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome do usuário.
   * @return nome
  */
  @ApiModelProperty(required = true, value = "Nome do usuário.")
  @NotNull


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public User senha(String senha) {
    this.senha = senha;
    return this;
  }

  /**
   * Representa a senha no jogo.
   * @return senha
  */
  @ApiModelProperty(required = true, value = "Representa a senha no jogo.")
  @NotNull


  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public User usuario(String usuario) {
    this.usuario = usuario;
    return this;
  }

  /**
   * Nome de usuário no jogo.
   * @return usuario
  */
  @ApiModelProperty(required = true, value = "Nome de usuário no jogo.")
  @NotNull


  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.nome, user.nome) &&
        Objects.equals(this.senha, user.senha) &&
        Objects.equals(this.usuario, user.usuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, senha, usuario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    senha: ").append(toIndentedString(senha)).append("\n");
    sb.append("    usuario: ").append(toIndentedString(usuario)).append("\n");
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

