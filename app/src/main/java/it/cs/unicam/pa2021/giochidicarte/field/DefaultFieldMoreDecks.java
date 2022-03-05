package it.cs.unicam.pa2021.giochidicarte.field;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.deck.Deck;

import java.util.List;

public class DefaultFieldMoreDecks<C extends Card<?>, D extends Deck<C>> extends SimpleField<C> implements FieldMoreDecks<C,D> {

    private final List<D> decks;

    public DefaultFieldMoreDecks(List<D> decks) {
        super();
        this.decks = decks;
    }

    @Override
    public List<D> getDecks() {
        return this.decks;
    }
}
