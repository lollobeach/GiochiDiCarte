package it.cs.unicam.pa2021.giochidicarte.classiccards;

import it.cs.unicam.pa2021.giochidicarte.Card;

/**
 * Classe che definisce una
 * classica carta da gioco
 * avente un seme e una figura
 */
public abstract class ClassicCard<S extends Seeds, F extends Figures> implements Card<ClassicPair<S>> {

    private final ClassicPair<S> id;
    private F figures;

    public ClassicCard(ClassicPair<S> id, F figures) {
        this.id = id;
        this.figures = figures;
    }

    @Override
    public ClassicPair<S> getIdentity() {
        return this.id;
    }

    public void setId(int newIndex, S newSeed) {
        this.id.setId(newIndex);
        this.id.setSeed(newSeed);
    }

    public int getIndex() { return this.id.getId(); }

    public void setIndex(int newIndex) {
        this.id.setId(newIndex);
    }

    public S getSeed() { return this.id.getSeed(); }

    public void setSeed(S newSeed) { this.id.setSeed(newSeed);}

    public F getFigures() {
        return this.figures;
    }

    public void setFigures(F newFigures) {
        this.figures = newFigures;
    }

    @Override
    public String toString() {
        return "ClassicCard{" +
                "id=" + id +
                ", figures=" + figures +
                '}';
    }
}
