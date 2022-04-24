package it.cs.unicam.pa2021.giochidicarte.classicdeck;

import it.cs.unicam.pa2021.giochidicarte.classiccards.ClassicCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.Figures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.Seeds;
import it.cs.unicam.pa2021.giochidicarte.deck.AbstractDeck;

import java.util.List;
import java.util.Optional;

/**
 * Classe astratta che rappresenta un classico
 * mazzo di carte contenente carte aventi un seme e una figura
 *
 * @param <C> tipo di carta classica contenuta nel mazzo
 */
public abstract class ClassicDeck<C extends ClassicCard<? extends Seeds, ? extends Figures>> extends AbstractDeck<C> {

    public ClassicDeck() {
        super();
    }

    @Override
    public abstract void addCard(C card);

    @Override
    public abstract void addCards(List<C> cards);

    /**
     * @param card carta di cui si
     *             vuole sapere la presenza
     *
     * @throws NullPointerException se la carta
     * &egrave; null
     *
     * @return true se la carta &egrave;
     * presente, false altrimenti
     */
    @Override
    public boolean cardIsPresent(C card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        Optional<C> check = this.getCards().stream().filter(x -> x.equals(card)).findFirst();
        return check.isPresent();
    }

    /**
     * Metodo che permette di rimuovere una
     * carta dal mazzo di carte
     *
     * @param card carta che si vuole rimuovere
     *
     * @throws NullPointerException se la
     * carte inserita &egrave; null
     * @throws IllegalArgumentException se la
     * carte che si vuole eliminare non &egrave; presente
     * nel mazzo
     */
    @Override
    public void removeCard(C card) {
        if (card == null) { throw new NullPointerException("Carta non selezionata"); }
        if (!this.cardIsPresent(card)) { throw new IllegalArgumentException("Carta non presente nel mazzo"); }
        this.getCards().remove(card);
    }

    /**
     * Metodo che permette di rimuovere una lista
     * di carte dal mazzo di carte
     *
     * @param cards lista contenenti le
     *              carte che si vogliono rimuovere
     *
     * @throws NullPointerException se la lista delle carte
     * &egrave; null o se &egrave; vuota
     * @throws IllegalArgumentException se il numero delle carte
     * selezionate supera il numero delle carte presenti nell'insieme
     * o se la lista:
     *  - contiene duplicati
     *  - contiene almeno una carta non presente nel mazzo
     */
    @Override
    public void removeListCards(List<C> cards) {
        if (cards == null || cards.size() == 0) { throw new NullPointerException("Carte non selezionate"); }
        if (cards.size() > nCards()) { throw new IllegalArgumentException("Il numero di carte selezionato e' maggiore del numero di carte presenti nel mazzo"); }
        if (!checkEqualsCard(cards)) { throw new IllegalArgumentException("Non sono ammessi i duplicati"); }
        int check = (int) cards.stream().filter(this::cardIsPresent).count();
        if (check != cards.size()) { throw new IllegalArgumentException("Tra le carte selezionate almeno una carta non e' presente nel mazzo"); }
        this.getCards().removeAll(cards);
    }

    private boolean checkEqualsCard(List<C> cards) {
        int check = 0;
        for (int i = 0; i < cards.size(); i++) {
            C card = cards.get(i);
            for (int j = i+1; j < cards.size(); j++) {
                C card1 = cards.get(j);
                if (card.equals(card1)) {
                    check = 1;
                    break;
                }
            }
        }
        return check == 0;
    }
}
