package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.PileCards;
import it.cs.unicam.pa2021.giochidicarte.field.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta che, tramite l'implementazione
 * dell'interfaccia Player, permette di andare a definire
 * un generico giocatore di carte.
 *
 * @param <C> tipo di carte con cui il giocatore giocher&agrave;
 */
public abstract class AbstractPlayerWithHand<C extends Card<?>> implements PlayerWithHand<C> {

    private static int idPlayer;

    private final int id = idPlayer;
    private final List<C> cardInHand;

    public AbstractPlayerWithHand() {
        idPlayer++;
        this.cardInHand = new ArrayList<>();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public List<C> getCards() { return this.cardInHand; }

    @Override
    public void playCard(C card, Field<C> field) { throw new UnsupportedOperationException(); }

    @Override
    public C playCard(int pos, Field<C> field) { throw new UnsupportedOperationException(); }

    @Override
    public void playCards(List<C> cards, Field<C> field) { throw new UnsupportedOperationException(); }

    @Override
    public List<C> playCards(Field<C> field, int... pos) { throw new UnsupportedOperationException(); }

    @Override
    public C drawCard(PileCards<C> from, int pos) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<C> drawCards(PileCards<C> from, int nCards) { throw new UnsupportedOperationException(); }

    @Override
    public void addCard(C card) {
        this.getCards().add(card);
    }

    @Override
    public void addCards(List<C> cards) {
        this.getCards().addAll(cards);
    }
}
