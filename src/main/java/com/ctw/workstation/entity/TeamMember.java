package com.ctw.workstation.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_TEAMMEMBER")


public class TeamMember{
    //public static final String GET_ALL = "TeamMember.getAll";

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    @Column(name = "CTW_ID", length = 20, nullable = false)
    private String ctw_id;

    @Column(name = "CREATED_AT",  nullable = false)
    private LocalDateTime created_at;

    @Column(name = "MODIFIED_AT")
    private LocalDateTime modified_at;

    @Column(name = "TEAM_ID", nullable = false)
    private UUID teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false)
    private Team team;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public TeamMember() {}

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

    public String getCtw_id() {
        return ctw_id;
    }

    public void setCtw_id(String ctw_id) {
        this.ctw_id = ctw_id;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}