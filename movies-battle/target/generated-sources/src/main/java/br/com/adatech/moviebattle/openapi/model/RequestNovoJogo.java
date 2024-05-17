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
 * RequestNovoJogo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-17T14:33:04.672888700+01:00[Europe/Lisbon]")
public class RequestNovoJogo   {
  @JsonProperty("usuario")
  private String usuario;

  public RequestNovoJogo usuario(String usuario) {
    this.usuario = usuario;
    return this;
  }

  /**
   * Usuário que irá iniciar uma nova partida.
   * @return usuario
  */
  @ApiModelProperty(value = "Usuário que irá iniciar uma nova partida.")


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
    RequestNovoJogo requestNovoJogo = (RequestNovoJogo) o;
    return Objects.equals(this.usuario, requestNovoJogo.usuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usuario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestNovoJogo {\n");
    
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

