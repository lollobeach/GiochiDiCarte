package it.cs.unicam.pa2021.giochidicarte.field;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.deck.Deck;

public class DefaultFieldOneDeck<C extends Card<?>, D extends Deck<C>> extends SimpleField<C> implements FieldOneDeck<C,D> {

    private final D deck;

    public DefaultFieldOneDeck(D deck) {
        super();
        this.deck = deck;
    }

    @Override
    public D getDeck() {
        return this.deck;
    }
}
