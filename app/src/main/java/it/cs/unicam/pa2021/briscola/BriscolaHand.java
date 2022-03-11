package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.classicdeck.TrevigianeDeck;
import it.cs.unicam.pa2021.giochidicarte.player.AbstractHandToDraw;

import java.util.List;
import java.util.stream.IntStream;


public abstract class BriscolaHand extends AbstractHandToDraw<TrevigianaCard, TrevigianeDeck> {

    public BriscolaHand() {
        super();
    }

    @Override
    public abstract TrevigianaCard playCard();

    @Override
    public TrevigianaCard drawCard(TrevigianeDeck from, int pos) {
        if (pos < 0 || pos > from.nCards()-1) { throw new IllegalArgumentException("Indice non valido!"); }
        TrevigianaCard card = from.cardInPosition(pos);
        if (this.getCards().stream().anyMatch(x -> x.equals(card))) {
            throw new IllegalArgumentException("Carta gia presente in mano!");
        }
        this.addCard(this.removeCard(pos));
        return card;
    }

    @Override
    public List<TrevigianaCard> drawCards(TrevigianeDeck from, int nCards) {
        int check = (int) IntStream.range(0,nCards).filter(x -> this.getCards().get(x).equals(from.cardInPosition(x))).count();
        if (check > 0) { throw new IllegalArgumentException("Le carte da pescare sono gia presenti nella mano!"); }
        List<TrevigianaCard> cards = from.removeNCardsFromTop(nCards);
        this.addCards(cards);
        return cards;
    }
}
