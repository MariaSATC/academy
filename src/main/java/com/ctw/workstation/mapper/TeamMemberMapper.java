package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.TeamMember;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TeamMemberMapper {
    //@Mapping(target = "surname", source = "lastname")
    TeamMemberDTO toResource(TeamMember teamMember);
    TeamMember toEntity(TeamMemberDTO teamMemberDTO);
}