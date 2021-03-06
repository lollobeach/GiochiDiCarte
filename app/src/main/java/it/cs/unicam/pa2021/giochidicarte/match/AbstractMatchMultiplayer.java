package it.cs.unicam.pa2021.giochidicarte.match;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.deck.Deck;
import it.cs.unicam.pa2021.giochidicarte.field.Field;
import it.cs.unicam.pa2021.giochidicarte.player.Player;

import java.util.List;

/**
 * Classe astratta che permette di
 * definire una generica partita
 * di carte
 *
 * @param <P> tipo di giocatori in gioco
 * @param <D> tipo di mazzo usato per la partita
 * @param <F> tipo di campo su cui si gioca la partita
 */
public abstract class AbstractMatchMultiplayer<P extends Player<? extends Card<?>>, D extends Deck<? extends Card<?>>,F extends Field<? extends Card<?>>> implements MatchMultiplayer<P,D,F> {

    private List<P> players;
    private final D deck;
    private final F field;

    public AbstractMatchMultiplayer(List<P> players, D deck, F field) {
        this.players = players;
        this.deck = deck;
        this.field = field;
    }

    @Override
    public List<P> getPlayersInGame() {
        return this.players;
    }

    /**
     * Metodo che permette di modificare la lista
     * dei giocatori in gioco.
     * Pu&ograve; essere utile nel momento in cui
     * bisogna decidere l'ordine di gioco dei giocatori
     *
     * @param players lista nuova di giocatori
     */
    public void setPlayersInGame(List<P> players) { this.players = players; }

    @Override
    public D getDeck() {
        return this.deck;
    }

    @Override
    public F getField() {
        return this.field;
    }

    @Override
    public abstract void initialize();

    @Override
    public abstract void execute();
}
