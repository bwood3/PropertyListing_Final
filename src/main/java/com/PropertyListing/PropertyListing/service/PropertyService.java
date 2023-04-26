package com.PropertyListing.PropertyListing.service;


import com.PropertyListing.PropertyListing.model.Property;
import com.PropertyListing.PropertyListing.repository.PropertyRepository;
import jakarta.el.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property updateProperty(Long id, Property updatedProperty) {
        return propertyRepository.findById(id)
                .map(property -> {
                    property.setLocation(updatedProperty.getLocation());
                    property.setPrice(updatedProperty.getPrice());
                    property.setSqrFootage(updatedProperty.getSqrFootage());
                    property.setBedrooms(updatedProperty.getBedrooms());
                    property.setBathrooms(updatedProperty.getBathrooms());
                    return propertyRepository.save(property);
                })
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }
    public List<Property> findAllById(List<Long> ids) {
        return propertyRepository.findAllById(ids);
    }
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property not found with id " + id));
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
