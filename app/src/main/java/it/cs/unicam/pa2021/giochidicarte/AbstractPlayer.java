package it.cs.unicam.pa2021.giochidicarte;

import java.util.List;

/**
 * Classe astratta che, tramite l'implementazione
 * dell'interfaccia Player, permette di andare a definire
 * un generico giocatore di carte.
 *
 * @param <C> tipo di carte con cui il giocatore giocher&agrave;
 */
public abstract class AbstractPlayer<C extends Card> implements Player<C> {

    private static int idPlayer;

    private final int id = idPlayer;

    public AbstractPlayer() {
        idPlayer++;
    }

    public int getIdPlayer() {
        return this.id;
    }

    @Override
    public List<C> getCarteInMano() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<C> getCartePossedute() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract C giocaCarta(int carta);

    @Override
    public List<C> giocaCarte(int... carte) { throw new UnsupportedOperationException(); }

    @Override
    public void pescaCarta(PileCards<C> from, int carta) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void pescaCarte(PileCards<C> from, int carte) { throw new UnsupportedOperationException(); }

    @Override
    public void pescaCarte(PileCards<C> from, int... carte) { throw new UnsupportedOperationException(); }

    @Override
    public String toString() {
        return "AbstractPlayer{" +
                "id=" + id +
                '}';
    }
}
