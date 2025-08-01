package com.ctw.workstation.dto;


import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.TeamMember;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class TeamDTO {
    //public static final String GET_ALL = "Team.getAll";

    private UUID id;
    private String name;
    private String product;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String default_location;

    private List<Rack> racks;
    private List<TeamMember> teamMembers;

    public TeamDTO() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    public String getDefault_location() {
        return default_location;
    }

    public void setDefault_location(String default_location) {
        this.default_location = default_location;
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public void setRacks(List<Rack> racks) {
        this.racks = racks;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

}
