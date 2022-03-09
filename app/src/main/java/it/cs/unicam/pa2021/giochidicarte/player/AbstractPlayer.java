package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;

/**
 * Classe astratta che
 * definisce un generico giocatore
 * di carte
 *
 * @param <C> carte utilizzate dal
 *           giocatore
 */
public abstract class AbstractPlayer<C extends Card<?>, H extends PlayerHand<C>> implements Player<C> {

    private static int id = 1;
    private final int idPlayer = id;
    private final H hand;

    public AbstractPlayer(H hand) {
        id++;
        this.hand = hand;
    }

    @Override
    public int getId() {
        return this.idPlayer;
    }

    @Override
    public H getHand() {
        return this.hand;
    }

    @Override
    public String toString() {
        return "AbstractPlayer{" +
                "idPlayer=" + idPlayer +
                ", hand=" + hand +
                '}';
    }
}
