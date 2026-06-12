package michelangelodicello;

import exceptions.GiocoEsistente;
import exceptions.GiocoNonTrovato;
import michelangelodicello.entities.*;
import michelangelodicello.entities.collezione.Collezione;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Collezione collezione = new Collezione();

        Videogiochi v1 = new Videogiochi(1343, "The Witcher 3", 2015, 29.99, Piattaforma.PC, 50, Genere.RPG);
        Videogiochi v2 = new Videogiochi(2654, "GTA V", 2013, 19.99, Piattaforma.PS5, 35, Genere.AZIONE);
        Videogiochi v3 = new Videogiochi(3546, "Elden Ring", 2022, 59.99, Piattaforma.XBOX, 60, Genere.STRATEGIA);
        Videogiochi v4 = new Videogiochi(4465, "Super Mario Odyssey", 2017, 49.99, Piattaforma.SWITCH, 15, Genere.SIMULAZIONE);
        Videogiochi v5 = new Videogiochi(5546, "Cyberpunk 2077", 2020, 39.99, Piattaforma.PC, 40, Genere.FANTASCIENZA);

        List<Videogiochi> videogiochi = List.of(v1, v2, v3, v4, v5);
        videogiochi.forEach(collezione::addGioco);

        GiochiDaTavolo g1 = new GiochiDaTavolo(6767, "Monopoly", 1935, 24.99, 6, 180.0);
        GiochiDaTavolo g2 = new GiochiDaTavolo(7563, "Risiko", 1957, 34.90, 5, 120.0);
        GiochiDaTavolo g3 = new GiochiDaTavolo(8342, "Catan", 1995, 40.00, 4, 90.0);
        GiochiDaTavolo g4 = new GiochiDaTavolo(9254, "Dixit", 2008, 29.99, 8, 30.0);
        GiochiDaTavolo g5 = new GiochiDaTavolo(1067, "Ticket to Ride", 2004, 44.50, 5, 60.0);

        List<GiochiDaTavolo> giochiDaTavolo = List.of(g1, g2, g3, g4, g5);
        giochiDaTavolo.forEach(collezione::addGioco);
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n--- SCEGLI OPZIONE ---");
            System.out.println("1. Aggiungi un Gioco");
            System.out.println("2. Ricerca gioco per ID");
            System.out.println("3. Ricerca giochi per prezzo massimo");
            System.out.println("4. Ricerca giochi da tavolo per numero giocatori");
            System.out.println("5. Rimuovi un gioco per ID");
            System.out.println("6. Aggiorna un gioco esistente");
            System.out.println("7. Mostra Statistiche della collezione");
            System.out.println("8. Stampa intera collezione");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            scelta = scanner.nextInt();

            try {
                switch (scelta) {
                    case 1:
                        System.out.println("\nQuale tipo di gioco vuoi aggiungere?");
                        System.out.println("1. Videogioco");
                        System.out.println("2. Gioco da Tavolo");
                        System.out.print("Scelta: ");
                        int tipoAggiunta = scanner.nextInt();

                        if (tipoAggiunta == 1) {
                            Videogiochi v = inputVideogioco(scanner);
                            collezione.addGioco(v);
                            System.out.println("Videogioco aggiunto con successo!");
                        } else if (tipoAggiunta == 2) {
                            GiochiDaTavolo g = inputGiocoDaTavolo(scanner);
                            collezione.addGioco(g);
                            System.out.println("Gioco da tavolo aggiunto con successo!");
                        } else {
                            System.out.println("Scelta tipo non valida! Operazione annullata.");
                        }
                        break;

                    case 2:
                        System.out.print("Inserisci l'ID da cercare: ");
                        int idCerca = scanner.nextInt();
                        GiochiAbstract trovato = collezione.ricercaPerId(idCerca);
                        System.out.println("Elemento trovato: " + trovato);
                        break;

                    case 3:
                        System.out.print("Inserisci il prezzo massimo: ");
                        double prezzoMax = scanner.nextDouble();
                        List<GiochiAbstract> sottoPrezzo = collezione.ricercaPerPrezzo(prezzoMax);
                        System.out.println("Giochi trovati (" + sottoPrezzo.size() + "):");
                        sottoPrezzo.forEach(System.out::println);
                        break;

                    case 4:
                        System.out.print("Inserisci il numero esatto di giocatori: ");
                        int numG = scanner.nextInt();
                        List<GiochiDaTavolo> perGiocatori = collezione.ricercaPerNumeroGiocatori(numG);
                        System.out.println("Giochi da tavolo trovati (" + perGiocatori.size() + "):");
                        perGiocatori.forEach(System.out::println);
                        break;

                    case 5:
                        System.out.print("Inserisci l'ID dell'elemento da rimuovere: ");
                        int idRimozione = scanner.nextInt();
                        collezione.rimozionePerId(idRimozione);
                        System.out.println("Gioco rimosso correttamente.");
                        break;

                    case 6:
                        System.out.print("Inserisci l'ID del gioco da aggiornare: ");
                        int idAggiorna = scanner.nextInt();

                        System.out.println("\nCon quale tipo di gioco vuoi sostituirlo?");
                        System.out.println("1. Un nuovo Videogioco");
                        System.out.println("2. Un nuovo Gioco da Tavolo");
                        System.out.print("Scelta: ");
                        int tipoAggiornamento = scanner.nextInt();
                        scanner.nextLine();

                        GiochiAbstract nuovoDato = null;

                        if (tipoAggiornamento == 1) {
                            System.out.println("Inserisci i nuovi dati del Videogioco:");
                            nuovoDato = inputVideogioco(scanner);
                        } else if (tipoAggiornamento == 2) {
                            System.out.println("Inserisci i nuovi dati del Gioco da Tavolo:");
                            nuovoDato = inputGiocoDaTavolo(scanner);
                        }

                        if (nuovoDato != null) {
                            collezione.aggiornaGioco(idAggiorna, nuovoDato);
                            System.out.println("Gioco aggiornato con successo!");
                        } else {
                            System.out.println("Scelta tipo non valida! Aggiornamento annullato.");
                        }
                        break;

                    case 7:
                        collezione.statisticheCollezione();
                        break;

                    case 8:
                        collezione.stampaCollezione();
                        break;

                    case 0:
                        System.out.println("Chiusura programma");
                        break;

                    default:
                        System.out.println("Opzione non valida!");
                }
            } catch (GiocoEsistente | GiocoNonTrovato e) {
                System.err.println("\nERRORE: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("\nERRORE: Input non valido o errore imprevisto.");
                scanner.nextLine();
            }

        } while (scelta != 0);
    }

    private static Videogiochi inputVideogioco(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Anno: ");
        int anno = scanner.nextInt();
        System.out.print("Prezzo: ");
        double prezzo = scanner.nextDouble();
        System.out.print("Piattaforma (PC, PS5, XBOX, SWITCH): ");
        String piattaforma = scanner.next().toUpperCase();
        System.out.print("Durata (ore): ");
        int durata = scanner.nextInt();
        System.out.print("Genere (AZIONE, AVVENTURA, RPG, FANTASCIENZA, STRATEGIA, SIMULAZIONE): ");
        String genere = scanner.next().toUpperCase();

        return new Videogiochi(id, titolo, anno, prezzo, Piattaforma.valueOf(piattaforma), durata, Genere.valueOf(genere));
    }

    private static GiochiDaTavolo inputGiocoDaTavolo(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Anno: ");
        int anno = scanner.nextInt();
        System.out.print("Prezzo: ");
        double prezzo = scanner.nextDouble();
        System.out.print("Numero Giocatori: ");
        int numGiocatori = scanner.nextInt();
        System.out.print("Durata Media (in minuti, es. 90,0): ");
        double durataMedia = scanner.nextDouble();

        return new GiochiDaTavolo(id, titolo, anno, prezzo, numGiocatori, durataMedia);
    }
}

