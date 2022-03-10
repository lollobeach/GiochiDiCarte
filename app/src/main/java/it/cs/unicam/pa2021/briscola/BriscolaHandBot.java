package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;

import java.util.Random;

public class BriscolaHandBot extends BriscolaHand {

    public BriscolaHandBot() {
        super();
    }

    public TrevigianaCard playCard() {
        Random random = new Random();
        int card = random.nextInt(3);
        return this.playCard(card);
    }
}
