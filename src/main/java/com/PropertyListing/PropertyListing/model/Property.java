package com.PropertyListing.PropertyListing.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private double price;
    private double sqrFootage;
    private int bedrooms;
    private int bathrooms;


    //constructor using factory
    public Property(String location, double price, double sqrFootage, int bedrooms, int bathrooms) {
        //property factory - centralize the object creation logic in the PropertyFactory class
        // to manage for future changes.
        Property property = PropertyFactory.createProperty(location, price, sqrFootage, bedrooms, bathrooms);
    }

    //default Constructor
    public Property() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSqrFootage() {
        return sqrFootage;
    }

    public void setSqrFootage(double sqrFootage) {
        this.sqrFootage = sqrFootage;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }
}