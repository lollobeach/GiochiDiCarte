package it.cs.unicam.pa2021.giochidicarte;

import java.util.List;


/**
 * Interfaccia che definisce le
 * azioni elementari che si possono
 * compiere con un mazzo disordinato
 *
 * @param <C> tipo di carte che sono
 *           contenute nel mazzo
 */
public interface MessyDeck<C extends Card> extends PileCards<C> {

    /**
     * Metodo che ritorna tutte le
     * carte contenute nel mazzo
     *
     * @return lista di carte contenute
     */
    List<C> getCardsDeck();

    @Override
    default List<C> getCards() {
        return getCardsDeck();
    }

    @Override
    default int nCards() {
        return getCardsDeck().size();
    }

    @Override
    default void addCard(C card) {
        getCardsDeck().add(card);
    }

    @Override
    default void addCards(List<C> cards) {
        getCardsDeck().addAll(cards);
    }
    @Override
    default void removeCard(C card) {
        getCardsDeck().remove(card);
    }

    @Override
    default void removeCards(List<C> cards) {
        getCardsDeck().removeAll(cards);
    }

    /**
     * Metodo che ritorna la posizione
     * di una determinata carta all'interno del mazzo
     *
     * @param card carta di cui si vuole sapere
     *              la posizione
     *
     * @throws NullPointerException se si passa null
     * come argomento
     * @throws IllegalArgumentException se la carta
     * non è contenuta nel mazzo
     *
     * @return posizione della carta selezionata
     */
    default int getPositionCard(C card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        if (!getCardsDeck().contains(card)) { throw new IllegalArgumentException("Carta non presente nel mazzo"); }
        return getCardsDeck().lastIndexOf(card);
    }

    /**
     * Metodo permette di determinare
     * se una determinata carta &egrave; presente
     * nel mazzo
     *
     * @param card di cui si vuole sapere se
     *              si trova nel mazzo
     *
     * @return true se &egrave; presente, false
     * altrimenti
     */
    default boolean cardPresent(C card) {
        return getCardsDeck().contains(card);
    }

    /**
     * Metodo che permette di rimuovere
     * un numero di carte
     *
     * @param n numero di carte che si vogliono
     *          eliminare
     *
     * @return lista di carte che sono state rimosse
     */
    List<C> removeNCards(int n);

    /**
     * Metodo che permette di mischiare
     * il mazzo
     */
    void shuffleDeck();
}
