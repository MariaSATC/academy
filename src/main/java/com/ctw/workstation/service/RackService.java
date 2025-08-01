package com.ctw.workstation.service;

import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.Status;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.mapper.RackMapper;
import com.ctw.workstation.repository.RackRepository;
import com.ctw.workstation.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepository;

    @Inject
    TeamRepository teamRepository;

    @Inject
    RackMapper rackMapper;

    @Inject
    Logger log;



    @Transactional
    public RackDTO createRack(RackDTO rackDto){
        log.infov("Create Rack {0}", rackDto);

        Team team = teamRepository.findById(rackDto.getTeamId());

        if(team == null){ throw new EntityNotFoundException(); }

        Rack rack = rackMapper.toEntity(rackDto);

        rackRepository.persist(rack);

        return rackMapper.toResource(rack);
    }


    public RackDTO getRackById(UUID id){
        Rack rack = rackRepository.findById(id);

        if(rack==null){ throw new EntityNotFoundException("Rack with id "+id+" not found"); }

        return rackMapper.toResource(rack);
    }

    public List<RackDTO> getAllRacks(){
        return rackRepository.getAllRacks();
    }


    public RackDTO deleteRack(UUID id){
        rackRepository.deleteById(id);
        return  rackMapper.toResource(rackRepository.findById(id));
    }

    public RackDTO updateRackStatus(UUID id, Status status){
        rackRepository.updateRackStatus(id, status);
        return  rackMapper.toResource(rackRepository.findById(id));
    }
}
 