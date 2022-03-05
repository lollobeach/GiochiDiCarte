package it.cs.unicam.pa2021.giochidicarte;

import java.util.List;

/**
 * Interfaccia che rappresenta
 * le azioni elementari di un giocatore
 *
 * @param <C> tipo di carte con cui il giocatore giocher&agrave;
 */
public interface Player<C extends Card<?>> extends PlayerHand<C> {

    /**
     * Metodo che ritorna le
     * carte possedute dal giocatore.
     *
     * Le carte in mano sono escluse
     *
     * @return lista di carte possedute
     */
    List<C> getCartePossedute();

    /**
     * Metodo che permette al giocatore
     * di giocare una carta
     *
     * @param carta indice della carta che si vuole giocare.
     *
     * @return la carta giocata
     */
    C giocaCarta(int carta);

    /**
     * Metodo che permette al giocatore
     * di giocare un certo numero di carte

     * @param carte array di indici per rappresentare le
     *              carte che si vogliono giocare
     */
    List<C> giocaCarte(int... carte);

    /**
     * Metodo che permette al giocatore
     * di pescare una carta
     *  @param from lista che indica da dove
     *             pescare le carte
     * @param carta indice della carta che si vuole
     */
    void pescaCarta(PileCards<C> from, int carta);

    /**
     * Metodo che permette al giocatore
     * di pescare un certo numero di carte
     *  @param from lista che indica da dove
     *             pescare le carte
     * @param carte numero di carte da pescare
     */
    void pescaCarte(PileCards<C> from, int carte);

    /**
     * Metodo che permette al giocatore
     * di pescare le carte in determinate
     * posizioni
     *  @param from lista che indica da dove pescare
     *             le carte
     * @param carte array di indici corrispondenti alle
     */
    void pescaCarte(PileCards<C> from, int... carte);
}
