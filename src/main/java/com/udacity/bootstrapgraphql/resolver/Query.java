package com.udacity.bootstrapgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.bootstrapgraphql.entity.Dog;
import com.udacity.bootstrapgraphql.entity.Location;
import com.udacity.bootstrapgraphql.exception.DogNotFoundException;
import com.udacity.bootstrapgraphql.repository.DogRepository;
import com.udacity.bootstrapgraphql.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by janaksoni on 5/16/21.
 */

@Component
public class Query implements GraphQLQueryResolver {

    private final DogRepository dogRepository;


    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
