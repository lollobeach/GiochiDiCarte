package it.cs.unicam.pa2021.giochidicarte.deck;

import it.cs.unicam.pa2021.giochidicarte.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
     * @param card carta di cui si
     *             vuole sapere la presenza
     *
     * @throws NullPointerException se la carta
     * &egrave; null
     *
     * @return true se la carta &egrave;
     * presente, false altrimenti
     */
    @Override
    public boolean cardIsPresent(C card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        Optional<C> check = this.getCards().stream().filter(x -> x.equals(card)).findFirst();
        return check.isEmpty();
    }

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
        int count = 0;
        for (C card: cards) {
            if (this.cardIsPresent(card)) { count++; }
        }
        return count == cards.size();
    }

    private List<C> removal(List<C> cards, int n, int j, Direction dir) {
        List<C> removed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dir.equals(Direction.SU)) {
                removed.add(cards.remove(j));
                j--;
                if (j < 0) { break; }
            }
            if (dir.equals(Direction.GIU)) {
                try {
                    removed.add(cards.remove(j));
                } catch (IndexOutOfBoundsException e) { break; }
            }
        }
        return removed;
    }

    /**
     * @param n numero di carte che si vuole
     *          rimuovere
     * @param pos indice di partenza per la rimozione
     *            delle carte
     * @param dir direzione da seguire per la rimozione
     *            delle carte
     *
     * @throws IllegalArgumentException se n &egrave;:
     * - minore di 0
     * - maggiore del numero di carte presenti nel mazzo;
     * oppure se pos &egrave;:
     * - minore di 0
     * - maggiore dell'ultimo indice della lista
     * @throws NullPointerException se dir &egrave; null
     *
     * @return lista di carte rimosse
     */
    @Override
    public List<C> removeNCardsFromPosition(int n, int pos, Direction dir) {
        if (n <= 0 || n > nCards()) { throw new IllegalArgumentException("Numero non valido"); }
        if (pos < 0 || pos > nCards() - 1) { throw new IllegalArgumentException("Posizione non valida"); }
        if (dir == null) { throw new NullPointerException("Direction non inserita"); }
        List<C> removed = new ArrayList<>();
        if (dir.equals(Direction.SU)) { removed = removal(getCards(), n, pos, Direction.SU); }
        if (dir.equals(Direction.GIU)) { removed = removal(getCards(), n, pos, Direction.GIU); }
        return removed;
    }

    @Override
    public List<C> removeNCardsFromBottom(int n) { return this.removeNCardsFromPosition(n, getCards().size()-1, Direction.SU); }

    @Override
    public List<C> removeNCardsFromTop(int n) { return this.removeNCardsFromPosition(n, 0, Direction.GIU); }

    @Override
    public void shuffleDeck(int n) {
        if (n <= 0) { throw new IllegalArgumentException("Numero non valido"); }
        IntStream.range(0,n).forEach(x -> Collections.shuffle(getCards()));
    }
}
