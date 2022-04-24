package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.player.AbstractPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe astratta che definisce un
 * generico giocatore di briscola
 */
public abstract class BriscolaPlayer extends AbstractPlayer<TrevigianaCard, BriscolaHand> {

    private final String name;
    private final List<TrevigianaCard> wonCards;

    public BriscolaPlayer(String name, BriscolaHand hand) {
        super(hand);
        this.name = name;
        this.wonCards = new ArrayList<>();
    }

    /**
     * Metodo che ritorna il nome del
     * giocatore
     *
     * @return nome giocatore
     */
    public String getName() {
        return this.name;
    }

    /**
     * Metodo che ritorna le carte vinte
     * dal giocatore
     *
     * @return lista di carte vinte durante
     * la partita
     */
    public List<TrevigianaCard> getWonCards() { return this.wonCards; }

    /**
     * Metodo che permette al giocatore
     * di raccogliere le carte vinte durante
     * una mano
     *
     * @param cards array di carte che ha vinto
     */
    public void winCards(TrevigianaCard... cards) {
        Arrays.stream(cards).forEach(getWonCards()::add);
    }

}
