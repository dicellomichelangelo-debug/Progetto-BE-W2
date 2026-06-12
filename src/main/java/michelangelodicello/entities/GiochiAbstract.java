package michelangelodicello.entities;

public abstract class GiochiAbstract {
    protected long Id;
    protected String titolo;
    protected int anno;
    protected Double price;

    public GiochiAbstract(long Id, String titolo, int anno, Double price) {
        this.Id = Id;
        this.titolo = titolo;
        this.anno = anno;
        this.price = price;
    }

    public long getId() {
        return Id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnno() {
        return anno;
    }

    public Double getPrice() {
        return price;
    }
}
