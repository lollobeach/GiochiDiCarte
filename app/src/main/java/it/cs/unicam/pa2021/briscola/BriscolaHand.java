package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.PileCards;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.player.AbstractHandToDraw;

import java.util.List;

/**
 * Classe astratta che definisce la generica
 * mano di un giocatore di briscola
 */
public abstract class BriscolaHand extends AbstractHandToDraw<TrevigianaCard> {

    public BriscolaHand() {
        super();
    }

    @Override
    public void removeCard(TrevigianaCard card) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeListCards(List<TrevigianaCard> cards) {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract TrevigianaCard playCard();

    /**
     * @param from lista da cui pescare
     *             la carta
     * @param pos posizione della carta
     *            che si vuole pescare
     *
     * @throws NullPointerException se from
     * &egrave; null
     *
     * @return carta pescata
     */
    @Override
    public TrevigianaCard drawCard(PileCards<TrevigianaCard> from, int pos) {
        if (from == null) { throw new NullPointerException("Lista da cui pescare non selezionata!"); }
        TrevigianaCard card = from.cardInPosition(pos);
        this.addCard(from.removeCardInPos(pos));
        return card;
    }

    /**
     * @param from lista da cui pescare
     *             le carte
     * @param nCards numero di carte che si
     *               vogliono pescare
     *
     * @throws NullPointerException se from
     * &egrave; null
     *
     * @return lista di carte pescate
     */
    @Override
    public List<TrevigianaCard> drawCards(PileCards<TrevigianaCard> from, int nCards) {
        if (from == null) { throw new NullPointerException("Lista da cui pescare non selezionata!"); }
        List<TrevigianaCard> cards = from.removeNCards(nCards);
        this.addCards(cards);
        return cards;
    }
}
