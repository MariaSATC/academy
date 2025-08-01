package com.ctw.workstation.resource;

import com.ctw.workstation.dto.BookingDTO;
import com.ctw.workstation.service.BookingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/bookings")
public class BookingResource {

    @Inject
    Logger log;

    @Inject
    BookingService bookingService;

    @GET
    public List<BookingDTO> getAllBookings(){
        return bookingService.getAllBookings();
    }


    @GET
    @Path("/{id}")
    public BookingDTO getBookingById(@PathParam("id") UUID id){
        return bookingService.getBookingById(id);
    }

    @POST
    public Response createBooking(BookingDTO bookingDto){
        log.debug("Creating new booking with id " + bookingDto.getId());
        return Response.status(Response.Status.CREATED).entity(bookingService.createBooking(bookingDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBooking(@PathParam("id") UUID id){
        return Response.status(Response.Status.CREATED).entity(bookingService.deleteBooking(id)).build();
    }
}
 