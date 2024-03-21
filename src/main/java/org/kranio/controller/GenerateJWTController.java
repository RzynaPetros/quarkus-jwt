package org.kranio.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import io.smallrye.jwt.build.Jwt;
import java.time.Duration;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.kranio.service.ExternalService;

@Path("/generar-jwt")
public class GenerateJWTController {

    @Inject
    @RestClient
    ExternalService externalService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String generarToken() {
        String token = Jwt.issuer("https://kranio.io/issuer") //quien creo y firmo el token
                .upn("pgarcias@kranio.io") //nombre de usuario o correo del titular del token
                .expiresIn(Duration.ofHours(1)) // Expira en 1 hora
                .sign();

        System.out.println(token);
        String bearer = "Bearer " + token;
        return externalService.callExample(bearer);
    }
}









    /* 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String generarToken() {
        String token = Jwt.issuer("https://kranio.io/issuer") //quien creo y firmo el token
                .upn("pgarcias@kranio.io") //nombre de usuario o correo del titular del token
                .expiresIn(Duration.ofHours(1)) // Expira en 1 hora
                .sign();
        return token;
    }
    */