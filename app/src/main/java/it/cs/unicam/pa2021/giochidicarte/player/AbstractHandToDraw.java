package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.PileCards;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta che definisce un
 * insieme generico di carte possedute
 * dalla mano di un giocatore
 *
 * @param <C> tipo di carte che il giocatore
 *           ha in mano
 */
public abstract class AbstractHandToDraw<C extends Card<?>> implements HandToDraw<C> {

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
    public List<C> removeCards(int nCards) {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract C playCard();

    @Override
    public abstract C drawCard(PileCards<C> from, int pos);

    @Override
    public abstract List<C> drawCards(PileCards<C> from, int nCards);

    @Override
    public String toString() {
        return "AbstractHandToDraw{" +
                "cardsInHand=" + cardsInHand +
                '}';
    }
}
