package it.cs.unicam.pa2021.giochidicarte.field;

import it.cs.unicam.pa2021.giochidicarte.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un
 * generico campo da gioco
 *
 * @param <C> tipo di carte che verranno giocate
 */
public abstract class AbstractField<C extends Card<?>> implements Field<C> {

    private final List<C> cardsInGame;

    public AbstractField() {
        this.cardsInGame = new ArrayList<>();
    }

    @Override
    public List<C> getCards() {
        return this.cardsInGame;
    }

    @Override
    public abstract void addCard(C card);

    @Override
    public abstract void addCards(List<C> cards);

    @Override
    public abstract List<C> removeNCards(int nCards);
}
