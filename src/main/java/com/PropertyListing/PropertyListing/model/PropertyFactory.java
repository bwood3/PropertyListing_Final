package com.PropertyListing.PropertyListing.model;

public class PropertyFactory {
    public static Property createProperty(String location, double price, double sqrFootage, int bedrooms, int bathrooms) {
        return new Property(location, price, sqrFootage, bedrooms, bathrooms);
    }
}
