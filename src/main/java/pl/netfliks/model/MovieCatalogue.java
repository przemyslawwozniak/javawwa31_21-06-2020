package pl.netfliks.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//singleton pattern
public class MovieCatalogue {

    private List<Movie> movies;

    //utworzenie jedynej instancji w programie
    private static final MovieCatalogue INSTANCE = new MovieCatalogue();

    //tak odwolujemy sie do instancji 'z zewnatrz'
    public static MovieCatalogue getInstance() {
        return INSTANCE;
    }

    //prywatny konstruktor - nie mozna utworzyc instancji 'z zewnatrz'
    private MovieCatalogue() {
        movies = new ArrayList<>();

        movies.add(new Movie("Ogniem i Mieczem",
                Genre.HISTORICAL,
                LocalDate.of(1999, 2, 8),
                "Polski film historyczny z 1999 roku, w reżyserii Jerzego Hoffmana, na podstawie powieści Henryka Sienkiewicza pod tym samym tytułem."));

        movies.add(new Movie("Hero",
                Genre.HISTORICAL,
                LocalDate.of(2002, 10, 2),
                "In this visually arresting martial arts epic set in ancient China, an unnamed fighter (Jet Li) is being honored for defeating three of the king's most dangerous enemies."));

        movies.add(new Movie("Dogma",
                Genre.COMEDY,
                LocalDate.of(1999, 11, 12),
                "Two fallen angels who were ejected from paradise find themselves banned in Wisconsin. They are now headed for New Jersey where they find a loophole that can get them back into heaven. The only catch is that it will destroy humanity. A group bands together to stop them."));

        movies.add(new Movie("Lord of war",
                Genre.THRILLER,
                LocalDate.of(2005, 9, 16),
                "Lord of War is a 2005 American crime drama film[3] written, produced, and directed by Andrew Niccol, and co-produced by and starring Nicolas Cage. "));

        movies.add(new Movie("Spirited Away",
                Genre.ANIME,
                LocalDate.of(2001, 07, 21),
                "10-year-old Chihiro and her parents stumble upon a seemingly abandoned amusement park. After her mother and father are turned into giant pigs, Chihiro meets the mysterious Haku, who explains that the park is a resort for supernatural beings who need a break from their time spent in the earthly realm, and that she must work there to free herself and her parents."));

        movies.add(new Movie("Mechaniczna pomarańcza",
                Genre.SCI_FI,
                LocalDate.of(1971, 12, 19),
                "amerykańsko-brytyjski dramat science fiction z 1971 roku, ekranizacja powieści Anthony'ego Burgessa o tym samym tytule. Autorem scenariusza, reżyserem i producentem obrazu był Stanley Kubrick."));

        movies.add(new Movie("Matrix",
                Genre.SCI_FI,
                LocalDate.of(1999, 8, 13),
                "australijsko-amerykański film science fiction, pierwszy z trylogii filmowej o tej samej nazwie, napisany i wyreżyserowany przez rodzeństwo Wachowski."));

        movies.add(new Movie("Rekinado",
                Genre.SCI_FI,
                LocalDate.of(2013, 11, 1),
                "Ogromny huragan powoduje zalanie zachodniego wybrzeża USA i sprowadza w jego rejony setki głodnych rekinów. " +
                        "Nadmorski bar dla surferów zostaje zniszczony przez wielkie fale. Jego właściciel Fin (Ian Ziering), wyrusza w niebezpieczną przeprawę przez zalane tereny Los Angeles. "));

        movies.add(new Movie("Polowanie na Czerwony Październik",
                Genre.SCI_FI,
                LocalDate.of(1990, 3, 2),
                "Film sensacyjny z 1990 roku w reżyserii Johna McTiernana, ekranizacja powieści o tym samym tytule Toma Clancy'ego."));

        movies.add(new Movie("Avatar",
                Genre.FANTASY,
                LocalDate.of(2009, 12, 18),
                "Avatar is a 2009 American epic science fiction film directed, written, produced, and co-edited by James Cameron and stars Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, and Sigourney Weaver. "));

    }

    //default scope - package scope
    String getFirstResourceLine() {
        File file = new File("C:\\Users\\przwo\\Desktop\\movie_catalogue.txt");
        try {
            Scanner sc = new Scanner(file);
            if(sc.hasNextLine()){
                return sc.nextLine();
            }
        }
        catch(FileNotFoundException ex) {
            System.err.println("Wrong file path!");
        }
        return null;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    Movie toMovie(String resourceLine) {
        
    }
}
