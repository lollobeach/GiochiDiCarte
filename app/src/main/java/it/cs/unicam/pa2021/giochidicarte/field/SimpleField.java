package it.cs.unicam.pa2021.giochidicarte.field;

import it.cs.unicam.pa2021.giochidicarte.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un
 * generico campo da gioco
 *
 * @param <C> tipo di carte che verranno giocate
 */
public abstract class SimpleField<C extends Card<?>> implements Field<C> {

    private final List<C> cardsInGame;

    public SimpleField() {
        this.cardsInGame = new ArrayList<>();
    }

    @Override
    public List<C> getCards() {
        return this.cardsInGame;
    }

    @Override
    public abstract void addCard(C card);

    /*

        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        if (this.cardsInGame.contains(card)) { throw new IllegalArgumentException("Carta già presente"); }
        this.cardsInGame.add(card);
     */

    @Override
    public abstract void addCards(List<C> cards);

    /*
            if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate"); }
        int check = (int) cards.stream().filter(i -> Collections.frequency(cards,i) > 1).count();
        if (check > 0) { throw new IllegalArgumentException("Non sono ammessi i duplicati"); }
        check = (int) cards.stream().filter(this.cardsInGame::contains).count();
        if (check > 0) { throw new IllegalArgumentException("Tra le carte selezionate almeno una carta è già presente"); }
        this.cardsInGame.addAll(cards);
     */
}
