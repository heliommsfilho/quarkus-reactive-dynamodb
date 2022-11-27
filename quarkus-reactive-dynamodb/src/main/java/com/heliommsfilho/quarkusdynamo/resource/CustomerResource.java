package com.heliommsfilho.quarkusdynamo.resource;

import com.heliommsfilho.quarkusdynamo.service.CustomerService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    @Path("/tableInfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getTableInfo() {
        return customerService.getTableInfo().map(tableInfo -> Response.ok(tableInfo).build());
    }
}