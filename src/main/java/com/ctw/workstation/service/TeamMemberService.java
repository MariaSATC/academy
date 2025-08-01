package com.ctw.workstation.service;

import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.entity.TeamMember;
import com.ctw.workstation.mapper.TeamMemberMapper;
import com.ctw.workstation.repository.TeamMemberRepository;
import com.ctw.workstation.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberService {

    @Inject
    TeamRepository teamRepository;

    @Inject
    TeamMemberRepository teamMemberRepository;

    @Inject
    TeamMemberMapper teamMemberMapper;

    @Inject
    Logger log;


    @Transactional
    public TeamMemberDTO createTeamMember(TeamMemberDTO teamMemberDto){
        log.infov("Create TeamMember {0}", teamMemberDto);

        Team team = teamRepository.findById(teamMemberDto.getTeamId());

        if(team == null){ throw new EntityNotFoundException(); }

        TeamMember teamMember = teamMemberMapper.toEntity(teamMemberDto);

        teamMemberRepository.persist(teamMember);

        return teamMemberMapper.toResource(teamMember);
    }


    public TeamMemberDTO getTeamMemberById(UUID id){
        TeamMember teamMember = teamMemberRepository.findById(id);

        if(teamMember==null){ throw new EntityNotFoundException("TeamMember with id "+id+" not found"); }

        return teamMemberMapper.toResource(teamMember);
    }

    public List<TeamMemberDTO> getAllTeamMembers(){
        return teamMemberRepository.getAllTeamMembers();
    }


    public TeamMemberDTO deleteTeamMember(UUID id){
        teamMemberRepository.deleteById(id);
        return  teamMemberMapper.toResource(teamMemberRepository.findById(id));
    }
}
 