package com.udacity.bootstrapgraphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by janaksoni on 5/16/21.
 */
public class BreedNotFoundException extends RuntimeException implements GraphQLError {

    private final Map<String, Object> extensions = new HashMap<>();

    public BreedNotFoundException(String message, String invalidBreedId) {
        super(message);
        extensions.put("invalidBreedId", invalidBreedId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
