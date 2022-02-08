package it.cs.unicam.pa2021.giochidicarte;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;


/**
 * Interfaccia che rappresenta
 * le azioni elementari di un giocatore
 *
 * @param <C> tipo di carte con cui giocher&agrave; il giocatore
 */
public interface Player<C extends Card> {

    /**
     * Metodo che ritorna tutte le
     * carte in mano del giocatore
     *
     * @return lista di carte in mano
     */
    List<C> getCarteInMano();

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
     *
     * @throws IllegalArgumentException se tra gli indici
     * ci sono dei doppioni
     */
    default List<C> giocaCarte(int... carte) {
//        Set<Integer> check = new HashSet<>();
//        Arrays.stream(carte).forEach(check::add);
        List<Integer> listaControllo = Arrays.stream(carte).boxed().collect(Collectors.toList());
        int controllo = (int) listaControllo.stream().filter(i -> Collections.frequency(listaControllo,i) > 1).count();
        if (controllo > 0) { throw new IllegalArgumentException("Carte doppioni non valide"); }
        List<C> carteGiocate = new ArrayList<>();
        listaControllo.forEach(x -> carteGiocate.add(giocaCarta(x)));
        return carteGiocate;
    }

    /**
     * Metodo che permette al giocatore
     * di pescare una carta
     *
     * @param from
     * @param carta indice della carta che si vuole
 *              pescare
     */
    void pescaCarta(List<C> from, int carta);

    /**
     * Metodo che permette al giocatore
     * di pescare un certo numero di carte
     *
     * @param from lista che indica da dove pescare
     *             le carte
     * @param carte array di indici corrispondenti alle
     *              carte che si vogliono pescare
     *
     * @throws IllegalArgumentException se tra gli indici
     * ci sono dei doppioni
     */
    default void pescaCarte(List<C> from, int... carte) {
//        Set<Integer> check = new HashSet<>();
//        Arrays.stream(carte).forEach(check::add);
        List<Integer> listaControllo = Arrays.stream(carte).boxed().collect(Collectors.toList());
        int controllo = (int) listaControllo.stream().filter(i -> Collections.frequency(listaControllo,i) > 1).count();
        if (controllo > 0) { throw new IllegalArgumentException("Carte doppioni non valide"); }
        listaControllo.forEach(x -> pescaCarta(from,x));
    }
}
