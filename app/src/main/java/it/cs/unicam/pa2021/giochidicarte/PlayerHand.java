package it.cs.unicam.pa2021.giochidicarte;

import java.util.List;

public interface PlayerHand<C extends Card> extends PileCards<C> {

    /**
     * Metodo che ritorna tutte le
     * carte in mano del giocatore
     *
     * @return lista di carte in mano
     */
    List<C> getCarteInMano();

    @Override
    default int nCards() {
        return getCarteInMano().size();
    }

    @Override
    default List<C> getCards() {
        return getCarteInMano();
    }

    @Override
    default void addCard(C card) {
        getCarteInMano().add(card);
    }

    @Override
    default void addCards(List<C> cards) {
        getCarteInMano().addAll(cards);
    }

    @Override
    default void removeCard(C card) {
        getCarteInMano().remove(card);
    }

    @Override
    default void removeCards(List<C> cards) {
        getCarteInMano().removeAll(cards);
    }

    C removeCard(int pos);
}
