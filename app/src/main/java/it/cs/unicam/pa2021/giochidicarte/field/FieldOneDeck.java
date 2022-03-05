package it.cs.unicam.pa2021.giochidicarte.field;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.deck.Deck;

/**
 * Interfaccia che definisce un campo da gioco
 * su cui giocare le carte ed avente un singolo mazzo
 * di carte
 *
 * @param <C> tipo di carte che verranno giocate
 *           nel campo
 * @param <D> tipo di mazzo presente nel campo
 */
public interface FieldOneDeck<C extends Card<?>, D extends Deck<C>> extends Field<C> {

    /**
     * Metodo che ritorna un mazzo di carte
     * presente nel campo
     *
     * @return mazzo di carte
     */
    D getDeck();
}
