package michelangelodicello;

import michelangelodicello.entities.Genere;
import michelangelodicello.entities.GiochiDaTavolo;
import michelangelodicello.entities.Piattaforma;
import michelangelodicello.entities.Videogiochi;
import michelangelodicello.entities.collezione.Collezione;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Collezione collezione = new Collezione();

        Videogiochi v1 = new Videogiochi(1L, "The Witcher 3", 2015, 29.99, Piattaforma.PC, 50, Genere.RPG);
        Videogiochi v2 = new Videogiochi(2L, "GTA V", 2013, 19.99, Piattaforma.PS5, 35, Genere.AZIONE);
        Videogiochi v3 = new Videogiochi(3L, "Elden Ring", 2022, 59.99, Piattaforma.XBOX, 60, Genere.STRATEGIA);
        Videogiochi v4 = new Videogiochi(4L, "Super Mario Odyssey", 2017, 49.99, Piattaforma.SWITCH, 15, Genere.SIMULAZIONE);
        Videogiochi v5 = new Videogiochi(5L, "Cyberpunk 2077", 2020, 39.99, Piattaforma.PC, 40, Genere.FANTASCIENZA);

        List.of(v1, v2, v3, v4, v5).forEach(collezione::addGioco);

        GiochiDaTavolo g1 = new GiochiDaTavolo(6L, "Monopoly", 1935, 24.99, 6, 180.0);
        GiochiDaTavolo g2 = new GiochiDaTavolo(7L, "Risiko", 1957, 34.90, 5, 120.0);
        GiochiDaTavolo g3 = new GiochiDaTavolo(8L, "Catan", 1995, 40.00, 4, 90.0);
        GiochiDaTavolo g4 = new GiochiDaTavolo(9L, "Dixit", 2008, 29.99, 8, 30.0);
        GiochiDaTavolo g5 = new GiochiDaTavolo(10L, "Ticket to Ride", 2004, 44.50, 5, 60.0);

        List.of(g1, g2, g3, g4, g5).forEach(collezione::addGioco);

    }
}
