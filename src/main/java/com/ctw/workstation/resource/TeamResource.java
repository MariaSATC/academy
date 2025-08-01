package com.ctw.workstation.resource;

import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.service.TeamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/teams")
public class TeamResource {

    @Inject
    Logger log;

    @Inject
    TeamService teamService;

    @GET
    public List<TeamDTO> getAllTeams(){
        return teamService.getAllTeams();
    }


    @GET
    @Path("/{id}")
    public TeamDTO getTeamById(@PathParam("id") UUID id){
        return teamService.getTeamById(id);
    }

    @POST
    public Response createTeam(TeamDTO teamDto){
        log.debug("Creating new team with id " + teamDto.getId());
        return Response.status(Response.Status.CREATED).entity(teamService.createTeam(teamDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") UUID id){
        return Response.status(Response.Status.CREATED).entity(teamService.deleteTeam(id)).build();
    }
}
 