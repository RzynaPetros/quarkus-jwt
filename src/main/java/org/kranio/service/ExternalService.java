package org.kranio.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.HeaderParam;

@RegisterRestClient(configKey="external-services")

public interface ExternalService {

    @GET
    @Path("/poc/authenticated/example")
    @Produces(MediaType.TEXT_PLAIN)
    String callExample(@HeaderParam("Authorization") String jwt);

}

