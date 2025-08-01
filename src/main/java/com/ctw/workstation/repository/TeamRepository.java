package com.ctw.workstation.repository;

import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.mapper.TeamMapper;
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
public class TeamRepository implements PanacheRepositoryBase<Team,UUID> {

    @Inject
    TeamMapper teamMapper;

    public List<TeamDTO> getAllTeams(){
        List<Team> teams =listAll();

        List<TeamDTO> teamDtos =  new ArrayList<>();
        teams.forEach(rack -> {
            TeamDTO teamDto = teamMapper.toResource(rack);
            teamDtos.add(teamDto);
        });

        return teamDtos;
    }

    public Optional<Team> getTeamById(UUID id){
        return Optional.ofNullable(findById(id));
    }

    public Optional<Team> getTeamByName(String name){
        return find("name",name).firstResultOptional();
    }

    @Transactional
    public void createTeam(Team team){
        persist(team);
    }

    @Transactional
    public boolean deleteById(UUID id){
        return delete("id",id) > 0;
    }

    public Team getOrThrow(UUID id){
        return getTeamById(id).orElseThrow(()->new EntityNotFoundException("Rack with id "+ id +" not found"));
    }
}
 