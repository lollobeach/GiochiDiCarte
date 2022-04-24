package it.cs.unicam.pa2021.giochidicarte.deck;

import it.cs.unicam.pa2021.giochidicarte.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Classe astratta che rappresenta
 * un generico mazzo da gioco
 *
 * @param <C> tipo di carte contenute
 *           dal mazzo
 */
public abstract class AbstractDeck<C extends Card<?>> implements Deck<C> {

    private final List<C> carte;

    public AbstractDeck() {
        this.carte = new ArrayList<>();
    }

    @Override
    public List<C> getCards() {
        return this.carte;
    }

    @Override
    public abstract void addCard(C card);

    @Override
    public abstract void addCards(List<C> cards);

    /**
     * Il metodo, di base, rimuove le carte
     * dalla cima del mazzo.
     * E' possibile modificarne il comportamento
     * sovrascrivendolo
     *
     * @param nCards numero di carte
     *               da rimuovere
     *
     * @throws IllegalArgumentException se
     * nCards &egrave;
     *  - uguale a 0
     *  - maggiore del numero delle carte
     *  presenti nel mazzo
     *
     * @return lista di carte rimosse
     */
    @Override
    public List<C> removeNCards(int nCards) {
        if (nCards <= 0 || nCards > this.nCards()) { throw new IllegalArgumentException("Numero di carte non valido!"); }
        List<C> removed = new ArrayList<>();
        for (int i = 0; i < nCards; i++) {
            try {
                removed.add(this.getCards().remove(0));
            } catch (IndexOutOfBoundsException e) { break; }
        }
        return removed;
    }

    @Override
    public abstract boolean cardIsPresent(C card);

    /**
     * @param cards carte che si vogliono
     *              controllare
     *
     * @throws NullPointerException se la lista
     * &egrave; vuota o se non contiene alcuna carta
     *
     * @return true se tutte le carte
     * selezionate sono presenti, false altrimenti
     */
    @Override
    public boolean cardsArePresents(List<C> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate"); }
        int count = (int) cards.stream().filter(this::cardIsPresent).count();
        return count == cards.size();
    }

    @Override
    public void shuffleDeck(int n) {
        if (n <= 0) { throw new IllegalArgumentException("Numero non valido"); }
        IntStream.range(0,n).forEach(x -> Collections.shuffle(getCards()));
    }
}
