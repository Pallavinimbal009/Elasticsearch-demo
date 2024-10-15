package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Hotel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface HotelRepository   extends ElasticsearchRepository<Hotel, Long>{
    List<Hotel> findByCity(String city);
}
