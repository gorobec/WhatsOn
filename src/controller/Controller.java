package controller;

import model.Cinema;
import model.Movie;
import model.Person;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by gorobec on 12.02.16.
 */
public class Controller implements IUserController {
    private static Map<Integer, Cinema> cinemas = new HashMap<>();
    private static Map<Integer, Movie> movies = new HashMap<>();
    private static Map<Integer, Person> persons = new HashMap<>();
    private static Map<Integer, String> genres = new HashMap<>(52);
    private static Map<Integer, String> halls = new HashMap<>(52);
    private static Map<Integer, String> professions = new HashMap<>(52);
    private static Map<Integer, String> countries = new HashMap<>(52);
    private static Map<Integer, String> cities = new HashMap<>(52);
    private static Map<Integer, String> studios = new HashMap<>(52);

    @Override
    public TreeSet<Movie> viewAllMovies() {
        return null;
    }

    @Override
    public TreeSet<Cinema> viewAllCinemas() {
        return null;
    }

    @Override
    public TreeSet<Movie> viewMoviesByCinema(Cinema cinema) {
        return null;
    }

    @Override
    public TreeSet<Movie> findMovieByName(String name) {
        return null;
    }

    @Override
    public TreeSet<Movie> findMoviesByGenre(String... genre) {
        return null;
    }

    @Override
    public TreeSet<Movie> findMoviesByTime(LocalDate from, LocalDate till) {
        return null;
    }
}
