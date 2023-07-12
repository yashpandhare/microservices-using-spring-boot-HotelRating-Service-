package com.lcwd.hotel.services;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;

import java.util.List;

public interface HotelService {
    //create
    Hotel createHotel(Hotel hotel);

    //getALL
    List<Hotel> getAll();

    //get Single hotel
    Hotel get(String id) throws ResourceNotFoundException;

    //update hotel by hotelId
    Hotel updateHotelById(String hotelId, Hotel updatedHotel) throws ResourceNotFoundException;

    //delete hotel by hotelId
    void deleteHotelById(String Id) throws ResourceNotFoundException;
}
