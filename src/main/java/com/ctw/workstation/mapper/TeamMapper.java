package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TeamMapper {
    //@Mapping(target = "surname", source = "lastname")
    TeamDTO toResource(Team team);
    Team toEntity(TeamDTO teamDTO);
}