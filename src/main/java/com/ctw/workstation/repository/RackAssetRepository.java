package com.ctw.workstation.repository;

import com.ctw.workstation.dto.RackAssetDTO;
import com.ctw.workstation.entity.RackAsset;
import com.ctw.workstation.mapper.RackAssetMapper;
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
public class RackAssetRepository implements PanacheRepositoryBase<RackAsset,UUID> {

    @Inject
    RackAssetMapper rackAssetMapper;

    public List<RackAssetDTO> getAllRacks(){
        List<RackAsset> rackAssets =listAll();

        List<RackAssetDTO> rackAssetDtos =  new ArrayList<>();
        rackAssets.forEach(ra -> {
            RackAssetDTO rackAssetDto = rackAssetMapper.toResource(ra);
            rackAssetDtos.add(rackAssetDto);
        });

        return rackAssetDtos;
    }

    public Optional<RackAsset> getRackAssetById(UUID id){
        return Optional.ofNullable(findById(id));
    }

    public Optional<RackAsset> getRackBySerialNumber(String serialNumber){
        return find("serialNumber",serialNumber).firstResultOptional();
    }

    @Transactional
    public void createRackAsset(RackAsset rackAsset){
        persist(rackAsset);
    }

    @Transactional
    public boolean deleteById(UUID id){
        return delete("id",id) > 0;
    }

    public RackAsset getOrThrow(UUID id){
        return getRackAssetById(id).orElseThrow(()->new EntityNotFoundException("RackAsset with id "+ id +" not found"));
    }
}
 