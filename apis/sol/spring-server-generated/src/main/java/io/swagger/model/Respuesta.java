package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Respuesta
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-19T22:48:17.734915880Z[GMT]")


public class Respuesta   {
  @JsonProperty("codigo")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer codigo = null;

  @JsonProperty("tipo")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String tipo = null;

  @JsonProperty("mensaje")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String mensaje = null;


  public Respuesta codigo(Integer codigo) { 

    this.codigo = codigo;
    return this;
  }

  /**
   * Get codigo
   * @return codigo
   **/
  
  @Schema(example = "1", description = "")
  
  public Integer getCodigo() {  
    return codigo;
  }



  public void setCodigo(Integer codigo) { 
    this.codigo = codigo;
  }

  public Respuesta tipo(String tipo) { 

    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
   **/
  
  @Schema(example = "OK / NO OOK", description = "")
  
  public String getTipo() {  
    return tipo;
  }



  public void setTipo(String tipo) { 
    this.tipo = tipo;
  }

  public Respuesta mensaje(String mensaje) { 

    this.mensaje = mensaje;
    return this;
  }

  /**
   * Get mensaje
   * @return mensaje
   **/
  
  @Schema(example = "Ejecución exitosa / Ejecución no exitosa", description = "")
  
  public String getMensaje() {  
    return mensaje;
  }



  public void setMensaje(String mensaje) { 
    this.mensaje = mensaje;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Respuesta respuesta = (Respuesta) o;
    return Objects.equals(this.codigo, respuesta.codigo) &&
        Objects.equals(this.tipo, respuesta.tipo) &&
        Objects.equals(this.mensaje, respuesta.mensaje);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, tipo, mensaje);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Respuesta {\n");
    
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
