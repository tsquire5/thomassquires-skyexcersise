package com.squiressoftware.skyexample;

import com.squiressoftware.skyexample.exceptions.TechnicalFailureException;
import com.squiressoftware.skyexample.exceptions.TitleNotFoundException;

public class ParentalControlServiceImpl implements ParentalControlService {

    final private MovieService movieService;

    public ParentalControlServiceImpl(MovieService movieService) throws TechnicalFailureException {
        if (movieService == null) {
            throw new TechnicalFailureException("Null movie service given to ParentalControlServiceImpl");
        }
        this.movieService = movieService;
    }

    public boolean isMovieAllowedByCustomerParentalControlLevel(String movieId, String customerParentalControlLevelPreference) throws TechnicalFailureException, TitleNotFoundException {
        final String movieControlLevel = getParentalControlLevel(movieId);
        return getIntRepresentationOfParentalControlLevel(movieControlLevel) <= getIntRepresentationOfParentalControlLevel(customerParentalControlLevelPreference);
    }

    //Currently case sensitive.
    private int getIntRepresentationOfParentalControlLevel(String customerParentalControlLevelPreference) throws TechnicalFailureException {
        switch (customerParentalControlLevelPreference) {
            case "U":
                return 0;
            case "PG":
                return 1;
            case "12":
                return 2;
            case "15":
                return 3;
            case "18":
                return 4;
            default:
                throw new TechnicalFailureException("Unknown parental control level " + customerParentalControlLevelPreference);
        }
    }

    private String getParentalControlLevel(String movieId) throws TechnicalFailureException, TitleNotFoundException {
        try {
            String controlLevel = movieService.getParentalControlLevel(movieId);
            if (controlLevel != null) {
                return controlLevel;
            } else {
                throw new TechnicalFailureException("invalid control Level returned from movie service");
            }
        } catch (TechnicalFailureException | TitleNotFoundException ex) {
            //Do some logging here
            throw ex;
        } catch (Exception ex) {
            //MovieService behaving badly, ie runtime exception
            //Do some logging here
            throw new TechnicalFailureException("Internal error with movie service", ex);
        }
    }
}
