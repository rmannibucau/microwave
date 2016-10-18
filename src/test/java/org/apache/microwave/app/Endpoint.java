package org.apache.microwave.app;

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
}
