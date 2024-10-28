package mx.com.fractalyst.pocs;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Path("/{name}")
    public String greeting(String name) {
        return service.greeting(name);
    }

    @GET
    public String hello() {
        return "Hola DDD, Arquitectura Limpia y Microservicios en Java.";
    }
}