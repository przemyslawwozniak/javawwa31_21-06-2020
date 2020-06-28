package pl.netfliks.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieCatalogue {

    private List<Movie> movies;

    public MovieCatalogue() {
        movies = new ArrayList<>();

        movies.add(new Movie("Ogniem i Mieczem",
                Genre.HISTORICAL,
                LocalDate.of(1999, 2, 8),
                "Polski film historyczny z 1999 roku, w reżyserii Jerzego Hoffmana, na podstawie powieści Henryka Sienkiewicza pod tym samym tytułem."));
    }

}
