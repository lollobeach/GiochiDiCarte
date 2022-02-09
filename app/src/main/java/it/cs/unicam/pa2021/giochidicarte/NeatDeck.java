package it.cs.unicam.pa2021.giochidicarte;

import java.util.List;


/**
 * Interfaccia che definisce le
 * azioni elementari che si possono
 * compiere con un mazzo ordinato
 *
 * @param <C> tipo di carte che sono
 *           contenute nel mazzo
 */
public interface NeatDeck<C extends Card> extends MessyDeck<C> {

    /**
     * Metodo che ritorna una carta
     * in una determinata posizione
     * all'interno del mazzo
     *
     * @param pos posizione della
     *            carta nel mazzo
     *
     * @throws IndexOutOfBoundsException se
     * l'indice non coincide con un indice presente
     * nel mazzo
     *
     * @return la carta che si trova
     * in quella determinata posizione nel mazzo
     */
    default C getCard(int pos) {
        if (pos < 0 || pos > nCards() - 1) { throw new IndexOutOfBoundsException("Posizione non valida"); }
        return getCardsDeck().get(pos);
    }

    /**
     * Metodo che permette di selezionare
     * un indice nel mazzo per poi rimuovere
     * la carta corrispondente a quella posizione
     *
     * @param pos posizione della carta
     *            che si vuole rimuovere
     *
     * @return la carta che &egrave; stata rimossa
     */
    C removeCard(int pos);

    /**
     * Metodo che permette di aggiungere una
     * determinata carta in una posizione
     *  @param pos posizione nel mazzo in cui si
     *            vuole aggiungere la carta
     * @param card carta che si vuole aggiungere
     */
    void addCard(int pos, C card);

    /**
     * Metodo che permette di aggiungere una
     * lista di carte in una determinata posizione
     * all'interno del mazzo
     *  @param pos posizione nel mazzo in cui si
     *            vogliono aggiungere le carte
     * @param cards lista contenente le carte che si
     */
    void addCards(int pos, List<C> cards);
}