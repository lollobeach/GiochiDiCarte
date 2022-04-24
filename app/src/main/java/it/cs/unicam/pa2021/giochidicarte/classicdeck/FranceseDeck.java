package it.cs.unicam.pa2021.giochidicarte.classicdeck;

import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicPair;
import it.cs.unicam.pa2021.giochidicarte.classiccards.frenchcards.FrenchCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.frenchcards.FrenchFigures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.frenchcards.FrenchSeeds;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Classe che rappresenta
 * un mazzo di 54 carte Francesi
 */
public class FranceseDeck extends ClassicDeck<FrenchCard> {

    public FranceseDeck() {
        super();
        IntStream.range(0,2).forEach(x -> this.getCards().add(new FrenchCard(new ClassicPair<>(0,null), FrenchFigures.JOLLY)));
        for (int i = 1; i < 14; i++) {
            this.getCards().add(new FrenchCard(new ClassicPair<>(i, FrenchSeeds.CUORI), null));
            this.getCards().add(new FrenchCard(new ClassicPair<>(i, FrenchSeeds.PICCHE), null));
            this.getCards().add(new FrenchCard(new ClassicPair<>(i, FrenchSeeds.QUADRI), null));
            this.getCards().add(new FrenchCard(new ClassicPair<>(i, FrenchSeeds.FIORI), null));
        }
        this.getCards().stream().filter(x -> x.getIndex() == 1).forEach(x -> x.setFigures(FrenchFigures.ASSE));
        this.getCards().stream().filter(x -> x.getIndex() == 11).forEach(x -> x.setFigures(FrenchFigures.J));
        this.getCards().stream().filter(x -> x.getIndex() == 12).forEach(x -> x.setFigures(FrenchFigures.Q));
        this.getCards().stream().filter(x -> x.getIndex() == 13).forEach(x -> x.setFigures(FrenchFigures.K));
    }

    /**
     * @param card carta che si vuole aggiungere
     *
     * @throws NullPointerException se la carta &egrave; null
     * @throws IllegalArgumentException se la carta &egrave;
     * gi&agrave; presente o se la sua aggiunta comporta il superamento
     * delle 54 carte all'interno del mazzo
     */
    @Override
    public void addCard(FrenchCard card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata!"); }
        if (this.nCards() == 54) { throw new UnsupportedOperationException("Non si possono aggiungere piu' di 54 carte!"); }
        if (this.cardIsPresent(card)) { throw new IllegalArgumentException("Carta gia presente!"); }
        this.getCards().add(card);
    }

    /**
     * @param cards carte che si vogliono aggiungere
     *
     * @throws NullPointerException se cards &egrave; null
     * o non contiene alcuna carta
     * @throws IllegalArgumentException se le carte che si
     * vogliono aggiungere:
     *  - sommate alle carte presenti nel mazzo fanno
     *  superare il limite delle 54 carte
     *  - sono gi&agrave; presenti
     *  - presentano dei duplicati
     */
    @Override
    public void addCards(List<FrenchCard> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate!"); }
        if ((cards.size() + this.nCards()) > 54) { throw new IllegalArgumentException("Non si possono aggiungere piu' di 40 carte!"); }
        if (this.cardsArePresents(cards)) { throw new IllegalArgumentException("Carte gia presenti!"); }
        if (!checkEqualsCard(cards)) { throw new IllegalArgumentException("Non sono ammessi duplicati!"); }
        this.getCards().addAll(cards);
    }

    private boolean checkEqualsCard(List<FrenchCard> cards) {
        int check = 0;
        for (int i = 0; i < cards.size(); i++) {
            FrenchCard card = cards.get(i);
            for (int j = i+1; j < cards.size(); j++) {
                FrenchCard card1 = cards.get(j);
                if (card.equals(card1)) {
                    check = 1;
                    break;
                }
            }
        }
        return check == 0;
    }
}
