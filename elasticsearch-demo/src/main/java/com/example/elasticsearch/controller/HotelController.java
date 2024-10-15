package com.example.elasticsearch.controller;

import com.example.elasticsearch.entity.Hotel;
import com.example.elasticsearch.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")

public class HotelController {
    @Autowired
    private HotelService hotelService;

    // Create a new hotel
    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    // Get hotels by city
    @GetMapping("/city/{city}")
    public List<Hotel> getHotelsByCity(@PathVariable String city) {
        return hotelService.findHotelsByCity(city);
    }

    // Get all hotels
    @GetMapping
    public Iterable<Hotel> getAllHotels() {
        return hotelService.findAllHotels();
    }

    // Update hotel by id
    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }

    // Delete hotel by id
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}
