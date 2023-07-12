package com.lcwd.hotel.controllers;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.createHotel((hotel));
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    //get single hotel
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId) throws ResourceNotFoundException {
        Hotel hotel = hotelService.get(hotelId);
//        return ResponseEntity.status(HttpStatus.OK).body();
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){

        List<Hotel> allHotels = hotelService.getAll();
//        return ResponseEntity.ok();
        if (!allHotels.isEmpty()) {
            return ResponseEntity.ok(allHotels);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    //update
    @PutMapping("/{Id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String Id, @RequestBody Hotel updatedHotelData) throws ResourceNotFoundException{
        Hotel updatedHotel = hotelService.updateHotelById(Id,updatedHotelData);
        return ResponseEntity.ok(updatedHotel);
    }

    //delete
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteHotel(@PathVariable String Id) throws ResourceNotFoundException{
        hotelService.deleteHotelById(Id);
        String message = "Hotel with Id "+Id+" has been successfully deleted.";
        return ResponseEntity.ok(message);
    }

}
