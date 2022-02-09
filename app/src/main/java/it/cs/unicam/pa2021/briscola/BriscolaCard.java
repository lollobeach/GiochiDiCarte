package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicPair;
import it.cs.unicam.pa2021.giochidicarte.classiccards.TrevigianeFigures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.TrevigianeSeeds;

/**
 * Classe che rappresenta una tipica carta
 * da briscola avente un seme e una figura
 */
public class BriscolaCard extends ClassicCard<TrevigianeSeeds, TrevigianeFigures> {

    public BriscolaCard(int id, TrevigianeSeeds seme, TrevigianeFigures figura) {
        super(new ClassicPair<TrevigianeSeeds>(id,seme),figura);
    }
}
