package pl.netfliks.model;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                genre == movie.genre &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(desc, movie.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, releaseDate, desc);
    }
}
