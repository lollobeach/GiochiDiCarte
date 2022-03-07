package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;

import java.util.List;

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

    /**
     * Metodo che permette di
     * giocare un certo numero di carte
     *
     * @param pos array di indici per rappresentare
     *            le carte che si vogliono giocare
     *
     * @return lista di carte giocate
     */
    List<C> playCards(int... pos);
}
