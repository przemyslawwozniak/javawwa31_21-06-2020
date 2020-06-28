package pl.netfliks.model;

import de.vandermeer.asciitable.AsciiTable;

import java.time.format.DateTimeFormatter;
import java.util.List;

//ConsoleUserInterface
public class CUI {

    public void showAllMovies(List<Movie> movies) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("Title", "Genre", "Release Date", "Description");

        for(Movie m : movies) {
            table.addRule();
            table.addRow(m.getTitle(),
                    m.getGenre().name(),
                    m.getReleaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                    m.getDesc());
        }

        table.addRule();

        System.out.println(table.render());
    }

}
