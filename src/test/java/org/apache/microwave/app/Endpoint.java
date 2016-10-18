package org.apache.microwave.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@ApplicationScoped
public class Endpoint {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String simple() {
        return "simple";
    }

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public Simple json() {
        return new Simple("test");
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Simple {
        private String name;
    }
}
