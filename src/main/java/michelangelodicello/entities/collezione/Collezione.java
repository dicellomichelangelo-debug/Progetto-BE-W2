package michelangelodicello.entities.collezione;

import exceptions.GiocoEsistente;
import exceptions.GiocoNonTrovato;
import michelangelodicello.entities.GiochiAbstract;
import michelangelodicello.entities.GiochiDaTavolo;
import michelangelodicello.entities.Videogiochi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Collezione {
    private List<GiochiAbstract> games;

    public Collezione() {
        this.games = new ArrayList<>();
    }

    public void addGioco(GiochiAbstract gioco) throws GiocoEsistente {
        if (games.stream().anyMatch(listaGiochi -> listaGiochi.getId() == gioco.getId())) {
            throw new GiocoEsistente("Errore: L'ID " + gioco.getId() + " è già assegnato a: " + gioco.getTitolo());
        } else {
            games.add(gioco);
        }
    }

    public GiochiAbstract ricercaPerId(int id) {
        for (GiochiAbstract gioco : games) {
            if (gioco.getId() == id) {
                return gioco;
            }
        }
        throw new GiocoNonTrovato("Nessun gioco trovato con id: " + id);
    }

    public List<GiochiAbstract> ricercaPerPrezzo(double prezzoMassimo) {
        return games.stream()
                .filter(gioco -> gioco.getPrice() < prezzoMassimo).toList();
    }

    public List<GiochiDaTavolo> ricercaPerNumeroGiocatori(int numGiocatori) {
        return games.stream()
                .filter(gioco -> gioco instanceof GiochiDaTavolo)
                .map(gioco -> (GiochiDaTavolo) gioco)
                .filter(gioco -> gioco.getNumGiocatori() == numGiocatori).toList();
    }

    public void rimozionePerId(int id) throws GiocoNonTrovato {
        GiochiAbstract gioco = ricercaPerId(id);
        games.remove(gioco);
    }

    public void aggiornaGioco(int id, GiochiAbstract nuovoGioco) throws GiocoNonTrovato {
        GiochiAbstract vecchioGioco = ricercaPerId(id);
        int index = games.indexOf(vecchioGioco);
        games.set(index, nuovoGioco);
    }

    public void statisticheCollezione() {
        if (games.isEmpty()) {
            System.out.println("La collezione è vuota");
        }
        long totaleVideogiochi = games.stream().filter(gioco -> gioco instanceof Videogiochi).count();
        long totaleGiochiDaTavolo = games.stream().filter(gioco -> gioco instanceof GiochiDaTavolo).count();
        System.out.println("I videogiochi in totale sono: " + totaleVideogiochi);
        System.out.println("I giochi da tavolo in totale sono: " + totaleGiochiDaTavolo);

        List<GiochiAbstract> giocoPiuCaro = games.stream().sorted(Comparator.comparingDouble(gioco -> ((GiochiAbstract) gioco).getPrice()).reversed()).limit(2).toList();
        System.out.println("I giochi più costosi sono: " + giocoPiuCaro);

        OptionalDouble mediaPrezzi = games.stream().mapToDouble(GiochiAbstract::getPrice).average();
        if (mediaPrezzi.isPresent()) System.out.println("La media dei giochi è: " + mediaPrezzi.getAsDouble());
        else System.out.println("La media non è possibile");

    }

    public void stampaCollezione() {
        if (games.isEmpty()) {
            System.out.println("La collezione è vuota.");
        } else {
            System.out.println("--- ELENCO COLLEZIONE ---");
            games.forEach(System.out::println);
        }
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "games=" + games +
                '}';
    }
}
