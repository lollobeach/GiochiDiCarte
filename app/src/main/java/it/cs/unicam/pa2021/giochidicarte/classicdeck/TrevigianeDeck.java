package it.cs.unicam.pa2021.giochidicarte.classicdeck;

import it.cs.unicam.pa2021.giochidicarte.deck.AbstractDeck;
import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicPair;
import it.cs.unicam.pa2021.giochidicarte.classiccards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.TrevigianeFigures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.TrevigianeSeeds;

import java.util.Collections;
import java.util.List;

/**
 * Classe che rappresenta
 * un mazzo di 40 carte Trevigiane
 */
public class TrevigianeDeck extends AbstractDeck<TrevigianaCard> {

    public TrevigianeDeck() {
        super();
        for (int j = 1; j < 11; j++) {
                super.getCards().add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.COPPE),null));
                super.getCards().add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.DENARI),null));
                super.getCards().add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.SPADE), null));
                super.getCards().add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.BASTONI), null));
        }
        super.getCards().stream().filter(x -> x.getIndex() == 1).forEach(x -> x.setFigures(TrevigianeFigures.ASSE));
        super.getCards().stream().filter(x -> x.getIndex() == 8).forEach(x -> x.setFigures(TrevigianeFigures.FANTE));
        super.getCards().stream().filter(x -> x.getIndex() == 9).forEach(x -> x.setFigures(TrevigianeFigures.CAVALLO));
        super.getCards().stream().filter(x -> x.getIndex() == 10).forEach(x -> x.setFigures(TrevigianeFigures.RE));
    }

    /**
     * @param card carta che si vuole aggiungere
     *
     * @throws NullPointerException se la carta &egrave; null
     * @throws IllegalArgumentException se la carta &egrave;
     * gi&agrave; presente
     */
    @Override
    public void addCard(TrevigianaCard card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata!"); }
        if (this.cardIsPresent(card)) { throw new IllegalArgumentException("Carta gia presente!"); }
        this.getCards().add(card);
    }

    /**
     * @param cards carte che si vogliono aggiungere
     *
     * @throws NullPointerException se cards &egrave; null
     * o non contiene alcuna carta
     * @throws IllegalArgumentException se le carte che si
     * vogliono aggiungere sono gi&agrave; presenti
     */
    @Override
    public void addCards(List<TrevigianaCard> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate!"); }
        if (this.cardsArePresents(cards)) { throw new IllegalArgumentException("Carte gia presenti!"); }
        int check = (int) cards.stream().filter(i -> Collections.frequency(cards,i) > 1).count();
        if (check > 0) { throw new IllegalArgumentException("Non sono ammessi duplicati!"); }
        this.getCards().addAll(cards);
    }
}
