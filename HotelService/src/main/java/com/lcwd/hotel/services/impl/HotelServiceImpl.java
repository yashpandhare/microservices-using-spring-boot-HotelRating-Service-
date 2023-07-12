package com.lcwd.hotel.services.impl;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) throws ResourceNotFoundException{
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
    }

    @Override
    public Hotel updateHotelById(String hotelId, Hotel updatedHotel) throws ResourceNotFoundException{
        Hotel existingHotel = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel with ID "+hotelId+" not found!!"));
        existingHotel.setName(updatedHotel.getName());
        existingHotel.setLocation(updatedHotel.getLocation());
        existingHotel.setAbout(updatedHotel.getAbout());

        return hotelRepository.save(existingHotel);
    }

    @Override
    public void deleteHotelById(String Id) throws ResourceNotFoundException{
        Hotel existingHotel = hotelRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Hotel with ID "+Id+" not found!!"));
        hotelRepository.delete(existingHotel);
        System.out.printf("Hotel with ID "+Id+" deleted");
    }
}
