package com.heliommsfilho.quarkusdynamo.resource;

import com.heliommsfilho.quarkusdynamo.model.customer.CustomerInput;
import com.heliommsfilho.quarkusdynamo.service.CustomerService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
        return customerService.getTableInfo().map(item -> Response.ok(item).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> create(@Valid CustomerInput input) {
        return customerService.create(input).map(items -> Response.ok(items).build());
    }

    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getSingle(final @PathParam("customerId") String customerId) {
        return customerService.getSingle(customerId).map(item -> Response.ok(item).build());
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getAll() {
        return customerService.getAll().map(items -> Response.ok(items).build());
    }
}
