package it.cs.unicam.pa2021.giochidicarte.match;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.deck.Deck;
import it.cs.unicam.pa2021.giochidicarte.field.Field;

/**
 * Interfaccia che rappresenta una generica
 * partita di carte
 *
 * @param <D> tipo di mazzo usato per la partita
 * @param <F> tipo di campo su cui si gioca la partita
 */
public interface Match<D extends Deck<? extends Card<?>>, F extends Field<? extends Card<?>>> {

    /**
     * Metodo che ritorna il
     * mazzo usato per la partita
     *
     * @return mazzo usato
     */
    D getDeck();

    /**
     * Metodo che ritorna il campo
     * di gioco
     *
     * @return campo da gioco
     */
    F getField();

    /**
     * Metodo da utilizzare per
     * preparare il campo e i giocatori
     * per giocare la partita
     *
     */
    void initialize();

    /**
     * Metodo da utilizzare per
     * l'implementazione delle regole
     */
    void execute();
}
