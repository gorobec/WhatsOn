package controller;

import model.Cinema;
import model.Movie;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by gavri on 27.01.2016.
 */
public interface IUserController {


    TreeSet<Movie> viewAllMovies();

    TreeSet<Cinema> viewAllCinemas(Integer cityId);

    TreeSet<Movie> showCinemasMovies(Cinema cinema);
//
    Set<Movie> findMovieByName(String name);

    Set<Movie>findMoviesByGenre(Integer... genreId);

    TreeSet<Movie> findMoviesByTime(LocalDate from, LocalDate till);
//todo return movies by seance
//     viewMoviesSeances(Movie movie);
}
