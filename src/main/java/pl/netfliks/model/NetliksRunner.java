package pl.netfliks.model;

public class NetliksRunner {

    public static void main(String[] args) {
        CUI.getInstance().showAllMovies(MovieCatalogue.getInstance().getMovies());
    }

}
