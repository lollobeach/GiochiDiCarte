package it.cs.unicam.pa2021.giochidicarte.deck;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.PileCards;

import java.util.List;

/**
 * Interfaccia che definisce le
 * azioni elementari che si possono
 * compiere con un mazzo disordinato
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
     * @param card di cui si vuole sapere se
     *              si trova nel mazzo
     *
     * @throws NullPointerException se la carta
     * &egrave; null
     *
     * @return true se &egrave; presente, false
     * altrimenti
     */
    default boolean cardIsPresent(C card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        return getCards().contains(card);
    }

    /**
     * Metodo che permette di controllare
     * la presenza di una serie di carte
     * nell'insieme di carte
     *
     * @param cards carte che si vogliono
     *              controllare
     *
     * @throws NullPointerException se la lista
     * &egrave; vuota o se non contiene alcuna carta
     *
     * @return true se tutte le carte
     * selezionate sono presenti, false altrimenti
     */
    default boolean cardsArePresents(List<C> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate"); }
        return getCards().containsAll(cards);
    }

    /**
     * Metodo che permette di rimuovere
     * un numero di carte dal mazzo
     *
     * @param n numero di carte che si vogliono
     *          eliminare
     *
     * @return lista di carte che sono state rimosse
     */
    List<C> removeNCards(int n);

    /**
     * Metodo che permette di rimuovere
     * un numero di carte dal mazzo partendo
     * da una posizione scelta
     *
     * @param n numero di carte che si vuole
     *          rimuovere
     * @param pos indice di partenza per la rimozione
     *            delle carte
     *
     * @return lista di carte rimosse
     */
    List<C> removeNCardsFromPosition(int n, int pos);

    /**
     * Metodo che permette di mischiare
     * il mazzo
     */
    void shuffleDeck();
}
