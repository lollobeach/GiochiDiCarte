package it.cs.unicam.pa2021.giochidicarte.classicdeck;

import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicPair;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianeFigures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianeSeeds;

import java.util.List;

/**
 * Classe che rappresenta
 * un mazzo di 40 carte Trevigiane
 */
public class TrevigianeDeck extends ClassicDeck<TrevigianaCard> {

    public TrevigianeDeck() {
        super();
        for (int j = 1; j < 11; j++) {
            this.getCards().add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.COPPE),null));
            this.getCards().add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.DENARI),null));
            this.getCards().add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.SPADE), null));
            this.getCards().add(new TrevigianaCard(new ClassicPair<>(j, TrevigianeSeeds.BASTONI), null));
        }
        this.getCards().stream().filter(x -> x.getIndex() == 1).forEach(x -> x.setFigures(TrevigianeFigures.ASSE));
        this.getCards().stream().filter(x -> x.getIndex() == 8).forEach(x -> x.setFigures(TrevigianeFigures.FANTE));
        this.getCards().stream().filter(x -> x.getIndex() == 9).forEach(x -> x.setFigures(TrevigianeFigures.CAVALLO));
        this.getCards().stream().filter(x -> x.getIndex() == 10).forEach(x -> x.setFigures(TrevigianeFigures.RE));
    }

    /**
     * @param card carta che si vuole aggiungere
     *
     * @throws NullPointerException se la carta &egrave; null
     * @throws IllegalArgumentException se la carta &egrave;
     * gi&agrave; presente o se la sua aggiunta comporta il superamento
     * delle 40 carte all'interno del mazzo
     */
    @Override
    public void addCard(TrevigianaCard card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata!"); }
        if (this.nCards() == 40) { throw new UnsupportedOperationException("Non si possono aggiungere piu' di 40 carte!"); }
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
     *  superare il limite delle 40 carte
     *  - sono gi&agrave; presenti
     *  - presentano dei duplicati
     */
    @Override
    public void addCards(List<TrevigianaCard> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate!"); }
        if ((cards.size() + this.nCards()) > 40) { throw new IllegalArgumentException("Non si possono aggiungere piu' di 40 carte!"); }
        if (this.cardsArePresents(cards)) { throw new IllegalArgumentException("Carte gia presenti!"); }
        if (!checkEqualsCard(cards)) { throw new IllegalArgumentException("Non sono ammessi duplicati!"); }
        this.getCards().addAll(cards);
    }
    private boolean checkEqualsCard(List<TrevigianaCard> cards) {
        int check = 0;
        for (int i = 0; i < cards.size(); i++) {
            TrevigianaCard card = cards.get(i);
            for (int j = i+1; j < cards.size(); j++) {
                TrevigianaCard card1 = cards.get(j);
                if (card.equals(card1)) {
                    check = 1;
                    break;
                }
            }
        }
        return check == 0;
    }

}
