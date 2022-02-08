package it.cs.unicam.pa2021.giochidicarte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interfaccia che definisce
 * un tipico campo da gioco per le carte
 *
 * @param <C> tipo di carte che verrano giocate
 *           nel campo
 */
public interface Field<C extends Card> {

    /**
     * Metodo che ritorna una
     * lista di carte in gioco
     *
     * @return lista contenente le carte in
     * gioco
     */
    List<C> getCarteInGioco();

    /**
     * Metodo che ritorna il numero
     * di carte in gioco
     *
     * @return numero intero delle carte in gioco
     */
    default int nCarteInGioco() {
        return getCarteInGioco().size();
    }

    /**
     * Metodo che permette di aggiungere
     * una carta nel gioco
     *
     * @param carta la carta che deve essere
     *              aggiunta
     */
    void aggiungiCartaInGioco(C carta);

    /**
     * Metodo che permette un certo numero
     * di carte in gioco
     *
     * @param carte le carte che devono essere
     *              aggiunte
     *
     * @throws NullPointerException se l'array delle
     * carte &egrave; vuoto
     * @throws IllegalArgumentException se l'array contiene
     * carte duplicate o se il campo possiede gi&agrave; quelle carte
     */
    @SuppressWarnings("unchecked")
    default void aggiungiCarteInGioco(C... carte) {
        if (carte.length == 0) { throw new NullPointerException("Carte non selezionate"); }
        List<C> listaControllo = Arrays.stream(carte).collect(Collectors.toList());
        int check = (int) listaControllo.stream().filter(i -> Collections.frequency(listaControllo,i) > 1).count();
        if (check > 0) { throw new IllegalArgumentException("Carte duplicate"); }
        if (getCarteInGioco().containsAll(listaControllo)) { throw new IllegalArgumentException("Carte già possedute"); }
        Arrays.stream(carte).forEach(this::aggiungiCartaInGioco);
    }

    /**
     * Metodo che permette di rimuovere
     * una carta dal gioco
     *
     * @param carta carta da rimuovere
     */
    void rimuoviCartaInGioco(C carta);

    /**
     * Metodo che permette di rimuovere
     * un certo numero di carte dal gioco
     *
     * @param carte carte da rimuovere
     *
     * @throws NullPointerException se l'array
     * delle carte &egrave; vuoto
     * @throws IllegalArgumentException se l'array contiene
     * carte duplicate o se non sono presenti nel mazzo
     */
    @SuppressWarnings("unchecked")
    default void rimuoviCarteInGioco(C... carte) {
        if (carte.length == 0) { throw new NullPointerException("Carte non selezionate"); }
        List<C> listaControllo = Arrays.stream(carte).collect(Collectors.toList());
        int check = (int) listaControllo.stream().filter(i -> Collections.frequency(listaControllo,i) > 1).count();
        if (check > 0) { throw new IllegalArgumentException("Carte duplicate"); }
        if (!getCarteInGioco().containsAll(listaControllo)) { throw new IllegalArgumentException("Carte già possedute"); }
        Arrays.stream(carte).forEach(this::rimuoviCarteInGioco);
    }

    /**
     * Metodo che permette di rimuovere
     * una carta dal gioco selezionando la
     * posizione di essa nella lista di carte
     * in gioco
     *
     * @param pos posizione della carta nella lista
     *            delle carte in gioco
     *
     * @return la carta rimossa
     */
    C rimuoviCartaInGioco(int pos);

    /**
     * Metodo che permette di rimuovere
     * un numero arbitrario di carte dal gioco
     * selezionando le posizioni di esse nella lista
     * di carte in gioco
     *
     * @param pos posizioni delle carte nella lista
     *            delle carte in gioco
     *
     * @return lista di carte rimosse dal gioco
     */
    List<C> rimuoviCarteInGioco(int... pos);
}
