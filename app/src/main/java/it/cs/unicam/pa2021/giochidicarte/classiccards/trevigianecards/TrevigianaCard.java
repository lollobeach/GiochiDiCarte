package it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards;

import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicPair;

/**
 * Classe che rappresenta
 * una generica carta trevigiana
 */
public class TrevigianaCard extends ClassicCard<TrevigianeSeeds, TrevigianeFigures> {

    public TrevigianaCard(ClassicPair<TrevigianeSeeds> id, TrevigianeFigures figures) {
        super(id, figures);
    }
}
