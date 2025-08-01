package com.ctw.workstation.dto;

import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.TeamMember;

import java.time.LocalDateTime;
import java.util.UUID;


public class BookingDTO {
    //public static final String GET_ALL = "Booking.getAll";


    private UUID id;
    private String name;
    private LocalDateTime book_from;
    private LocalDateTime book_to;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private UUID teamMemberId;
    private TeamMember teamMember;
    private UUID rackId;
    private Rack rack;

    public BookingDTO() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRackId() {
        return rackId;
    }

    public UUID getTeamMemberId() {
        return teamMemberId;
    }

    public LocalDateTime getBookFrom() {
        return book_from;
    }

    public LocalDateTime getBookTo() {
        return book_to;
    }


    public String getName() {
        return name;
    }

    public void setName(String NAME) {
        this.name = NAME;
    }

    public LocalDateTime getBook_from() {
        return book_from;
    }

    public void setBook_from(LocalDateTime book_from) {
        this.book_from = book_from;
    }

    public LocalDateTime getBook_to() {
        return book_to;
    }

    public void setBook_to(LocalDateTime book_to) {
        this.book_to = book_to;
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

    public void setTeamMemberId(UUID teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
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

