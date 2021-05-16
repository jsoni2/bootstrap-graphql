package com.udacity.bootstrapgraphql.repository;

import com.udacity.bootstrapgraphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by janaksoni on 5/14/21.
 */
public interface DogRepository extends CrudRepository<Dog, Long> {

}
