package it.cs.unicam.pa2021.giochidicarte;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta che, tramite l'implementazione
 * dell'interfaccia Deck, permette di andare a
 * definire un generico mazzo, il quale pu&ograve;
 * essere specializzato nel momento in cui si estende
 * questa classe
 *
 * @param <C> tipo di carte contenute
 *           dal mazzo
 */
public abstract class AbstractDeck<C extends Card> implements Deck<C> {

    private final List<C> carte;

    public AbstractDeck() {
        this.carte = new ArrayList<>();
    }

    @Override
    public List<C> getCarteMazzo() {
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
    public C rimuoviCarta(int pos){
        if (pos < 0 || pos > nCarteMazzo() - 1) {
            throw new IndexOutOfBoundsException("Posizione non valida");
        }
        return getCarteMazzo().remove(pos);
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
    public int rimuoviCarta(C carta) {
        if (carta == null) { throw new NullPointerException("Carta non selezionata"); }
        if (!cartaPresente(carta)) { throw new IllegalArgumentException("Carta non presente nel mazzo"); }
        getCarteMazzo().remove(carta);
        return getCarteMazzo().lastIndexOf(carta);
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
    public void rimuoviCarte(List<C> carte) {
        if (carte == null || carte.size() == 0) { throw new NullPointerException("Carte non selezionate"); }
        List<C> listaControllo = getCarteMazzo();
        int check = (int) carte.stream().filter(listaControllo::remove).count();
        if (check < carte.size()) { throw new IllegalArgumentException("Non tutte le carte nella lista sono presenti nel mazzo"); }
        getCarteMazzo().removeAll(carte);
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
     * @throws IndexOutOfBoundsException se pos &egrave;
     * minore di 0 o maggiore del numero delle carte nel mazzo
     *
     * @param carta carta che si vuole aggiungere
     */
    @Override
    public void aggiungiCarta(int pos, C carta) {
        if (pos < 0 || pos > nCarteMazzo() - 1) { throw new IndexOutOfBoundsException("Posizione non valida"); }
        if (carta == null) { throw new NullPointerException("Carta non selezionata"); }
        if (cartaPresente(carta)) { throw new IllegalArgumentException("Carta gia presente nel mazzo"); }
        getCarteMazzo().add(pos, carta);
    }

    @Override
    public void aggiungiCarte(List<C> carte) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void aggiungiCarte(int pos, List<C> carte) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void mischiaMazzo() {
        throw new UnsupportedOperationException();
    }
}
