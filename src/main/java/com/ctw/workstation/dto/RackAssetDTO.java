package com.ctw.workstation.dto;

import com.ctw.workstation.entity.Rack;

import java.util.UUID;


public class RackAssetDTO {
    //public static final String GET_ALL = "RackAsset.getAll";

    private UUID id;
    private String name;
    private String asset_tag;
    private UUID rackId;
    private Rack rack;

    public RackAssetDTO(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String NAME) {
        this.name = NAME;
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
