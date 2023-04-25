package com.PropertyListing.PropertyListing.controller;


import com.PropertyListing.PropertyListing.model.Property;
import com.PropertyListing.PropertyListing.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping
    @CrossOrigin(origins = {"https://propertysearchfinal-production.up.railway.app"})
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @PostMapping
    @CrossOrigin(origins = {"https://propertysearchfinal-production.up.railway.app"})
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.createProperty(property));
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = {"https://propertysearchfinal-production.up.railway.app"})
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property updatedProperty) {
        return ResponseEntity.ok(propertyService.updateProperty(id, updatedProperty));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = {"https://propertysearchfinal-production.up.railway.app"})
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
