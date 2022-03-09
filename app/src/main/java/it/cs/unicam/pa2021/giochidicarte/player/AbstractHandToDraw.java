package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.PileCards;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHandToDraw<C extends Card<?>, L extends PileCards<C>> implements HandToDraw<C,L> {

    private final List<C> cardsInHand;

    public AbstractHandToDraw() {
        this.cardsInHand = new ArrayList<>();
    }

    @Override
    public List<C> getCards() {
        return this.cardsInHand;
    }

    @Override
    public void addCard(C card) { this.getCards().add(card); }

    @Override
    public void addCards(List<C> cards) { this.getCards().addAll(cards); }

    @Override
    public abstract C playCard(int pos);

    @Override
    public abstract C drawCard(L from, int pos);

    @Override
    public abstract List<C> drawCards(L from, int nCards);

    @Override
    public String toString() {
        return "AbstractHandToDraw{" +
                "cardsInHand=" + cardsInHand +
                '}';
    }
}