package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.RackAssetDTO;
import com.ctw.workstation.entity.RackAsset;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RackAssetMapper {
    //@Mapping(target = "surname", source = "lastname")
    RackAssetDTO toResource(RackAsset rackAsset);
    RackAsset toEntity(RackAssetDTO rackAssetDTO);
}