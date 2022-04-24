package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;

import java.util.Random;

/**
 * Classe che rappresenta la
 * mano di un bot.
 * La carta da giocare viene scelta
 * in modo casuale
 */
public class BriscolaHandBot extends BriscolaHand {

    public BriscolaHandBot() {
        super();
    }

    @Override
    public TrevigianaCard playCard() {
        Random random = new Random();
        int card = random.nextInt(this.nCards());
        System.out.println("Carta giocata dal bot: "+this.cardInPosition(card)+"\n");
        return this.removeCardInPos(card);
    }

}
