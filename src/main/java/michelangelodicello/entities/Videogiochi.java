package michelangelodicello.entities;

public class Videogiochi extends GiochiAbstract {
    private String piattaforma;
    private int durataGioco;
    private Genere genere;

    public Videogiochi(long Id, String titolo, int anno, Double price, String piattaforma, int durataGioco, Genere genere) {
        super(Id, titolo, anno, price);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public Genere getGenere() {
        return genere;
    }
}
