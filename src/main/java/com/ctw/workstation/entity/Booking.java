package com.ctw.workstation.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_BOOKING")


public class Booking {
    //public static final String GET_ALL = "Booking.getAll";

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "NAME", length = 20, nullable = false)
    public String name;

    @Column(name = "BOOK_FROM", nullable = false)
    public LocalDateTime book_from;

    @Column(name = "BOOK_TO", nullable = false)
    public LocalDateTime book_to;

    @Column(name = "CREATED_AT", nullable = false)
    public LocalDateTime created_at;

    @Column(name = "MODIFIED_AT")
    public LocalDateTime modified_at;

    @Column(name = "requester_id", nullable = false)
    public UUID teamMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", updatable = false, insertable = false, nullable = false)
    public TeamMember teamMember;

    @Column(name = "RACK_ID", nullable = false)
    public UUID rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID", updatable = false, insertable = false, nullable = false)
    public Rack rack;

    public Booking() {}
    public Booking(UUID id, UUID rackId, UUID requesterId, LocalDateTime bookFrom, LocalDateTime bookTo) {
        this.id = id;
        this.rackId = rackId;
        this.teamMemberId = requesterId;
        this.book_from = bookFrom;
        this.book_to = bookTo;
    }

    public UUID getId() {
        return id;
    }

    public Booking setId(UUID id) {
        this.id = id;
        return this;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
