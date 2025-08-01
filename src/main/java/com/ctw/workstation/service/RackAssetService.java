package com.ctw.workstation.service;

import com.ctw.workstation.dto.RackAssetDTO;
import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.RackAsset;
import com.ctw.workstation.mapper.RackAssetMapper;
import com.ctw.workstation.repository.RackAssetRepository;
import com.ctw.workstation.repository.RackRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetService {

    @Inject
    RackAssetRepository rackAssetRepository;

    @Inject
    RackRepository rackRepository;

    @Inject
    RackAssetMapper rackAssetMapper;

    @Inject
    Logger log;

    @Transactional
    public RackAssetDTO createRackAsset(RackAssetDTO rackAssetDto){
        log.infov("Create RackAsset {0}", rackAssetDto);

        Rack rack = rackRepository.findById(rackAssetDto.getRackId());

        if(rack == null){ throw new EntityNotFoundException(); }

        RackAsset rackAsset = rackAssetMapper.toEntity(rackAssetDto);

        rackAssetRepository.persist(rackAsset);

        return rackAssetMapper.toResource(rackAsset);
    }


    public RackAssetDTO getRackAssetById(UUID id){
        RackAsset rackAsset = rackAssetRepository.findById(id);

        if(rackAsset==null){ throw new EntityNotFoundException("Rack with id "+ id +" not found"); }

        return rackAssetMapper.toResource(rackAsset);
    }

    public List<RackDTO> getAllRackAssets(){
        return rackRepository.getAllRacks();
    }


    public RackAssetDTO deleteRackAsset(UUID id){
        rackAssetRepository.deleteById(id);
        return rackAssetMapper.toResource(rackAssetRepository.findById(id));
    }
}
 