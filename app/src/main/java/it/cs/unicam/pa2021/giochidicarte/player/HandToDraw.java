package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.PileCards;

import java.util.List;

/**
 * Interfaccia che va a definire una generica
 * mano, contenente delle carte, di un giocatore
 *
 * @param <C> tipo di carte contenute nella mano
 */
public interface HandToDraw<C extends Card<?>> extends PlayerHand<C>, PileCards<C> {

    /**
     * Metodo che permette di
     * pescare una carta
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
