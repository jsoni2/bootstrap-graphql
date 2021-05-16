package com.udacity.bootstrapgraphql.controller;

import com.udacity.bootstrapgraphql.entity.Location;
import com.udacity.bootstrapgraphql.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by janaksoni on 5/14/21.
 */

@RestController
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> locationList = locationService.retrieveLocations();

        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }
}
