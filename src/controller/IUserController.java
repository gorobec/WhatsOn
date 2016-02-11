package controller;

import model.Cinema;
import model.Movie;

import java.time.LocalDate;
import java.util.Date;
import java.util.TreeSet;

/**
 * Created by gavri on 27.01.2016.
 */
public interface IUserController {


    TreeSet<Movie> viewAllMovies();

    TreeSet<Cinema> viewAllCinemas();

    TreeSet<Movie> viewMoviesByCinema(Cinema cinema);
//
    TreeSet<Movie> findMovieByName(String name);
//todo enum
    TreeSet<Movie>findMoviesByGenre(String... genre);

    TreeSet<Movie> findMoviesByTime(LocalDate from, LocalDate till);
//todo return movies by seance
//     viewMoviesSeances(Movie movie);
}
