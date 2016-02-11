package model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Comparable<Movie> {
    private final int id;
    private final String title;
    private final String originalTitle;
    private final int year;
    private final List<String> genres;
    private final String budget;
    private final List<Person> directors;
    private final List<Person> actors;
    private final List<String> countries;
    private final int ageLimit;
    private final int duration;
    private final LocalDate wordPremiere;
    private final LocalDate uaPremiere;
    private final String description;
    private final String studio;
    private final String posterURL;

/*
* Builder pattern for many constructor parameters
* */
    public static class Builder {
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


        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder originalTitle(String originalTitle){
            this.originalTitle = originalTitle;
            return this;
        }
        public Builder title(int year){
            this.year = year;
            return this;
        }
        public Builder title(List<String> genres){
            this.genres = genres;
            return this;
        }
        public Builder budget(String budget){
           this.budget = budget;
            return this;
        }
        public Builder directors(List<Person> directors){
            this.directors = directors;
            return this;
        }
        public Builder actors(List<Person> actors){
            this.actors = actors;
            return this;
        }
        public Builder countries(List<String> countries){
            this.countries = countries;
            return this;
        }
        public Builder ageLimit(int ageLimit){
            this.ageLimit = ageLimit;
            return this;
        }
        public Builder duration(int duration){
            this.duration = duration;
            return this;
        }
        public Builder wordPremiere(LocalDate wordPremiere){
            this.wordPremiere = wordPremiere;
            return this;
        }
        public Builder uaPremiere(LocalDate uaPremiere){
            this.uaPremiere = uaPremiere;
            return this;
        }
        public Builder studio(String studio){
            this.studio = studio;
            return this;
        }
        public Builder posterURL(String posterURL){
            this.posterURL = posterURL;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    private Movie(Builder builder){
        id = builder.id;
        title = builder.title;
        originalTitle = builder.originalTitle;
        year = builder.year;
        genres = builder.genres;
        budget = builder.budget;
        directors = builder.directors;
        actors = builder.actors;
        countries = builder.countries;
        ageLimit = builder.ageLimit;
        duration = builder.duration;
        wordPremiere = builder.wordPremiere;
        uaPremiere = builder.uaPremiere;
        description = builder.description;
        studio = builder.studio;
        posterURL = builder.posterURL;
    }

//todo compareTo
    @Override
    public int compareTo(Movie o) {
        return 0;
    }
}
