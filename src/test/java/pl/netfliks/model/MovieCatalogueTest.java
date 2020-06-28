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
        .as("Random line from resource should not be blank!");  //wypisuje tekst bledu kiedy wywali sie metoda
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
        Assertions.assertThat(movies).hasSize(10)   //uzywac test resources!!!
                .as("Catalogue was not property loaded!");
    }

    @Test
    public void add_movie_to_catalogue() {
        //given
        Movie movie = new Movie("Planet Earth II", Genre.DOCUMENTARY, LocalDate.of(2016, 6, 11),
                "David Attenborough returns in this breathtaking documentary showcasing life on Planet Earth.");
        int initialCatalogueSize = MovieCatalogue.getInstance().getMovies().size();

        //when
        MovieCatalogue.getInstance().insertMovie(movie);

        //then
        Assertions.assertThat(MovieCatalogue.getInstance().getMovies())
                .hasSize(initialCatalogueSize + 1)
        .as("Movie wasn't properly added to catalogue!");

    }

    @Test
    public void converts_movie_to_text_line() {
        //given
        Movie movie = new Movie("Avatar", Genre.FANTASY, LocalDate.of(2009, 12, 18),
                "Avatar is a 2009 American epic science fiction film directed, written, produced, and co-edited by James Cameron and stars Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, and Sigourney Weaver");

        //when:
        String parsedMovie = MovieCatalogue.getInstance().toString(movie);

        //then:
        Assertions.assertThat(parsedMovie).isEqualTo("Avatar|FANTASY|2009,12,18|Avatar is a 2009 American epic science fiction film directed, written, produced, and co-edited by James Cameron and stars Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, and Sigourney Weaver");
    }

    @Test
    public void save_catalogue_instance_to_file() {
        //given
        Movie movie = new Movie("Planet Earth II", Genre.DOCUMENTARY, LocalDate.of(2016, 6, 11),
                "David Attenborough returns in this breathtaking documentary showcasing life on Planet Earth.");
        int initialCatalogueSize = MovieCatalogue.getInstance().getMovies().size();
        MovieCatalogue.getInstance().insertMovie(movie);

        //when
        MovieCatalogue.getInstance().persist();

        //then
        MovieCatalogue.getInstance().loadMovies();  //refresh memory from file
        List<Movie> loadedMovies = MovieCatalogue.getInstance().getMovies();

        Assertions.assertThat(loadedMovies).hasSize(initialCatalogueSize + 1);
        Assertions.assertThat(loadedMovies).contains(movie);
    }

}
