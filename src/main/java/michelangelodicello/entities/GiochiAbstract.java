package michelangelodicello.entities;

public abstract class GiochiAbstract {
    protected int Id;
    protected String titolo;
    protected int anno;
    protected Double price;

    public GiochiAbstract(int Id, String titolo, int anno, Double price) {
        this.Id = Id;
        this.titolo = titolo;
        this.anno = anno;
        this.price = price;
    }

    public int getId() {
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

    @Override
    public String toString() {
        return "GiochiAbstract{" +
                ", titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", price=" + price +
                '}';
    }
}
