package com.heliommsfilho.quarkusdynamo.resource;

import com.heliommsfilho.quarkusdynamo.service.ParkingService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/parking")
public class ParkingResource {

    @Inject
    ParkingService parkingService;

    @GET
    @Path("/tableInfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getTableInfo() {
        return parkingService.getTableInfo().map(tableInfo -> Response.ok(tableInfo).build());
    }

    @GET
    @Path("/{customerId}/{licensePlate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getSingle(final @PathParam("customerId") String customerId, final @PathParam("licensePlate") String licensePlate) {
        return parkingService.getSingle(customerId, licensePlate).map(item -> Response.ok(item).build());
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getAll() {
        return parkingService.getAll().map(items -> Response.ok(items).build());
    }
}
