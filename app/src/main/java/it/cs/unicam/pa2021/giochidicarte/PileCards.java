package it.cs.unicam.pa2021.giochidicarte;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Interfaccia che permette
 * di gestire un generico
 * insieme di carte
 *
 * @param <C> tipo di carta a cui ci si
 *           riferisce
 */
public interface PileCards<C extends Card<?>> {

    /**
     * Metodo che ritorna le carte
     * presenti nell'insieme di carte
     *
     * @return lista di carte contenute
     * nell'insieme
     */
    List<C> getCards();

    /**
     * Metodo che ritorna il numero
     * di carte nell'insieme
     *
     * @return intero rappresentante
     * il numero di carte nell'insieme
     */
    default int nCards() {
        return getCards().size();
    }

    /**
     * Metodo che permette di aggiungere una
     * carta nell'insieme di carte
     *
     * @param card carta che si vuole aggiungere
     */
    void addCard(C card);

    /**
     * Metodo che permette di aggiungere una
     * lista di carte nell'insieme di carte
     *
     * @param cards lista contenenti le carte che si vogliono
     *              aggiungere
     */
    void addCards(List<C> cards);

    /**
     * Metodo che permette di rimuovere una
     * carta dall'insieme di carte
     *
     * @param card carta che si vuole rimuovere
     */
    void removeCard(C card);

    /**
     * Metodo che permette di rimuovere una lista
     * di carte dall'insieme di carte
     *
     * @param cards lista contenenti le
     *              carte che si vogliono rimuovere
     */
    void removeListCards(List<C> cards);

    /**
     * Metodo che permette di rimuovere
     * una carta in una posizione selezionata
     *
     * @param pos posizione da cui si vuole
     *            rimuovere la carta
     *
     * @throws IllegalArgumentException se
     * l'indice selezionato:
     *  - &egrave; minore di 0
     *  - &egrave; maggiore del numero delle
     *  carte presenti nell'insieme
     *
     * @return carta rimossa nella determinata
     * posizione
     */
    default C removeCardInPos(int pos) {
        if (pos < 0 || pos > nCards()-1) { throw new IllegalArgumentException("Posizione non valida"); }
        return getCards().remove(pos);
    }

    /**
     * Metodo che permette di rimuovere
     * un numero di carte a scelta
     *
     * @param nCards numero di carte
     *               da rimuovere
     *
     * @return lista di carte rimosse
     */
    List<C> removeNCards(int nCards);

    /**
     * Metodo che permette di rimuovere
     * una serie di carte scelte dalle
     * posizioni selezionate
     *
     * @param pos array di posizioni
     *            da cui si vogliono
     *            rimuovere le carte
     * @throws NullPointerException se l'array delle
     * posizioni &egrave; vuoto
     * @throws IllegalArgumentException se la lunghezza
     * dell'array supera il numero di carte presenti
     * nell'insieme e se i valori degli indici sono:
     *  - minori di 0
     *  - maggiori del numero di carte presenti nell'insieme
     *  - se sono duplicati
     *
     * @return lista di carte rimosse
     */
    default List<C> removeCardsInPositions(int... pos) {
        if (pos.length == 0) { throw new NullPointerException("Non e' stata selezionata alcuna carta"); }
        if (pos.length > nCards()) { throw new IllegalArgumentException("Il numero di indici presenti e' maggiore del numero delle carte nell'insieme"); }
        int check = (int) Arrays.stream(pos).filter(i -> i < 0 || i > nCards()-1).count();
        if (check > 0) { throw new IllegalArgumentException("Indici non validi"); }
        List<Integer> listPos = Arrays.stream(pos).boxed().collect(Collectors.toList());
        int checkDuplicate = (int) Arrays.stream(pos).filter(i -> Collections.frequency(listPos,i) > 1).count();
        if (checkDuplicate > 0) { throw new IllegalArgumentException("Indici duplicati non validi"); }
        List<C> cards = new ArrayList<>();
        Arrays.stream(pos).forEach(i -> cards.add(getCards().get(i)));
        getCards().removeAll(cards);
        return cards;
    }

    /**
     * Metodo che permette di controllare
     * la carta presente in una determinata
     * posizione
     *
     * @param pos posizione di cui si vuole
     *            sapere della carta
     *
     * @throws IllegalArgumentException se i numeri
     * inseriti nell'array sono minori di 0 o maggiori
     * della lunghezza dell'array
     *
     * @return carta presente nella posizione
     * selezionata
     */
    default C cardInPosition(int pos) {
        if (pos < 0 || pos > nCards()-1) { throw new IllegalArgumentException("Indice non valido"); }
        return getCards().get(pos);
    }

    /**
     * Metodo che permette di controllare
     * le carte presenti in determinate
     * posizioni
     *
     * @param pos array di posizioni di
     *            cui si vuole sapere delle
     *            carte
     *
     * @throws NullPointerException se l'array
     * delle posizioni &egrave; vuoto
     * @throws IllegalArgumentException se
     * il numero di elementi nell'array supera il numero
     * di carte presenti nell'insieme e gli indici
     * inseriti nell'array sono:
     *  - minori di 0
     *  - maggiori del numero di carte presenti nell'insieme
     *
     * @return lista di carte presenti
     * nelle posizioni scelte
     */
    default List<C> cardsInPositions(int... pos) {
        if (pos.length == 0) { throw new NullPointerException("Non e' stata selezionata alcuna carta"); }
        if (pos.length > nCards()) { throw new IllegalArgumentException("Il numero di indici presenti e' maggiore del numero delle carte nell'insieme"); }
        int check = (int) Arrays.stream(pos).filter(i -> i < 0 || i > nCards() - 1).count();
        if (check > 0) { throw new IllegalArgumentException("Indici non validi"); }
        List<C> cards = new ArrayList<>();
        Arrays.stream(pos).forEach(i -> cards.add(getCards().get(i)));
        return cards;
    }
}
