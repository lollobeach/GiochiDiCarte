package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.field.AbstractField;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un campo
 * per giocare a Briscola
 */
public class BriscolaField extends AbstractField<TrevigianaCard> {

    public BriscolaField() {
        super();
    }

    /**
     * @param card carta che si vuole aggiungere
     *
     * @throws NullPointerException se non &egrave;
     * stata selezionata alcuna carta
     * @throws IllegalArgumentException se la carta
     * selezionata &egrave; gi&agrave; presente nel campo
     */
    @Override
    public void addCard(TrevigianaCard card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        if (this.getCards().stream().anyMatch(x -> x.equals(card))) {
            throw new IllegalArgumentException("Carta gia' presente nel campo!");
        }
        this.getCards().add(card);
    }

    /**
     * @param cards lista di carte
     *              che si vuole aggiungere
     *
     * @throws NullPointerException se cards &grave;
     * null o se la lista &egrave; vuota
     * @throws IllegalArgumentException se nella lista ci sono
     * carte duplicate o carte gi&agrave; presenti nel campo
     */
    @Override
    public void addCards(List<TrevigianaCard> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate!"); }
        List<TrevigianaCard> check = new ArrayList<>();
        if (!checkEqualsCard(cards)) { throw new IllegalArgumentException("Nella lista ci sono carte duplicate!"); }
        cards.forEach(x -> checkAdd(check,x));
        this.getCards().addAll(cards);
    }

    /**
     * Metodo che permette di rimuovere una
     * carta dal campo
     *
     * @param card carta che si vuole rimuovere
     *
     * @throws NullPointerException se la
     * carte inserita &egrave; null
     * @throws IllegalArgumentException se la
     * carte che si vuole eliminare non &egrave; presente
     * nel campo
     */
    @Override
    public void removeCard(TrevigianaCard card) {
        if (card == null) { throw new NullPointerException("La carta non e' stata selezionata"); }
        if (this.getCards().stream().filter(x -> x.equals(card)).findFirst().isEmpty()) {
            throw new IllegalArgumentException("La carta non e' presente nel campo");
        }
        this.getCards().remove(card);
    }

    /**
     * Metodo non supportato per questo gioco
     */
    @Override
    public void removeListCards(List<TrevigianaCard> cards) {
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo non supportato per questo gioco
     */
    @Override
    public List<TrevigianaCard> removeNCards(int nCards) {
        throw new UnsupportedOperationException();
    }

    private void checkAdd(List<TrevigianaCard> list, TrevigianaCard card) {
        if (this.getCards().stream().anyMatch(x -> x.equals(card))) {
            throw new IllegalArgumentException("Almeno una carta e' gia' presente nel campo");
        }
        list.add(card);
    }

    private boolean checkEqualsCard(List<TrevigianaCard> cards) {
        int check = 0;
        for (int i = 0; i < cards.size(); i++) {
            TrevigianaCard card = cards.get(i);
            for (int j = i+1; j < cards.size(); j++) {
                TrevigianaCard card1 = cards.get(j);
                if (card.equals(card1)) {
                    check = 1;
                    break;
                }
            }
        }
        return check == 0;
    }
}
