package it.cs.unicam.pa2021.giochidicarte.field;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.deck.Deck;

import java.util.List;

/**
 * Interfaccia che definisce un campo da gioco
 * su cui giocare le carte.
 * Questo campo &egrave; abilitato a contenere pi&ugrave;
 * di un mazzo di carte
 *
 * @param <C> tipo di carte che verranno giocate
 * @param <D> tipo di mazzi presenti nel campo
 */
public interface FieldMoreDecks<C extends Card<?>, D extends Deck<C>> extends Field<C> {

    List<D> getDecks();

    default int nDecks() {
        return getDecks().size();
    }

    default D getSingleDeck(int pos) {
        if (pos < 0 || pos > nDecks()-1) { throw new IndexOutOfBoundsException("Indice non valido"); }
        return getDecks().get(pos);
    }

    default D removeDeck(int pos) {
        if (pos < 0 || pos > nDecks()-1) { throw new IndexOutOfBoundsException("Indice non valido"); }
        return getDecks().remove(pos);
    }
}
