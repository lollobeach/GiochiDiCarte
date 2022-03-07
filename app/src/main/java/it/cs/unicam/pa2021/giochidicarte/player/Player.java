package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;

public interface Player<C extends Card<?>> {

    /**
     * Metodo che ritorna
     * l'id del giocatore
     *
     * @return id giocatore
     */
    int getId();

    /**
     * Metodo che ritorna la
     * mano del giocatore
     *
     * @return mano del giocatore
     */
    PlayerHand<C> getHand();
}
