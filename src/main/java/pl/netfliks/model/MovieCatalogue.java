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
        loadMovies();
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

    void loadMovies() {
        movies = new ArrayList<>(); //czysci pamiec katalogu filmow
        File file = new File("C:\\Users\\przwo\\Desktop\\movie_catalogue.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                movies.add(toMovie(line));
            }
        }
        catch(FileNotFoundException ex) {
            System.err.println("Wrong file path!");
        }
    }

    //Ogniem i Mieczem|HISTORICAL|1999,2,8|Polski film historyczny z 1999 roku...
    Movie toMovie(String resourceLine) {
        String[] fields = resourceLine.split("\\|");    //special character! escape
        String title = fields[0];
        Genre genre = Genre.valueOf(fields[1]);
        LocalDate releaseDate = parseDate(fields[2]);
        String desc = fields[3];

        return new Movie(title, genre, releaseDate, desc);
    }

    //1999,2,8
    private LocalDate parseDate(String dateLine) {
        String[] dateParts = dateLine.split(",");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        return LocalDate.of(year, month, day);
    }

    public void insertMovie(Movie movie) {
        movies.add(movie);
    }

    public void persist() {
        
    }

    String toString(Movie movie) {
        StringBuilder strb = new StringBuilder();

        strb.append(movie.getTitle());
        strb.append("|");

        strb.append(movie.getGenre().name());
        strb.append("|");

        strb.append(toString(movie.getReleaseDate()));
        strb.append("|");

        strb.append(movie.getDesc());

        return strb.toString();
    }

    private String toString(LocalDate date) {
        StringBuilder strb = new StringBuilder();
        strb.append(date.getYear());
        strb.append(",");
        strb.append(date.getMonthValue());
        strb.append(",");
        strb.append(date.getDayOfMonth());
        return strb.toString();
    }
}
