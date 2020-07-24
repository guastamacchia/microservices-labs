package com.ibm.cloud.academy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cognome")
public class CognomeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String cognome() {
        return "Rossi";
    }
}