package com.example.elasticsearch.entity;

import jakarta.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "hotels")
public class Hotel {
    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String hotelName;

    @Field(type = FieldType.Text)
    private String city;

    @Field(type = FieldType.Double)
    private double pricePerNight;
}
