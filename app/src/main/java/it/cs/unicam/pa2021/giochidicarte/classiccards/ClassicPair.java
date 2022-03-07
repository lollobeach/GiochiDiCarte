package it.cs.unicam.pa2021.giochidicarte.classiccards;

/**
 * Classe che definisce una coppia
 * id - seme per rappresentare
 * l'identificativo di una classica
 * carta da gioco
 *
 * @param <S> tipo di seme utilizzato
 */
public class ClassicPair<S extends Seeds> {

    private int index;
    private S seed;

    public ClassicPair(int index, S seed) {
        this.index = index;
        this.seed = seed;
    }

    public int getId() {
        return this.index;
    }

    public void setId(int newIndex) {
        this.index = newIndex;
    }

    public S getSeed() {
        return this.seed;
    }

    public void setSeed(S newSeed) {
        this.seed = newSeed;
    }

    @Override
    public String toString() {
        return "ClassicPair{" +
                "index=" + index +
                ", seed=" + seed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassicPair<?> that = (ClassicPair<?>) o;

        if (index != that.index) return false;
        return seed.equals(that.seed);
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + seed.hashCode();
        return result;
    }
}
