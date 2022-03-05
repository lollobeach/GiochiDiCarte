package it.cs.unicam.pa2021.giochidicarte.field;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.PileCards;

/**
 * Interfaccia che definisce
 * un campo da gioco su cui
 * giocare le carte.
 * Le carte che vengono giocate vengono gestite
 * come un insieme tramite i metodi ereditati
 * dall'interfaccia PileCards
 *
 * @param <C> tipo di carte che verrano giocate
 *           nel campo
 */
public interface Field<C extends Card<?>> extends PileCards<C> {
}
