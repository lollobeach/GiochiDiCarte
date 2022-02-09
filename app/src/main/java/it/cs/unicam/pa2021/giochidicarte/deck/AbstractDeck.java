package it.cs.unicam.pa2021.giochidicarte.deck;

import it.cs.unicam.pa2021.giochidicarte.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta che, tramite l'implementazione
 * dell'interfaccia NeatDeck, permette di andare a
 * definire un generico mazz.
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

    @Override
    public List<C> removeNCards(int n) { throw new UnsupportedOperationException(); }

    @Override
    public List<C> removeNCardsFromPosition(int n, int pos) { throw new UnsupportedOperationException(); }

    @Override
    public void shuffleDeck() {
        throw new UnsupportedOperationException();
    }
}
