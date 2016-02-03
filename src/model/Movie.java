package model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Comparable<Movie> {
    private int id;
    private String title;
    private String originalTitle;
    private int year;
    private List<String> genres;
    private String budget;
    private List<Person> directors;
    private List<Person> actors;
    private List<String> countries;
    private int ageLimit;
    private int duration;
    private LocalDate wordPremiere;
    private LocalDate uaPremiere;
    private String description;
    private String studio;
    private String posterURL;

//todo compareTo
    @Override
    public int compareTo(Movie o) {
        return 0;
    }
}
