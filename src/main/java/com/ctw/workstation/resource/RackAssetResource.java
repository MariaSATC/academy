package com.ctw.workstation.resource;

import com.ctw.workstation.dto.RackAssetDTO;
import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.service.RackAssetService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/rackAssets")
public class RackAssetResource {

    @Inject
    RackAssetService rackAssetService;

    @GET
    public List<RackDTO> getAllRackAssets(){
        return rackAssetService.getAllRackAssets();
    }


    @GET
    @Path("/{id}")
    public RackAssetDTO getRackAssetById(@PathParam("id") UUID id){
        return rackAssetService.getRackAssetById(id);
    }

    @POST
    public Response createRackAsset(RackAssetDTO rackAssetDto){
        return Response.status(Response.Status.CREATED).entity(rackAssetService.createRackAsset(rackAssetDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRackAsset(@PathParam("id") UUID id){
        return Response.status(Response.Status.CREATED).entity(rackAssetService.deleteRackAsset(id)).build();
    }
}
 