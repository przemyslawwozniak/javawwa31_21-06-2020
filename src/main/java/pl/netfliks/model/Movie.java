package pl.netfliks.model;

import java.time.LocalDate;

public class Movie {

    private String title;
    private Genre genre;
    private LocalDate releaseDate;
    private String desc;

    public Movie(String title, Genre genre, LocalDate releaseDate, String desc) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getDesc() {
        return desc;
    }
}
