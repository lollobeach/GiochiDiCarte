package it.cs.unicam.pa2021.giochidicarte.player;

import it.cs.unicam.pa2021.giochidicarte.Card;
import it.cs.unicam.pa2021.giochidicarte.field.Field;

import java.util.List;

/**
 * Interfaccia che definisce
 * un giocatore il quale non prevede
 * il possesso di carte in mano
 *
 * @param <C> tipo di carte giocate
 *           dal giocatore
 */
public interface PlayerWithoutHand<C extends Card<?>> {

    /**
     * Metodo che ritorna l'id
     * del giocatore
     *
     * @return id del giocatore
     */
    int getId();

    /**
     * Metodo che permette di
     * selezionare e giocare una
     * carta
     *
     * @param card carta da giocare
     * @param field campo su cui giocare la carta
     */
    void playCard(C card, Field<C> field);

    /**
     * Metodo che permette di
     * selezionare, tramite la
     * posizione in cui si trova,
     * una carta da giocare
     *
     * @param pos posizione della
     *            carta che si vuole
     *            giocare
     * @param field campo su cui giocare la carta
     *
     * @return la carta giocata
     */
    C playCard(int pos, Field<C> field);

    /**
     * Metodo che permette di
     * selezionare e giocare
     * una serie di carte
     *
     * @param cards carte da giocare
     * @param field campo su cui giocare le carte
     */
    void playCards(List<C> cards, Field<C> field);

    /**
     * Metodo che permette di
     * selezionare, tramite le
     * posizioni in cui si trovano,
     * le carte da giocare
     *
     * @param field campo su cui giocare le carte
     * @param pos array di posizioni
     *            delle carte che si
     *            vogliono giocare
     *
     * @return lista di carte giocate
     */
    List<C> playCards(Field<C> field, int... pos);
}