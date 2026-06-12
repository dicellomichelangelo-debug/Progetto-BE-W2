package michelangelodicello.entities.collezione;

import exceptions.GiocoEsistente;
import exceptions.GiocoNonTrovato;
import michelangelodicello.entities.GiochiAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collezione {
    private List<GiochiAbstract> games;

    public Collezione() {
        this.games = new ArrayList<>();
    }

    public void addGioco(GiochiAbstract gioco) {
        if (games.stream().anyMatch(listaGiochi -> listaGiochi.getId() == gioco.getId())) {
            throw new GiocoEsistente("è già presente un gioco con questo Id: " + gioco.getTitolo());
        } else {
            games.add(gioco);
        }
    }

    public GiochiAbstract ricercaPerId(long id) {
        for (GiochiAbstract gioco : games) {
            if (gioco.getId() == id) {
                return gioco;
            }
        }
        throw new GiocoNonTrovato("Nessun gioco trovato con id: " + id);
    }

    public List<GiochiAbstract> ricercaPerPrezzo(double prezzoMassimo) {
        return games.stream()
                .filter(g -> g.getPrice() < prezzoMassimo)
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "Collezione{" +
                "games=" + games +
                '}';
    }
}
