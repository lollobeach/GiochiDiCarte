package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.player.AbstractPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BriscolaPlayer extends AbstractPlayer<TrevigianaCard, BriscolaHand> {

    private final String name;
    private final List<TrevigianaCard> wonCards;

    public BriscolaPlayer(String name, BriscolaHand hand) {
        super(hand);
        this.name = name;
        this.wonCards = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<TrevigianaCard> getWonCards() { return this.wonCards; }

    public void winCards(TrevigianaCard... cards) {
        Arrays.stream(cards).forEach(getWonCards()::add);
    }

}
