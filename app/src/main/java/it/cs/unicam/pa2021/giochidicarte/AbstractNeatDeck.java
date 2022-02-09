package it.cs.unicam.pa2021.giochidicarte;

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
public abstract class AbstractNeatDeck<C extends Card> implements NeatDeck<C> {

    private final List<C> carte;

    public AbstractNeatDeck() {
        this.carte = new ArrayList<>();
    }

    @Override
    public List<C> getCardsDeck() {
        return this.carte;
    }

    /**
     * @param pos posizione della carta
     *            che si vuole rimuovere
     *
     * @throws IndexOutOfBoundsException se l'indice inserito
     * &egrave; minore di 1 o maggiore del numero delle carte nel mazzo
     *
     * @return la carta che &egrave; stata rimossa
     */
    @Override
    public C removeCard(int pos){
        if (pos < 0 || pos > nCardsDeck() - 1) {
            throw new IndexOutOfBoundsException("Posizione non valida");
        }
        return getCardsDeck().remove(pos);
    }

    /**
     * @param carta carta che si vuole rimuovere
     *
     * @throws NullPointerException se non &egrave; stata
     * selezionata alcuna carta
     * @throws IllegalArgumentException se la carta selezionata
     * non &egrave; presente
     *
     * @return indice della carta che &egrave; stata
     * rimossa
     */
    @Override
    public int removeCard(C carta) {
        if (carta == null) { throw new NullPointerException("Carta non selezionata"); }
        if (!cardPresent(carta)) { throw new IllegalArgumentException("Carta non presente nel mazzo"); }
        getCardsDeck().remove(carta);
        return getCardsDeck().lastIndexOf(carta);
    }

    @Override
    public List<C> rimuoviNCarte(int n) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param carte lista contenenti le
     *              carte che si vogliono rimuovere
     *
     * @throws NullPointerException se la lista passata
     * &egrave; null o &egrave; vuota
     * @throws IllegalArgumentException se qualche carta nella
     * lista non è presente nel mazzo
     */
    @Override
    public void removeCards(List<C> carte) {
        if (carte == null || carte.size() == 0) { throw new NullPointerException("Carte non selezionate"); }
        List<C> listaControllo = getCardsDeck();
        int check = (int) carte.stream().filter(listaControllo::remove).count();
        if (check < carte.size()) { throw new IllegalArgumentException("Non tutte le carte nella lista sono presenti nel mazzo"); }
        getCardsDeck().removeAll(carte);
    }

    @Override
    public void aggiungiCarta(C carta) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param pos posizione nel mazzo in cui si
     *            vuole aggiungere la carta
     *
     * @param card carta che si vuole aggiungere
     * @throws IndexOutOfBoundsException se pos &egrave;
     * minore di 0 o maggiore del numero delle carte nel mazzo
     *
     */
    @Override
    public void addCard(int pos, C card) {
        if (pos < 0 || pos > nCardsDeck() - 1) { throw new IndexOutOfBoundsException("Posizione non valida"); }
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        if (cardPresent(card)) { throw new IllegalArgumentException("Carta gia presente nel mazzo"); }
        getCardsDeck().add(pos, card);
    }

    @Override
    public void addCards(List<C> carte) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addCards(int pos, List<C> cards) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shuffleDeck() {
        throw new UnsupportedOperationException();
    }
}
