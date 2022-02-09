package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.PileCards;

import java.util.List;

/**
 * Interfaccia che definisce
 * un giocatore il quale prevede
 * il possesso di carte in mano
 *
 * @param <C> tipo di carte giocate
 *           dal giocatore
 */
public interface PlayerWithHand<C extends Card<?>> extends PlayerWithoutHand<C>, PileCards<C> {

    /**
     * Metodo che permette di
     * pescare una carta da un
     * generico insieme di carte
     *
     * @param from insieme dal quale
     *             si pesca la carta
     * @param pos posizione della carta,
     *            all'interno dell'insieme,
     *            che si vuole pescare
     *
     * @return la carta pescata
     */
    C drawCard(PileCards<C> from, int pos);

    /**
     * Metodo che permette di
     * pescare un certo numero di carte
     * da un generico insieme di carte
     *
     * @param from insieme dal quale
     *             si pescano le carte
     * @param nCards numero di carte che
     *               si vogliono pescare
     *
     * @return lista di carte pescate
     */
    List<C> drawCards(PileCards<C> from, int nCards);
}
