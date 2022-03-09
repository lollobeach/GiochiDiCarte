package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;

public interface PlayerHand<C extends Card<?>> {

    /**
     * Metodo che permette di
     * giocare una carta
     *
     * @param pos posizione della carta
     *            che si vuole giocare
     *
     * @return carta giocata
     */
    C playCard(int pos);
}
