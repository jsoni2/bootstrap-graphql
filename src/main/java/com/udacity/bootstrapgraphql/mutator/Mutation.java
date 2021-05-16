package com.udacity.bootstrapgraphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.bootstrapgraphql.entity.Location;
import com.udacity.bootstrapgraphql.exception.LocationNotFoundException;
import com.udacity.bootstrapgraphql.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by janaksoni on 5/16/21.
 */

@Component
public class Mutation implements GraphQLMutationResolver {

    private final LocationRepository locationRepository;


    public Mutation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location newLocation(String name, String address) {
        Location location = new Location(name, address);
        locationRepository.save(location);
        return location;
    }

    public boolean deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return true;
    }

    public Location updateLocationName(String newName, Long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);

        if (optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setName(newName);
            locationRepository.save(location);
        } else {
            throw new LocationNotFoundException("Location Not Found", id);
        }
    }
}
