package com.squiressoftware.skyexample;

import com.squiressoftware.skyexample.exceptions.TechnicalFailureException;
import com.squiressoftware.skyexample.exceptions.TitleNotFoundException;

public interface MovieService {
    String getParentalControlLevel(String movieId)
            throws TitleNotFoundException,
            TechnicalFailureException;
}