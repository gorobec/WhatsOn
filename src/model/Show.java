package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Show {
    private int movieID;
    private int cinemaID;
    private int hallID;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Map<LocalTime, Boolean> seancesTime3D;
//    todo sorted
    private List<Double> price;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public int getHallID() {
        return hallID;
    }

    public void setHallID(int hallID) {
        this.hallID = hallID;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Map<LocalTime, Boolean> getSeancesTime3D() {
        return seancesTime3D;
    }

    public void setSeancesTime3D(Map<LocalTime, Boolean> seancesTime3D) {
        this.seancesTime3D = seancesTime3D;
    }

    public List<Double> getPrice() {
        return price;
    }

    public void setPrice(List<Double> price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Show{" +
                "movieID=" + movieID +
                ", cinemaID=" + cinemaID +
                ", hallID=" + hallID +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", seancesTime3D=" + seancesTime3D +
                ", price=" + price +
                '}';
    }
}
