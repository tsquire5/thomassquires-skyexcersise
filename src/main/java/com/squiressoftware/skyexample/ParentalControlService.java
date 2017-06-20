package com.squiressoftware.skyexample;

import com.squiressoftware.skyexample.exceptions.TechnicalFailureException;
import com.squiressoftware.skyexample.exceptions.TitleNotFoundException;

public interface ParentalControlService {
    boolean isMovieAllowedByCustomerParentalControlLevel(String movieId, String customerParentalControlLevelPreference) throws TechnicalFailureException, TitleNotFoundException;
}
