package it.cs.unicam.pa2021.giochidicarte;

import java.util.List;

/**
 * Interfaccia che definisce le
 * azioni elementari che si possono
 * compiere con un mazzo
 *
 * @param <C> tipo di carte che sono
 *           contenute nel mazzo
 */
public interface Deck<C extends Card> {

    /**
     * Metodo che ritorna tutte le
     * carte contenute nel mazzo
     *
     * @return lista di carte contenute
     */
    List<C> getCarteMazzo();

    /**
     * Metodo che ritorna il numero
     * di carte nel mazzo
     *
     * @return intero rappresentante
     * il numero di carte nel mazzo
     */
    default int nCarteMazzo() {
        return getCarteMazzo().size();
    }

    /**
     * Metodo che ritorna una carta
     * in una determinata posizione
     * all'interno del mazzo
     *
     * @param pos posizione della
     *            carta nel mazzo
     *
     * @throws IndexOutOfBoundsException se
     * l'indice non coincide con un indice presente
     * nel mazzo
     *
     * @return la carta che si trova
     * in quella determinata posizione nel mazzo
     */
    default C getCarta(int pos) {
        if (pos < 0 || pos > nCarteMazzo() - 1) { throw new IndexOutOfBoundsException("Posizione non valida"); }
        return getCarteMazzo().get(pos);
    }

    /**
     * Metodo che ritorna la posizione
     * di una determinata carta all'interno del mazzo
     *
     * @param carta carta di cui si vuole sapere
     *              la posizione
     *
     * @throws NullPointerException se si passa null
     * come argomento
     * @throws IllegalArgumentException se la carta
     * non è contenuta nel mazzo
     *
     * @return posizione della carta selezionata
     */
    default int getPosizioneCarta(C carta) {
        if (carta == null) { throw new NullPointerException("Carta non selezionata"); }
        if (!getCarteMazzo().contains(carta)) { throw new IllegalArgumentException("Carta non presente nel mazzo"); }
        return getCarteMazzo().lastIndexOf(carta);
    }

    /**
     * Metodo permette di determinare
     * se una determinata carta &egrave; presente
     * nel mazzo
     *
     * @param carta di cui si vuole sapere se
     *              si trova nel mazzo
     *
     * @return true se &egrave; presente, false
     * altrimenti
     */
    default boolean cartaPresente(C carta) {
        return getCarteMazzo().contains(carta);
    }

    /**
     * Metodo che permette di selezionare
     * un indice nel mazzo per poi rimuovere
     * la carta corrispondente a quella posizione
     *
     * @param pos posizione della carta
     *            che si vuole rimuovere
     *
     * @return la carta che &egrave; stata rimossa
     */
    C rimuoviCarta(int pos);

    /**
     * Metodo che permette di rimuovere una
     * carta
     *
     * @param carta carta che si vuole rimuovere
     *
     * @return indice della carta che &egrave; stata
     * rimossa
     */
    int rimuoviCarta(C carta);

    /**
     * Metodo che permette di rimuovere
     * un numero di carte
     *
     * @param n numero di carte che si vogliono
     *          eliminare
     *
     * @return lista di carte che sono state rimosse
     */
    List<C> rimuoviNCarte(int n);

    /**
     * Metodo che permette di rimuovere una lista
     * di carte
     *
     * @param carte lista contenenti le
     *              carte che si vogliono rimuovere
     */
    void rimuoviCarte(List<C> carte);

    /**
     * Metodo che permette di aggiungere una
     * carte nel mazzo
     *
     * @param carta carta che si vuole aggiungere
     */
    void aggiungiCarta(C carta);

    /**
     * Metodo che permette di aggiungere una
     * determinata carta in una posizione
     *
     * @param pos posizione nel mazzo in cui si
     *            vuole aggiungere la carta
     * @param carta carta che si vuole aggiungere
     */
    void aggiungiCarta(int pos, C carta);

    /**
     * Metodo che permette di aggiungere una
     * lista di carte
     *
     * @param carte lista contenenti le carte che si vogliono
     *              aggiungere
     */
    void aggiungiCarte(List<C> carte);

    /**
     * Metodo che permette di aggiungere una
     * lista di carte in una determinata posizione
     * all'interno del mazzo
     *
     * @param pos posizione nel mazzo in cui si
     *            vogliono aggiungere le carte
     * @param carte lista contenente le carte che si
     *              vuole aggiungere
     */
    void aggiungiCarte(int pos, List<C> carte);

    /**
     * Metodo che permette di mischiare
     * il mazzo
     */
    void mischiaMazzo();
}


//        if (carte.size() == 0) { throw new NullPointerException("Carte non selezionate"); }
//                List<C> listaControllo = new ArrayList<>(carte);
//        int check = (int) listaControllo.stream().filter(i -> Collections.frequency(listaControllo,i) > 1).count();
//        if (check > 0) { throw new IllegalArgumentException("Carte doppioni non valide"); }
//        listaControllo.forEach(this::rimuoviCarta);
//        return listaControllo;