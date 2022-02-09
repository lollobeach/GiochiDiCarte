package it.cs.unicam.pa2021.giochidicarte.classiccards;

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
}
