package michelangelodicello.entities;

public class GIochiDaTavolo extends GiochiAbstract {
    private int numGiocatori;
    private Double durataMedia;

    public GIochiDaTavolo(long Id, String titolo, int anno, Double price, int numGiocatori, Double durataMedia) {
        super(Id, titolo, anno, price);
        this.numGiocatori = numGiocatori;
        this.durataMedia = durataMedia;
    }

    public int getNumGiocatori() {
        return numGiocatori;
    }

    public Double getDurataMedia() {
        return durataMedia;
    }
}
