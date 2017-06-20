Parental Control Service

Scenario

Sky is developing a next generation Video on Demand platform. You are

part of a software engineering team, developing services for the platform

and working on the story below.

Prevent access to movies based on parental control level:

As a customer I don’t want my account to be able to access movies that

have a higher parental control level than my current preference setting.

Your team has partnered with the Movie Meta Data team that provides a

service that can return parental control information for a given movie.

Instructions

You are required to provide an implementation of a ParentalControlService.

You may use Java version 6 or above.

The service should accept as input the customer’s parental control level

preference and a movie id. If the customer is able to watch the movie the

ParentalControlService should indicate this to the calling client.

Please implement the ParentalControlService API.

The recommended time to complete this exercise should be between forty-
five minutes and one-hour

SKY TECHNOLOGY unattended programming test: Parental

Control Service

January 19, 2016

2

Parental Control Levels

U, PG, 12, 15, 18

Movie Service

The Movie Meta Data team is currently developing the MovieService

getParentalControlLevel call that accepts the movie id as an input and

returns the parental control level for that movie as a string.

This is a simple diagram of the interaction between the services:

MovieService Interface

public interface MovieService {

String getParentalControlLevel(String movieId)

throws TitleNotFoundException,

TechnicalFailureException;

}

SKY TECHNOLOGY unattended programming test: Parental

Control Service

January 19, 2016

3

Acceptance Criteria

The following table describes the expected ParentalControlService result

based on a given MovieService getParentalControlLevel response.

MovieService

getParentalControlLevel

response

Description ParentalControlService result

Parental Control level A string

e.g. “PG”

If the parental control level of the

movie is equal to or less than the

customer’s preference indicate to

the caller that the customer can

watch the movie

TitleNotFound exception The movie

service could not

find the given

movie

Indicate the error to the calling

client.

Technical failure exception System error Indicate that the customer cannot

watch this movie

We need to ensure that we always failsafe.

What we look at

We are interested in code readability and structure and your use of best

practice.

Please supply us with your source code in a single archive. The project

should be self-contained.

The name of the root folder in the archive should contain your full name.
