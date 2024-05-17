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
 * Mensagem
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-17T14:33:04.672888700+01:00[Europe/Lisbon]")
public class Mensagem   {
  @JsonProperty("msg")
  private String msg;

  public Mensagem msg(String msg) {
    this.msg = msg;
    return this;
  }

  /**
   * Get msg
   * @return msg
  */
  @ApiModelProperty(value = "")


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mensagem mensagem = (Mensagem) o;
    return Objects.equals(this.msg, mensagem.msg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mensagem {\n");
    
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
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

