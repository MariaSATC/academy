package com.ctw.workstation.resource;

import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.service.TeamMemberService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/teamMembers")
public class TeamMemberResource {

    @Inject
    Logger log;

    @Inject
    TeamMemberService teamMemberService;

    @GET
    public List<TeamMemberDTO> getAllTeamMembers(){
        return teamMemberService.getAllTeamMembers();
    }


    @GET
    @Path("/{id}")
    public TeamMemberDTO getTeamMemberById(@PathParam("id") UUID id){
        return teamMemberService.getTeamMemberById(id);
    }

    @POST
    public Response createTeamMember(TeamMemberDTO teamDto){
        log.debug("Creating new team member with id " + teamDto.getId());
        return Response.status(Response.Status.CREATED).entity(teamMemberService.createTeamMember(teamDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamMember(@PathParam("id") UUID id){
        return Response.status(Response.Status.CREATED).entity(teamMemberService.deleteTeamMember(id)).build();
    }
}
 