package it.cs.unicam.pa2021.giochidicarte.match;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.deck.Deck;
import it.cs.unicam.pa2021.giochidicarte.field.Field;
import it.cs.unicam.pa2021.giochidicarte.player.Player;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Interfaccia che rappresenta una generica
 * partita di carte multigiocatore
 *
 * @param <P> tipo di giocatore che gioca la partita
 * @param <D> tipo di mazzo usato per la partita
 * @param <F> tipo di campo su cui si gioca la partita
 */
public interface MatchMultiplayer<P extends Player<? extends Card<?>>, D extends Deck<? extends Card<?>>, F extends Field<? extends Card<?>>> extends Match<D,F> {

    /**
     * Metodo che ritorna i giocatori
     * in gioco
     *
     * @return lista di giocatori in gioco
     */
    List<P> getPlayersInGame();

    /**
     * Metodo che ritorna il numero
     * di giocatori in gioco
     *
     * @return numero di giocatori in gioco
     */
    default int nPlayerInGame() {
        return getPlayersInGame().size();
    }

    /**
     * Metodo che ritorna un singolo
     * giocatore tra quelli in gioco
     *
     * @param id identificativo del giocatore
     *           in gioco
     *
     * @throws IndexOutOfBoundsException se
     * i &egrave; minore di 0 o maggiore del
     * numero di giocatori in gioco
     *
     * @return il giocatore nella posizione
     * scelta
     */
    default P getSinglePlayerInGameById(int id) {
        Optional<P> player = this.getPlayersInGame().stream().filter(x -> x.getId() == id).findFirst();
        if (player.isEmpty()) { throw new IllegalArgumentException("Giocatore non trovato!"); }
        return player.get();
    }

    /**
     * Metodo che ritorna il giocatore
     * vincitore della partita
     *
     * @param p predicato usato per
     *          determinare il giocatore
     *          vincitore
     *
     * @return giocatore che soddisfa il predicatp
     */
    P getWinnerPlayer(Predicate<P> p);

    /**
     * Metodo che ritorna tutti i giocatori
     * vincitori della partita
     *
     * @param p predicato usato per
     *          determinare i giocatori
     *          vincitori
     *
     * @return giocatori che soddisfano il predicato
     */
    default List<P> getWinnersPlayers(Predicate<P> p) {
        return getPlayersInGame().stream().filter(x -> x==getWinnerPlayer(p)).collect(Collectors.toList());
    }
}
