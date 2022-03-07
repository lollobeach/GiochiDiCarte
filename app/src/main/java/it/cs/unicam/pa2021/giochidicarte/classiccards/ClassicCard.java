package it.cs.unicam.pa2021.giochidicarte.classiccards;

import it.cs.unicam.pa2021.giochidicarte.Card;

/**
 * Classe che definisce una
 * classica carta da gioco
 * avente un seme e una figura
 *
 * @param <S> tipo di seme utilizzato
 * @param <F> tipo di figura utilizzata
 */
public abstract class ClassicCard<S extends Seeds, F extends Figures> implements Card<ClassicPair<S>> {

    private ClassicPair<S> id;
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
        this.id = new ClassicPair<>(newIndex, newSeed);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassicCard<?, ?> that = (ClassicCard<?, ?>) o;

        if (!id.equals(that.id)) return false;
        return figures.equals(that.figures);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + figures.hashCode();
        return result;
    }
}
