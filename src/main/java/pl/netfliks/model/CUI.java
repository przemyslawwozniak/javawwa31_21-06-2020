package pl.netfliks.model;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;

import java.time.format.DateTimeFormatter;
import java.util.List;

//ConsoleUserInterface
public class CUI {

    private static final CUI INSTANCE = new CUI();

    //tak odwolujemy sie do instancji 'z zewnatrz'
    public static CUI getInstance() {
        return INSTANCE;
    }

    private CUI() {}

    public void showAllMovies(List<Movie> movies) {
        AsciiTable table = new AsciiTable();
        //resize column to fit longest text line
        CWC_LongestLine cwc = new CWC_LongestLine();
        table.getRenderer().setCWC(cwc);

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
