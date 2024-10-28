package io.swagger.api;

import io.swagger.model.Cliente;
import io.swagger.model.Respuesta;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-19T22:48:17.734915880Z[GMT]")
@RestController
public class ClientesApiController implements ClientesApi {

    private static final Logger log = LoggerFactory.getLogger(ClientesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ClientesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createCliente(@Parameter(in = ParameterIn.DEFAULT, description = "Crea un cliente.", schema=@Schema()) @Valid @RequestBody Cliente body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Respuesta> deleteCliente(@Parameter(in = ParameterIn.PATH, description = "Identificador de un Respuesta.", required=true, schema=@Schema()) @PathVariable("id-cliente") String idCliente
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Respuesta>(objectMapper.readValue("{\n  \"codigo\" : 1,\n  \"tipo\" : \"OK / NO OOK\",\n  \"mensaje\" : \"Ejecución exitosa / Ejecución no exitosa\"\n}", Respuesta.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cliente> getCliente(@Parameter(in = ParameterIn.PATH, description = "Identificador de un cliente.", required=true, schema=@Schema()) @PathVariable("id-cliente") String idCliente
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cliente>(objectMapper.readValue("{\n  \"apellidoPaterno\" : \"Pérez\",\n  \"id\" : 10,\n  \"nombre\" : \"Juan\",\n  \"apellidoMaterno\" : \"López\"\n}", Cliente.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cliente>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cliente> updateCliente(@Parameter(in = ParameterIn.PATH, description = "Identificador de un cliente.", required=true, schema=@Schema()) @PathVariable("id-cliente") String idCliente
,@Parameter(in = ParameterIn.DEFAULT, description = "Datos para actualizar el estado de un cliente", schema=@Schema()) @Valid @RequestBody Cliente body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cliente>(objectMapper.readValue("{\n  \"apellidoPaterno\" : \"Pérez\",\n  \"id\" : 10,\n  \"nombre\" : \"Juan\",\n  \"apellidoMaterno\" : \"López\"\n}", Cliente.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cliente>(HttpStatus.NOT_IMPLEMENTED);
    }

}
