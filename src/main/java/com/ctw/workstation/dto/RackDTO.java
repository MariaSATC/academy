package com.ctw.workstation.dto;

import com.ctw.workstation.entity.Booking;
import com.ctw.workstation.entity.RackAsset;
import com.ctw.workstation.entity.Status;
import com.ctw.workstation.entity.Team;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RackDTO {
    //public static final String GET_ALL = "Rack.getAll";
    private UUID id;
    private String serialNumber;
    private LocalDateTime assembledAt;
    private LocalDateTime createddAt;
    private LocalDateTime modifiedAt;
    private Status status;
    private UUID teamId;
    private Team team;

    private List<RackAsset> rackAssets;
    private List<Booking> bookings;

    public RackDTO() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDateTime getCreateddAt() {
        return createddAt;
    }

    public void setCreateddAt(LocalDateTime createddAt) {
        this.createddAt = createddAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getAssembledAt() {
        return assembledAt;
    }

    public void setAssembledAt(LocalDateTime assembledAt) {
        this.assembledAt = assembledAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<RackAsset> getRackAssets() {
        return rackAssets;
    }

    public void setRackAssets(List<RackAsset> rackAssets) {
        this.rackAssets = rackAssets;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Rack{" +
                ", serialNumber='" + serialNumber + '\'' +
                ", status='" + status + '\'' +

                '}';
    }
}
