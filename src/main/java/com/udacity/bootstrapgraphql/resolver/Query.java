package com.udacity.bootstrapgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.bootstrapgraphql.entity.Location;
import com.udacity.bootstrapgraphql.repository.LocationRepository;
import org.springframework.stereotype.Component;

/**
 * Created by janaksoni on 5/16/21.
 */

@Component
public class Query implements GraphQLQueryResolver {

    private final LocationRepository locationRepository;


    public Query(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}
