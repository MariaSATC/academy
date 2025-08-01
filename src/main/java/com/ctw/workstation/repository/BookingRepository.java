package com.ctw.workstation.repository;

import com.ctw.workstation.dto.BookingDTO;
import com.ctw.workstation.entity.Booking;
import com.ctw.workstation.mapper.BookingMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@ApplicationScoped
public class BookingRepository implements PanacheRepositoryBase<Booking,UUID> {

    @Inject
    BookingMapper bookingMapper;

    public List<BookingDTO> getAllBookings(){
        List<Booking> bookings =listAll();

        List<BookingDTO> bookingDtos =  new ArrayList<>();
        bookings.forEach(b -> {
            BookingDTO bookingDto = bookingMapper.toResource(b);
            bookingDtos.add(bookingDto);
        });

        return bookingDtos;
    }

    public Optional<Booking> getBookingById(UUID id){
        return Optional.ofNullable(findById(id));
    }

    public Optional<Booking> getBookingByName(String name){
        return find("name",name).firstResultOptional();
    }

    @Transactional
    public void createBooking(Booking booking){
        persist(booking);
    }

    @Transactional
    public boolean deleteById(UUID id){
        return delete("id",id) > 0;
    }

    public Booking getOrThrow(UUID id){
        return getBookingById(id).orElseThrow(()->new EntityNotFoundException("Rack with id "+ id +" not found"));
    }
}
 