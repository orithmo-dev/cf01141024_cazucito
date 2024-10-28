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
 * Cliente
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-19T22:48:17.734915880Z[GMT]")


public class Cliente   {
  @JsonProperty("id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Long id = null;

  @JsonProperty("nombre")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String nombre = null;

  @JsonProperty("apellidoPaterno")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String apellidoPaterno = null;

  @JsonProperty("apellidoMaterno")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String apellidoMaterno = null;


  public Cliente id(Long id) { 

    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
  @Schema(example = "10", description = "")
  
  public Long getId() {  
    return id;
  }



  public void setId(Long id) { 
    this.id = id;
  }

  public Cliente nombre(String nombre) { 

    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
   **/
  
  @Schema(example = "Juan", description = "")
  
  public String getNombre() {  
    return nombre;
  }



  public void setNombre(String nombre) { 
    this.nombre = nombre;
  }

  public Cliente apellidoPaterno(String apellidoPaterno) { 

    this.apellidoPaterno = apellidoPaterno;
    return this;
  }

  /**
   * Get apellidoPaterno
   * @return apellidoPaterno
   **/
  
  @Schema(example = "Pérez", description = "")
  
  public String getApellidoPaterno() {  
    return apellidoPaterno;
  }



  public void setApellidoPaterno(String apellidoPaterno) { 
    this.apellidoPaterno = apellidoPaterno;
  }

  public Cliente apellidoMaterno(String apellidoMaterno) { 

    this.apellidoMaterno = apellidoMaterno;
    return this;
  }

  /**
   * Get apellidoMaterno
   * @return apellidoMaterno
   **/
  
  @Schema(example = "López", description = "")
  
  public String getApellidoMaterno() {  
    return apellidoMaterno;
  }



  public void setApellidoMaterno(String apellidoMaterno) { 
    this.apellidoMaterno = apellidoMaterno;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(this.id, cliente.id) &&
        Objects.equals(this.nombre, cliente.nombre) &&
        Objects.equals(this.apellidoPaterno, cliente.apellidoPaterno) &&
        Objects.equals(this.apellidoMaterno, cliente.apellidoMaterno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, apellidoPaterno, apellidoMaterno);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cliente {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellidoPaterno: ").append(toIndentedString(apellidoPaterno)).append("\n");
    sb.append("    apellidoMaterno: ").append(toIndentedString(apellidoMaterno)).append("\n");
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
