package it.cs.unicam.pa2021.giochidicarte.field;

import it.cs.unicam.pa2021.giochidicarte.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe che, implementando l'interfaccia
 * Field. Definisce un classico
 * campo da gioco avente una lista su cui salvare
 * le carte che vengono giocate
 *
 * @param <C> tipo di carte che verranno giocate
 */
public class SimpleField<C extends Card<?>> implements Field<C> {

    private final List<C> cardsInGame;

    public SimpleField() {
        this.cardsInGame = new ArrayList<>();
    }

    @Override
    public List<C> getCards() {
        return this.cardsInGame;
    }

    /**
     * @param card la carta che deve essere
     *              aggiunta
     *
     * @throws NullPointerException se la carta che
     * si vuole aggiungere &egrave; null
     * @throws IllegalArgumentException se la carta che si
     * vuole aggiungere &egrave; gi&agrave; presente
     */
    @Override
    public void addCard(C card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        if (this.cardsInGame.contains(card)) { throw new IllegalArgumentException("Carta già presente"); }
        this.cardsInGame.add(card);
    }

    /**
     * @param cards lista contenenti le carte che si vogliono
     *              aggiungere
     *
     * @throws NullPointerException se la lista delle carte
     * &egrave; null o se &egrave; vuota
     * @throws IllegalArgumentException se la lista:
     *  - contiene carte duplicate
     *  - contiene almeno una carta gi&agrave; presente nel mazzo
     */
    @Override
    public void addCards(List<C> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate"); }
        int check = (int) cards.stream().filter(i -> Collections.frequency(cards,i) > 1).count();
        if (check > 0) { throw new IllegalArgumentException("Non sono ammessi i duplicati"); }
        check = (int) cards.stream().filter(this.cardsInGame::contains).count();
        if (check > 0) { throw new IllegalArgumentException("Tra le carte selezionate almeno una carta è già presente"); }
        this.cardsInGame.addAll(cards);
    }
}
