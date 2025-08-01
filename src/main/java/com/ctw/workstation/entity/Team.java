package com.ctw.workstation.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_TEAM")
public class Team {
    //public static final String GET_ALL = "Team.getAll";

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "product")
    private String product;

    @Column(name = "CREATED_AT")
    public LocalDateTime created_at;

    @Column(name = "MODIFIED_AT")
    public LocalDateTime modified_at;

    @Column(name = "default_location")
    private String default_location;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<Rack> racks;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<TeamMember> teamMembers;

    public Team() {}
    public Team(UUID id, String name, String product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public Team setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

//    public void setId(UUID id) {
//        this.id = id;
//    }

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

}
