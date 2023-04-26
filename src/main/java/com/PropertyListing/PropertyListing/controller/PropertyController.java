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
    @CrossOrigin(origins = {"https://propertylistingfinal-production.up.railway.app", "http://localhost:3000","https://realestateapp.vercel.app"})
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = {"https://propertylistingfinal-production.up.railway.app", "http://localhost:3000","https://realestateapp.vercel.app"})
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping("/by-ids")
    @CrossOrigin(origins = {"http://localhost:3000","https://realestateapp.vercel.app"})
    public List<Property> getPropertiesByIds(@RequestParam("ids") List<Long> ids) {
        return propertyService.findAllById(ids);
    }

    @PostMapping
    @CrossOrigin(origins = {"https://propertylistingfinal-production.up.railway.app", "http://localhost:3000","https://realestateapp.vercel.app"})
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.createProperty(property));
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = {"https://propertylistingfinal-production.up.railway.app", "http://localhost:3000","https://realestateapp.vercel.app"})
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property updatedProperty) {
        return ResponseEntity.ok(propertyService.updateProperty(id, updatedProperty));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = {"https://propertylistingfinal-production.up.railway.app", "http://localhost:3000","https://realestateapp.vercel.app"})
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }


}
