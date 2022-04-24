package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;

public interface PlayerHand<C extends Card<?>> {

    /**
     * Metodo che permette di
     * giocare una carta
     *
     * @return carta giocata
     */
    C playCard();
}
