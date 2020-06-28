package pl.netfliks.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class MovieCatalogueTest {

    @Test
    public void access_resource_file() {
        //given:

        //when:
        String resourceLine = MovieCatalogue.getInstance().getFirstResourceLine();
        System.out.println("First line from resource file: \n" + resourceLine);

        //then:
        Assertions.assertThat(resourceLine)
                .isNotBlank()
        .as("Random line from resource should not be blank!");
    }

    @Test
    public void map_resource_line_to_Movie_instance() {
        //given:
        String resourceLine = MovieCatalogue.getInstance().getFirstResourceLine();

        //when:
        Movie movie = MovieCatalogue.getInstance().toMovie(resourceLine);

        //then:
        Assertions.assertThat(movie)
                .isNotNull()
                .hasFieldOrPropertyWithValue("title", "Ogniem i Mieczem")   //poprawic dostep do test resources aby miec zawsze te same dane testowe
                .hasFieldOrPropertyWithValue("genre", Genre.HISTORICAL)
                .hasFieldOrPropertyWithValue("releaseDate", LocalDate.of(1999, 2, 8))
                .hasFieldOrPropertyWithValue("desc", "Polski film historyczny z 1999 roku, w reżyserii Jerzego Hoffmana, na podstawie powieści Henryka Sienkiewicza pod tym samym tytułem.")
        .as("Tekst nie został poprawnie zmapowany na instancję Movie.");
    }

    @Test
    public void read_catalogue() {
        //given

        //when
        List<Movie> movies = MovieCatalogue.getInstance().getMovies();

        //then
        Assertions.assertThat(movies).hasSize(10)
                .as("Catalogue was not property loaded!");
    }

}
