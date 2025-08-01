package com.ctw.workstation.service;

import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.mapper.TeamMapper;
import com.ctw.workstation.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository teamRepository;

    @Inject
    TeamMapper teamMapper;

    @Inject
    Logger log;


    @Transactional
    public TeamDTO createTeam(TeamDTO teamDto){
//        for(TeamMember tm:  teamDto.getTeamMembers()){
//            //TeamMember teamMember = teamMemberRepository.findById(teamDto.getTeamMemberId());
//            if(tm == null){ throw new EntityNotFoundException(); }
//        }
        log.infov("Create Team {0}", teamDto);

        Team team = teamMapper.toEntity(teamDto);

        teamRepository.persist(team);

        return teamMapper.toResource(team);
    }


    public TeamDTO getTeamById(UUID id){
        Team team = teamRepository.findById(id);

        if(team==null){ throw new EntityNotFoundException("Team with id "+ id +" not found"); }

        return teamMapper.toResource(team);
    }

    public List<TeamDTO> getAllTeams(){
        return teamRepository.getAllTeams();
    }


    public TeamDTO deleteTeam(UUID id){
        teamRepository.deleteById(id);
        return  teamMapper.toResource(teamRepository.findById(id));
    }
}
 