package com.ctw.workstation.repository;

import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.TeamMember;
import com.ctw.workstation.mapper.TeamMemberMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@ApplicationScoped
public class TeamMemberRepository implements PanacheRepositoryBase<TeamMember,UUID> {

    @Inject
    TeamMemberMapper teamMemberMapper;

    public List<TeamMemberDTO> getAllTeamMembers(){
        List<TeamMember> teamMembers = listAll();

        List<TeamMemberDTO> teamMembersDtos =  new ArrayList<>();
        teamMembers.forEach(tm -> {
            TeamMemberDTO teamMemberDto = teamMemberMapper.toResource(tm);
            teamMembersDtos.add(teamMemberDto);
        });

        return teamMembersDtos;
    }

    public Optional<TeamMember> getTeamMemberById(UUID id){
        return Optional.ofNullable(findById(id));
    }

    public Optional<TeamMember> getTeamMemberByName(String name){
        return find("name",name).firstResultOptional();
    }

    @Transactional
    public void createTeam(TeamMember teamMember){
        persist(teamMember);
    }

    @Transactional
    public boolean deleteById(UUID id){
        return delete("id",id) > 0;
    }

    public TeamMember getOrThrow(UUID id){
        return getTeamMemberById(id).orElseThrow(()->new EntityNotFoundException("Rack with id "+ id +" not found"));
    }
}
 