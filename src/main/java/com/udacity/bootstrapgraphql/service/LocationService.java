package com.udacity.bootstrapgraphql.service;

import com.udacity.bootstrapgraphql.entity.Location;

import java.util.List;

/**
 * Created by janaksoni on 5/14/21.
 */
public interface LocationService {
    List<Location> retrieveLocations();
}
