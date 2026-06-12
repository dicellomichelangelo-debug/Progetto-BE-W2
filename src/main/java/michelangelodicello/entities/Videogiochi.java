package michelangelodicello.entities;

public class Videogiochi extends GiochiAbstract {
    private Piattaforma piattaforma;
    private int durataGioco;
    private Genere genere;

    public Videogiochi(long Id, String titolo, int anno, Double price, Piattaforma piattaforma, int durataGioco, Genere genere) {
        super(Id, titolo, anno, price);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }

    public Piattaforma getPiattaforma() {
        return piattaforma;
    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Videogiochi{" + super.toString() +
                "piattaforma=" + piattaforma +
                ", durataGioco=" + durataGioco +
                ", genere=" + genere +
                '}';
    }
}
