package it.cs.unicam.pa2021.giochidicarte;

import java.util.List;

public interface PileCards<C extends Card> {

    List<C> getCards();

    /**
     * Metodo che ritorna il numero
     * di carte nel mazzo
     *
     * @return intero rappresentante
     * il numero di carte nel mazzo
     */
    int nCards();

    /**
     * Metodo che permette di aggiungere una
     * carte nel mazzo
     *
     * @param card carta che si vuole aggiungere
     */
    void addCard(C card);

    /**
     * Metodo che permette di aggiungere una
     * lista di carte
     *
     * @param cards lista contenenti le carte che si vogliono
     *              aggiungere
     */
    void addCards(List<C> cards);

    /**
     * Metodo che permette di rimuovere una
     * carta
     *
     * @param card carta che si vuole rimuovere
     */
    void removeCard(C card);

    /**
     * Metodo che permette di rimuovere una lista
     * di carte
     *
     * @param cards lista contenenti le
     *              carte che si vogliono rimuovere
     */
    void removeCards(List<C> cards);
}
