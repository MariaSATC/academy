package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RackMapper {
    //@Mapping(target = "surname", source = "lastname")
    RackDTO toResource(Rack rack);
    Rack toEntity(RackDTO rackDTO);
}

