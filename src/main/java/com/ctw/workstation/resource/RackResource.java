package com.ctw.workstation.resource;

import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Status;
import com.ctw.workstation.service.RackService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/racks")
public class RackResource {

    @Inject
    Logger log;


    @Inject
    RackService rackService;

    @GET
    public List<RackDTO> getAllRacks(){
        return rackService.getAllRacks();
    }


    @GET
    @Path("/{id}")
    public RackDTO getRackById(
            @PathParam("id") UUID id
    ){
        return rackService.getRackById(id);
    }

    @POST
    public Response createRack(RackDTO rackDto){
        log.debug("Creating new rack with id " + rackDto.getId());
        return Response.status(Response.Status.CREATED).entity(rackService.createRack(rackDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") UUID id){
        return Response.status(Response.Status.CREATED).entity(rackService.deleteRack(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRackStatus(@PathParam("id") UUID id, Status status){
        return Response.status(Response.Status.OK).entity(rackService.updateRackStatus(id, status)).build();
    }
}
 