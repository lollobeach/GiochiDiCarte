//package it.cs.unicam.pa2021.giochidicarte;
//
//import it.cs.unicam.pa2021.giochidicarte.field.Field;
//import it.cs.unicam.pa2021.giochidicarte.player.PlayerWithCardsInHand;
//
//import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
///**
// * Interfaccia che rappresenta una generica
// * partita di carte
// *
// * @param <P> tipo di giocatore che gioca la partita
// * @param <D> tipo di mazzo usato per la partita
// * @param <F> tipo di campo su cui si gioca la partita
// */
//public interface Match<P extends PlayerWithCardsInHand<? extends Card>,D extends NeatDeck<? extends Card>,F extends Field<? extends Card>> {
//
//    /**
//     * Metodo che ritorna i giocatori
//     * in gioco
//     *
//     * @return lista di giocatori in gioco
//     */
//    List<P> getPlayersInGame();
//
//    /**
//     * Metodo che ritorna il numero
//     * di giocatori in gioco
//     *
//     * @return numero di giocatori in gioco
//     */
//    default int nPlayerInGame() {
//        return getPlayersInGame().size();
//    }
//
//    /**
//     * Metodo che ritorna un singolo
//     * giocatore tra quelli in gioco
//     *
//     * @param i posizione del giocatore
//     *          nella lista
//     *
//     * @throws IndexOutOfBoundsException se
//     * i &egrave; minore di 0 o maggiore del
//     * numero di giocatori in gioco
//     *
//     * @return il giocatore nella posizione
//     * scelta
//     */
//    default P getSinglePlayerInGame(int i) {
//        if (i < 0 || i > nPlayerInGame() - 1) {
//            throw new IndexOutOfBoundsException("Indice non valido");
//        }
//        return getPlayersInGame().get(i);
//    }
//
//    /**
//     * Metodo che ritorna
//     * i giocatori eliminati
//     * dal gioco
//     *
//     * @return lista di giocatori
//     * eliminati
//     */
//    List<P> getPlayersOutGame();
//
//    /**
//     * Metodo che ritorna il numero
//     * di giocatori eliminati
//     *
//     * @return numero di giocatori
//     * eliminati
//     */
//    default int nPlayerOutGame() {
//        return getPlayersOutGame().size();
//    }
//
//    /**
//     * Metodo che ritorna un singolo giocatore
//     * eliminato dal gioco
//     *
//     * @param i posizione del giocatore nella
//     *          lista
//     *
//     * @throws IndexOutOfBoundsException se
//     * i &egrave; minore di 0 o maggiore del numero
//     * di giocatori eliminati
//     *
//     * @return il giocatore nella posizione scelta
//     */
//    default P getSinglePlayerOutGame(int i) {
//        if (i < 0 || i > nPlayerOutGame() - 1) {
//            throw new IndexOutOfBoundsException("Indice non valido");
//        }
//        return getPlayersOutGame().get(i);
//    }
//
//    /**
//     * Metodo che ritorna il giocatore
//     * vincitore della partita
//     *
//     * @param p predicato usato per
//     *          determinare il giocatore
//     *          vincitore
//     *
//     * @return giocatore che soddisfa il predicatp
//     */
//    P getWinnerPlayer(Predicate<P> p);
//
//    /**
//     * Metodo che ritorna tutti i giocatori
//     * vincitori della partita
//     *
//     * @param p predicato usato per
//     *          determinare i giocatori
//     *          vincitori
//     *
//     * @return giocatori che soddisfano il predicato
//     */
//    default List<P> getWinnersPlayers(Predicate<P> p) {
//        return getPlayersInGame().stream().filter(x -> x==getWinnerPlayer(p)).collect(Collectors.toList());
//    }
//
//    /**
//     * Metodo che ritorna la lista
//     * di mazzi usati nel gioco
//     *
//     * @return la lista di mazzi
//     */
//    List<D> getDeck();
//
//    /**
//     * Metodo che ritorna il numero di
//     * mazzi usati per il gioco
//     *
//     * @return numero di mazzi usati
//     */
//    default int nDeck() {
//        return getDeck().size();
//    }
//
//    /**
//     * Metodo che ritorna un singolo mazzo
//     * tra quelli in gioco
//     *
//     * @param i posizione del mazzo
//     *          nella lista
//     *
//     * @return mazzo nella posizione scelta
//     */
//    default D getSingleDeck(int i) {
//        if (i < 0 || i > nDeck() - 1) {
//            throw new IndexOutOfBoundsException("Indice non valid");
//        }
//        return getDeck().get(i);
//    }
//
//    /**
//     * Metodo che ritorna il campo
//     * di gioco
//     *
//     * @return campo da gioco
//     */
//    F getField();
//
//    /**
//     * Metodo da utilizzare per
//     * preparare il campo e i giocatori
//     * per giocare la partita
//     */
//    void initialize();
//
//    /**
//     * Metodo da utilizzare per
//     * l'implementazione delle regole
//     */
//    void execute();
//}
