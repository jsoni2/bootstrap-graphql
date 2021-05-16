package com.udacity.bootstrapgraphql.repository;

import com.udacity.bootstrapgraphql.entity.Location;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by janaksoni on 5/14/21.
 */
public interface LocationRepository extends CrudRepository<Location, Long> {
}
