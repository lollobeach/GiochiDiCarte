package it.cs.unicam.pa2021.giochidicarte;

import java.util.List;

public interface PlayerHand<C extends Card<?>> extends PileCards<C> {

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

    /**
     * Metodo che permette di
     * pescre una carta
     *
     * @param from lista da cui pescare
     *             la carta
     * @param pos posizione della carta
     *            che si vuole pescare
     *
     * @return carta pescata
     */
    C drawCard(PileCards<C> from, int pos);

    /**
     * Metodo che permette di
     * pescare un numero di carte
     *
     * @param from lista da cui pescare
     *             le carte
     * @param nCards numero di carte che si
     *               vogliono pescare
     *
     * @return lista di carte pescate
     */
    List<C> drawCards(PileCards<C> from, int nCards);
}
