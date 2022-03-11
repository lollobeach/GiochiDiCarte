package it.cs.unicam.pa2021.giochidicarte.deck;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.PileCards;

import java.util.List;

/**
 * Interfaccia che descrive
 * il comportamento di un generico
 * mazzo
 *
 * @param <C> tipo di carte che sono
 *           contenute nel mazzo
 */
public interface Deck<C extends Card<?>> extends PileCards<C> {

    /**
     * Metodo che permette di determinare
     * se una determinata carta &egrave; presente
     * nel mazzo
     *
     * @param card carta di cui si
     *             vuole sapere la presenza
     *
     * @return true se la carta &egrave;
     * presente, false altrimenti
     */
    boolean cardIsPresent(C card);

    /**
     * Metodo che permette di controllare
     * la presenza di una serie di carte
     * nell'insieme di carte
     *
     * @param cards carte che si vogliono
     *              controllare
     *
     * @return true se tutte le carte
     * selezionate sono presenti, false altrimenti
     */
    boolean cardsArePresents(List<C> cards);

    /**
     * Metodo che permette di mischiare
     * il mazzo
     *
     * @param n numero di volte da
     *          mischiare
     */
    void shuffleDeck(int n);
}
