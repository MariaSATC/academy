package com.ctw.workstation.repository;

import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.Status;
import com.ctw.workstation.mapper.RackMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@ApplicationScoped
public class RackRepository implements PanacheRepositoryBase<Rack,UUID> {

    @Inject
    RackMapper rackMapper;

    public List<RackDTO> getAllRacks(){
        List<Rack> racks =listAll();

        List<RackDTO> rackDtos =  new ArrayList<>();
        racks.forEach(rack -> {
            RackDTO rackDto = rackMapper.toResource(rack);
            rackDtos.add(rackDto);
        });

        return rackDtos;
    }

    public Optional<Rack> getRackById(UUID id){
        return Optional.ofNullable(findById(id));
    }

    public Optional<Rack> getRackBySerialNumber(String serialNumber){
        return find("serialNumber",serialNumber).firstResultOptional();
    }

    @Transactional
    public void createRack(Rack rack){
        persist(rack);
    }

    @Transactional
    public boolean deleteById(UUID id){
        return delete("id",id) > 0;
    }

    @Transactional
    public void updateRackStatus(UUID id, Status status) {
        update("status = :status where id = :id",
                Parameters.with("status", status).and("id", id));
    }


    public Rack getOrThrow(UUID id){
        return getRackById(id).orElseThrow(()->new EntityNotFoundException("Rack with id " + id + " not found"));
    }
}
 