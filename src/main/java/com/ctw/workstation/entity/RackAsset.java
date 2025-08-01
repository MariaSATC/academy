package com.ctw.workstation.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "T_RACKASSET")


public class RackAsset{
    //public static final String GET_ALL = "RackAsset.getAll";

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    @Column(name = "ASSET_TAG", length = 20, nullable = false)
    private String asset_tag;

    @Column(name = "RACK_ID", nullable = false)
    private UUID rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    public RackAsset(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsset_tag() {
        return asset_tag;
    }

    public void setAsset_tag(String asset_tag) {
        this.asset_tag = asset_tag;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }
}
