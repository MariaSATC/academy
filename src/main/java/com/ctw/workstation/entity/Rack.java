package com.ctw.workstation.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_RACK")


public class Rack {
    //public static final String GET_ALL = "Rack.getAll";

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "SERIAL_NUMBER", length = 20, nullable = false)
    public String serialNumber;

    @Column(name = "ASSEMBLED_AT")
    public LocalDateTime assembledAt;

    @Column(name = "CREATED_AT")
    public LocalDateTime createddAt;

    @Column(name = "MODIFIED_AT")
    public LocalDateTime modifiedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public Status status;

    @Column(name = "TEAM_ID", nullable = false)
    public UUID teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false, nullable = false)
    public Team team;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<RackAsset> rackAssets;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Rack() {}
    public Rack(UUID id, String serialNumber, Status status, long teamId) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.status = status;

    }

    public UUID getId() {
        return id;
    }

    public Rack setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Rack setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Status getStatus() {
        return status;
    }



//    public void setId(UUID id) {
//        this.id = id;
//    }

    public LocalDateTime getAssembledAt() {
        return assembledAt;
    }

    public void setAssembledAt(LocalDateTime assembledAt) {
        this.assembledAt = assembledAt;
    }

    public void setStatus(Status status) {
        this.status = status;
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
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", status='" + status + '\'' +

                '}';
    }
}
