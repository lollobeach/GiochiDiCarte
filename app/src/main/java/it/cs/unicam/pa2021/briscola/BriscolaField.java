package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.field.AbstractField;

import java.util.ArrayList;
import java.util.List;

public class BriscolaField extends AbstractField<TrevigianaCard> {

    public BriscolaField() {
        super();
    }

    @Override
    public void addCard(TrevigianaCard card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        if (this.getCards().stream().anyMatch(x -> x.equals(card))) {
            throw new IllegalArgumentException("Carta gia presente nel campo!");
        }
        this.getCards().add(card);
    }

    @Override
    public void addCards(List<TrevigianaCard> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate!"); }
        List<TrevigianaCard> check = new ArrayList<>();
        cards.forEach(x -> checkAdd(check,x));
        this.getCards().addAll(cards);
    }

    private void checkAdd(List<TrevigianaCard> list, TrevigianaCard card) {
        if (this.getCards().stream().anyMatch(x -> x.equals(card))) {
            throw new IllegalArgumentException("Carte duplicate non valide!");
        }
        list.add(card);
    }
}
