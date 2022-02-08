package it.cs.unicam.pa2021.giochidicarte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che, implementando l'interfaccia
 * Field, definisce un classico
 * campo da gioco avente una lista su cui salvare
 * le carte che vengono giocate
 *
 * @param <C> tipo di carte che verranno giocate
 */
public class SimpleField<C extends Card> implements Field<C> {

    private final List<C> carteInGioco;

    public SimpleField() {
        this.carteInGioco = new ArrayList<>();
    }

    @Override
    public List<C> getCarteInGioco() {
        return this.carteInGioco;
    }

    /**
     * @param carta la carta che deve essere
     *              aggiunta
     *
     * @throws NullPointerException se carta &egrave;
     * null
     * @throws IllegalArgumentException se la carta che si
     * vuole aggiungere &egrave; gi&agrave; presente
     */
    @Override
    public void aggiungiCartaInGioco(C carta) {
        if (carta == null) { throw new NullPointerException("Carta non selezionata"); }
        if (this.carteInGioco.contains(carta)) { throw new IllegalArgumentException("Carta gia presente"); }
        this.carteInGioco.add(carta);
    }

    /**
     * @param carta carta da rimuovere
     *
     * @throws NullPointerException se carta &egrave;
     * null
     * @throws IllegalArgumentException se la carta che si vuole
     * rimuovere non &egrave; presente
     */
    @Override
    public void rimuoviCartaInGioco(C carta) {
        if (carta == null) { throw new NullPointerException("Carta non selezionata"); }
        if (!this.carteInGioco.contains(carta)) { throw new IllegalArgumentException("Carta non presente"); }
        this.carteInGioco.remove(carta);
    }

    /**
     * @param pos posizione della carta nella lista
     *            delle carte in gioco
     *
     * @throws IndexOutOfBoundsException se pos
     * &egrave; minore di 0 o maggiore del numero delle
     * carte in gioco
     *
     * @return la carta rimossa
     */
    @Override
    public C rimuoviCartaInGioco(int pos) {
        if (pos < 0 || pos > nCarteInGioco()-1) { throw new IndexOutOfBoundsException("Indice non valido"); }
        return this.carteInGioco.remove(pos);
    }

    /**
     * @param pos posizioni delle carte nella lista
     *            delle carte in gioco
     *
     * @throws NullPointerException se l'array delle posizioni
     * &egrave; vuoto
     * @throws IllegalArgumentException se l'array presenta indici
     * doppioni
     *
     * @return lista delle carte rimosse dal gioco
     */
    @Override
    public List<C> rimuoviCarteInGioco(int... pos)  {
        if (pos.length == 0) { throw new NullPointerException("Posizioni non selezionate"); }
        List<Integer> listaControllo = Arrays.stream(pos).boxed().collect(Collectors.toList());
        int controllo = (int) listaControllo.stream().filter(i -> Collections.frequency(listaControllo,i) > 1).count();
        if (controllo > 0) { throw new IllegalArgumentException("Indici doppioni non validi"); }
        List<C> temp = new ArrayList<>();
        listaControllo.forEach(x -> temp.add(getCarteInGioco().get(x)));
        getCarteInGioco().removeAll(temp);
        return temp;
    }
}
