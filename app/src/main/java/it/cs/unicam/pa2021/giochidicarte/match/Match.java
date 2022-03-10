package it.cs.unicam.pa2021.giochidicarte.match;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.deck.Deck;
import it.cs.unicam.pa2021.giochidicarte.field.Field;

import java.io.IOException;

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
     * @return la partita inizializzata
     */
    Match<D,F> initialize();

    /**
     * Metodo da utilizzare per
     * l'implementazione delle regole
     */
    void execute() throws IOException;
}
