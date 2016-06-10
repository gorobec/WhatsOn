package controller;

import model.Cinema;
import model.Movie;
import model.Person;
import model.Show;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by gorobec on 12.02.16.
 */
public class Controller implements IUserController {
    private static Map<Integer, Cinema> cinemas;
    private static Map<Integer, Movie> movies;
    private static Map<Integer, Person> persons;
    private static Map<Integer, String> genres;
    private static Map<Integer, String> halls;
    private static Map<Integer, String> professions;
    private static Map<Integer, String> countries;
    private static Map<Integer, String> cities;
    private static Map<Integer, String> studios;
    private static Map<Integer, List<Show>> showsByCinema;
    private static Map<Integer, List<Show>> showsByMovie;
    private static Map<Integer, Integer> cinemasByCities;

    public static Map<Integer, List<Show>> getShowsByCinema() {
        return showsByCinema;
    }

    public static void setShowsByCinema(Map<Integer, List<Show>> showsByCinema) {
        Controller.showsByCinema = showsByCinema;
    }

    public static Map<Integer, List<Show>> getShowsByMovie() {
        return showsByMovie;
    }

    public static void setShowsByMovie(Map<Integer, List<Show>> showsByMovie) {
        Controller.showsByMovie = showsByMovie;
    }

    public static Map<Integer, Cinema> getCinemas() {
        return cinemas;
    }

    public static void setCinemas(Map<Integer, Cinema> cinemas) {
        Controller.cinemas = cinemas;
    }

    public static Map<Integer, Movie> getMovies() {
        return movies;
    }

    public static void setMovies(Map<Integer, Movie> movies) {
        Controller.movies = movies;
    }

    public static Map<Integer, Person> getPersons() {
        return persons;
    }

    public static void setPersons(Map<Integer, Person> persons) {
        Controller.persons = persons;
    }

    public static Map<Integer, String> getGenres() {
        return genres;
    }

    public static void setGenres(Map<Integer, String> genres) {
        Controller.genres = genres;
    }

    public static Map<Integer, String> getHalls() {
        return halls;
    }

    public static void setHalls(Map<Integer, String> halls) {
        Controller.halls = halls;
    }

    public static Map<Integer, String> getProfessions() {
        return professions;
    }

    public static void setProfessions(Map<Integer, String> professions) {
        Controller.professions = professions;
    }

    public static Map<Integer, String> getCountries() {
        return countries;
    }

    public static void setCountries(Map<Integer, String> countries) {
        Controller.countries = countries;
    }

    public static Map<Integer, String> getCities() {
        return cities;
    }

    public static void setCities(Map<Integer, String> cities) {
        Controller.cities = cities;
    }

    public static Map<Integer, String> getStudios() {
        return studios;
    }

    public static void setStudios(Map<Integer, String> studios) {
        Controller.studios = studios;
    }

    @Override
    public TreeSet<Movie> viewAllMovies() {

        TreeSet<Movie> movies = new TreeSet<>();
        Iterator<Map.Entry<Integer, Movie>> iterator = getMovies().entrySet().iterator();
        while (iterator.hasNext()){
            movies.add(iterator.next().getValue());
        }

        return movies;
    }

    @Override
    public TreeSet<Cinema> viewAllCinemas(Integer cityId) {
//        int cityId = findKey(Controller.getCities(), city);
        TreeSet<Cinema> cinemas = new TreeSet<>();
        Iterator<Map.Entry<Integer, Cinema>> iterator = getCinemas().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Cinema> entry = iterator.next();
            if(entry.getValue().getCityId() == cityId) {
                cinemas.add(entry.getValue());
            }
        }

        return cinemas;
    }

    public int findKey(String city) {
        Iterator<Map.Entry<Integer, String>> iterator = cities.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            if(entry.getValue().equals(city))
                return entry.getKey();
        }
        return -1;
    }

    @Override
    public TreeSet<Movie> showCinemasMovies(Cinema cinema) {
//        todo Comparator LocalDate vs. titles



        return null;
    }

    @Override
    public Set<Movie> findMovieByName(String name) {
//        todo regEx names
        Set<Movie> movie = new TreeSet<>();
        Iterator<Map.Entry<Integer, Movie>> iterator = movies.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Movie> entry = iterator.next();
            // todo regEx
            if(entry.getValue().getTitle().toLowerCase().contains(name.toLowerCase()) || entry.getValue().getOriginalTitle().toLowerCase().contains(name.toLowerCase())){
                movie.add(entry.getValue());
            }
        }
        return movie;
    }

    @Override
    public Set<Movie> findMoviesByGenre(Integer... genreId) {
        Set<Movie> moviesByGenre = new TreeSet<>();
        Iterator<Map.Entry<Integer, Movie>> iterator = movies.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Movie> entry = iterator.next();
            for (int i = 0; i < genreId.length; i++) {
                if(entry.getValue().getGenresId().contains(genreId[i])){
                 moviesByGenre.add(entry.getValue());
                    break;
                }
            }
        }
        return moviesByGenre;
    }

    public Set<Movie> showMoviesOnScreen(int cityId) {
//todo dates
        Set<Movie> movies = new TreeSet<>();
        Iterator<Map.Entry<Integer, List<Show>>> iterator = showsByMovie.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Show>> entry = iterator.next();
            List<Show> movieShows = entry.getValue();
            for (Show movieShow : movieShows) {
                if((movieShow.getDateBegin().isBefore(LocalDate.now()) || movieShow.getDateBegin().isEqual(LocalDate.now())) &&
                        (movieShow.getDateEnd().isAfter(LocalDate.now()) || movieShow.getDateEnd().isEqual(LocalDate.now())) &&
                        cinemas.get(movieShow.getCinemaID()).getCityId() == cityId){
                    movies.add(getMovies().get(entry.getKey()));
                    break;
                }
            }
        }

        return movies;
    }

    @Override
    public TreeSet<Movie> findMoviesByTime(LocalDate from, LocalDate till) {
        return null;
    }

    public TreeSet<Movie> findMoviesByTime(LocalDate till) {
        return findMoviesByTime(LocalDate.now(), till);
    }
}
