package model;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Movie implements Comparable<Movie> {
    private final String title;
    private final String originalTitle;
    private final int year;
    private final List<Integer> genresId;
    private final Integer budget;
    private final Map<Integer, List<Integer>> persons;
    private final List<Integer> countriesId;
    private final int ageLimit;
    private final int duration;
    private final LocalDate wordPremiere;
    private final LocalDate uaPremiere;
    private final String description;
    private final List<Integer> studios;
    private final String posterURL;

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public List<Integer> getGenresId() {
        return genresId;
    }

    /*
        * Builder pattern for many constructor parameters
        * */
    public static class Builder {
        private int id;
        private String title;
        private String originalTitle;
        private int year;
        private List<Integer> genresId;
        private Integer budget;
        private Map<Integer, List<Integer>> persons;
        private List<Integer> actorsId;
        private List<Integer> countriesId;
        private int ageLimit;
        private int duration;
        private LocalDate wordPremiere;
        private LocalDate uaPremiere;
        private String description;
        private List<Integer> studios;
        private String posterURL;


        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder originalTitle(String originalTitle){
            this.originalTitle = originalTitle;
            return this;
        }
        public Builder year(int year){
            this.year = year;
            return this;
        }
        public Builder genres(List<Integer> genresId){
            this.genresId = genresId;
            return this;
        }
        public Builder budget(Integer budget){
           this.budget = budget;
            return this;
        }
        public Builder persons(Map<Integer, List<Integer>> persons){
            this.persons = persons;
            return this;
        }
        public Builder countries(List<Integer> countriesId){
            this.countriesId = countriesId;
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
        public Builder studios(List<Integer> studios){
            this.studios = studios;
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
        title = builder.title;
        originalTitle = builder.originalTitle;
        year = builder.year;
        genresId = builder.genresId;
        budget = builder.budget;
        persons = builder.persons;
        countriesId = builder.countriesId;
        ageLimit = builder.ageLimit;
        duration = builder.duration;
        wordPremiere = builder.wordPremiere;
        uaPremiere = builder.uaPremiere;
        description = builder.description;
        studios = builder.studios;
        posterURL = builder.posterURL;
    }

//todo compareTo
    @Override
    public int compareTo(Movie movie) {
        return title.compareTo(movie.title);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", year=" + year +
                ", genresId=" + genresId +
                ", budget=" + budget +
                ", persons=" + persons +
                ", countriesId=" + countriesId +
                ", ageLimit=" + ageLimit +
                ", duration=" + duration +
                ", wordPremiere=" + wordPremiere +
                ", uaPremiere=" + uaPremiere +
                ", description='" + description + '\'' +
                ", studios=" + studios +
                ", posterURL='" + posterURL + '\'' +
                '}';
    }
}
