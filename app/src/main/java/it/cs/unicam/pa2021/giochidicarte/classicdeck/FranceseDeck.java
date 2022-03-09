package it.cs.unicam.pa2021.giochidicarte.classicdeck;

import it.cs.unicam.pa2021.giochidicarte.deck.AbstractDeck;
import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicPair;
import it.cs.unicam.pa2021.giochidicarte.classiccards.frenchcards.FranceseCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.frenchcards.FrenchFigures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.frenchcards.FrenchSeeds;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Classe che rappresenta
 * un mazzo di 54 carte Francesi
 */
public class FranceseDeck extends AbstractDeck<FranceseCard> {

    public FranceseDeck() {
        super();
        IntStream.range(0,2).forEach(x -> super.getCards().add(new FranceseCard(null, FrenchFigures.JOLLY)));
        for (int i = 1; i < 14; i++) {
            super.getCards().add(new FranceseCard(new ClassicPair<>(i, FrenchSeeds.CUORI), null));
            super.getCards().add(new FranceseCard(new ClassicPair<>(i, FrenchSeeds.PICCHE), null));
            super.getCards().add(new FranceseCard(new ClassicPair<>(i, FrenchSeeds.QUADRI), null));
            super.getCards().add(new FranceseCard(new ClassicPair<>(i, FrenchSeeds.FIORI), null));
        }
        super.getCards().stream().filter(x -> x.getIndex() == 1).forEach(x -> x.setFigures(FrenchFigures.ASSE));
        super.getCards().stream().filter(x -> x.getIndex() == 11).forEach(x -> x.setFigures(FrenchFigures.J));
        super.getCards().stream().filter(x -> x.getIndex() == 12).forEach(x -> x.setFigures(FrenchFigures.Q));
        super.getCards().stream().filter(x -> x.getIndex() == 13).forEach(x -> x.setFigures(FrenchFigures.K));
    }

    /**
     * @param card carta che si vuole aggiungere
     *
     * @throws NullPointerException se card &egrave; null
     * @throws IllegalArgumentException se le carta &egrave;
     * gi&agrave; presente
     */
    @Override
    public void addCard(FranceseCard card) {
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
    public void addCards(List<FranceseCard> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate!"); }
        if (this.cardsArePresents(cards)) { throw new IllegalArgumentException("Carte gia presenti!"); }
        int check = (int) cards.stream().filter(i -> Collections.frequency(cards,i) > 1).count();
        if (check > 0) { throw new IllegalArgumentException("Non sono ammessi duplicati!"); }
        this.getCards().addAll(cards);
    }
}
