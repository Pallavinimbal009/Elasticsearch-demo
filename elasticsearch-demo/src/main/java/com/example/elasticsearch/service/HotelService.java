package com.example.elasticsearch.service;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import com.example.elasticsearch.entity.Hotel;
import com.example.elasticsearch.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    // Save a hotel
    public Hotel saveHotel(Hotel hotel) {
        try {
            return hotelRepository.save(hotel);
        } catch (ElasticsearchException e) {
            // Log the error and rethrow or handle appropriately
            System.err.println("Error saving hotel to Elasticsearch: " + e.getMessage());
            throw new RuntimeException("Failed to save hotel, please try again later.");
        }
    }

    // Search hotels by city
    public List<Hotel> findHotelsByCity(String city) {
        try {
            return hotelRepository.findByCity(city);
        } catch (ElasticsearchException e) {
            System.err.println("Error fetching hotels by city from Elasticsearch: " + e.getMessage());
            throw new RuntimeException("Failed to fetch hotels by city, please try again later.");
        }
    }

    // Get all hotels
    public Iterable<Hotel> findAllHotels() {
        try {
            return hotelRepository.findAll();
        } catch (ElasticsearchException e) {
            System.err.println("Error fetching all hotels from Elasticsearch: " + e.getMessage());
            throw new RuntimeException("Failed to fetch all hotels, please try again later.");
        }
    }

    // Update hotel by id
    public Hotel updateHotel(Long id, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Hotel not found with id: " + id));
        existingHotel.setHotelName(hotel.getHotelName());
        existingHotel.setCity(hotel.getCity());
        existingHotel.setPricePerNight(hotel.getPricePerNight());

        return hotelRepository.save(existingHotel);
    }

    //Delete Hotel by id
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
