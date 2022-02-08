package it.cs.unicam.pa2021.giochidicarte;

/**
 * Class che definisce una
 * generica carta avente un identificativo
 * e un valore
 */
public class SimpleCard implements Card {

    private String id;
    private int valore;

    public SimpleCard(String id, int valore) {
        this.id = id;
        this.valore = valore;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String nuovoId) {
        this.id = nuovoId;
    }

    @Override
    public int getValore() {
        return this.valore;
    }

    @Override
    public void setValore(int nuovoValore) {
        this.valore = nuovoValore;
    }

    @Override
    public String toString() {
        return "SimpleCard{" +
                "id='" + id + '\'' +
                ", valore=" + valore +
                '}';
    }
}
