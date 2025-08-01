package com.ctw.workstation.dto;

import com.ctw.workstation.entity.Booking;
import com.ctw.workstation.entity.Team;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class TeamMemberDTO {
    //public static final String GET_ALL = "TeamMember.getAll";
    private UUID id;
    private String name;
    private String ctw_id;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private UUID teamId;
    private Team team;


    private List<Booking> bookings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamMemberDTO() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
       // System.out.println("TEAMID: " + teamId);
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
