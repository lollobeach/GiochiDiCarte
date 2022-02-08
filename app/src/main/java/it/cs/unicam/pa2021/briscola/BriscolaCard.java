package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.SimpleCard;

public class BriscolaCard extends SimpleCard {

    private final BriscolaSeeds seme;
    private final BriscolaFigures figura;

    public BriscolaCard(String id, int valore, BriscolaSeeds seme, BriscolaFigures figura) {
        super(id, valore);
        this.seme = seme;
        this.figura = figura;
    }

    public BriscolaSeeds getSeme() {
        return this.seme;
    }

    public BriscolaFigures getFigura() {
        return this.figura;
    }

    @Override
    public String toString() {
        return "BriscolaCard{" +
                "seme=" + seme +
                ", figura=" + figura +
                '}';
    }
}
