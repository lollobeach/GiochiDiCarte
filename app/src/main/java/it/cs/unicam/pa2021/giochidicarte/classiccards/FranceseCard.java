package it.cs.unicam.pa2021.giochidicarte.classiccards;

/**
 * Classe che rappresenta
 * una generica carta francese
 */
public class FranceseCard extends ClassicCard<FrenchSeeds,FrenchFigures>{

    public FranceseCard(ClassicPair<FrenchSeeds> id, FrenchFigures figures) {
        super(id, figures);
    }
}
