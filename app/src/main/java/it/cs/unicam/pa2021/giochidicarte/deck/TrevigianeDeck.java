package it.cs.unicam.pa2021.giochidicarte.deck;

import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicPair;
import it.cs.unicam.pa2021.giochidicarte.classiccards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.TrevigianeFigures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.TrevigianeSeeds;

import java.util.ArrayList;
import java.util.List;

public class TrevigianeDeck implements Deck<TrevigianaCard> {

    private final List<TrevigianaCard> cards;

    public TrevigianeDeck() {
        cards = new ArrayList<>();
        for (int j = 1; j < 11; j++) {
                cards.add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.COPPE),null));
                cards.add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.DENARI),null));
                cards.add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.SPADE), null));
                cards.add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.BASTONI), null));
        }
        cards.stream().filter(x -> x.getIndex() == 1).forEach(x -> x.setFigures(TrevigianeFigures.ASSE));
        cards.stream().filter(x -> x.getIndex() == 8).forEach(x -> x.setFigures(TrevigianeFigures.FANTE));
        cards.stream().filter(x -> x.getIndex() == 9).forEach(x -> x.setFigures(TrevigianeFigures.CAVALLO));
        cards.stream().filter(x -> x.getIndex() == 10).forEach(x -> x.setFigures(TrevigianeFigures.RE));
    }

    @Override
    public List<TrevigianaCard> getCards() {
        return this.cards;
    }

    @Override
    public void addCard(TrevigianaCard card) {

    }

    @Override
    public void addCards(List<TrevigianaCard> cards) {

    }

    @Override
    public List<TrevigianaCard> removeNCards(int n) {
        return null;
    }

    @Override
    public List<TrevigianaCard> removeNCardsFromPosition(int n, int pos) {
        return null;
    }

    @Override
    public void shuffleDeck() {

    }
}
