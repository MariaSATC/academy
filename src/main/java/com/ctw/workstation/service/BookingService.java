package com.ctw.workstation.service;

import com.ctw.workstation.dto.BookingDTO;
import com.ctw.workstation.entity.Booking;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.TeamMember;
import com.ctw.workstation.mapper.BookingMapper;
import com.ctw.workstation.repository.BookingRepository;
import com.ctw.workstation.repository.RackRepository;
import com.ctw.workstation.repository.TeamMemberRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingRepository bookingRepository;

    @Inject
    TeamMemberRepository teamMemberRepository;

    @Inject
    RackRepository rackRepository;

    @Inject
    BookingMapper bookingMapper;

    @Inject
    Logger log;

    @Transactional
    public BookingDTO createBooking(BookingDTO bookingDto){
        log.infov("Create booking {0}", bookingDto);

        Rack rack = rackRepository.findById(bookingDto.getRackId());

        TeamMember teamMember = teamMemberRepository.findById( bookingDto.getTeamMemberId());

        if(rack == null || teamMember == null){ throw new EntityNotFoundException(); }

        Booking booking = bookingMapper.toEntity(bookingDto);

        bookingRepository.persist(booking);

        return bookingMapper.toResource(booking);
    }


    public BookingDTO getBookingById(UUID id){
        Booking booking = bookingRepository.findById(id);

        if(booking==null){ throw new EntityNotFoundException("Booking with id "+ id +" not found"); }

        return bookingMapper.toResource(booking);
    }

    public List<BookingDTO> getAllBookings(){
        return bookingRepository.getAllBookings();
    }


    public BookingDTO deleteBooking(UUID id){
        bookingRepository.deleteById(id);
        return  bookingMapper.toResource(bookingRepository.findById(id));
    }
}
 