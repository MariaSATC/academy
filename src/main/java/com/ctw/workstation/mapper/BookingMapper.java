package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.BookingDTO;
import com.ctw.workstation.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface BookingMapper {
    //@Mapping(target = "surname", source = "lastname")
    BookingDTO toResource(Booking booking);
    Booking toEntity(BookingDTO bookingDto);
}