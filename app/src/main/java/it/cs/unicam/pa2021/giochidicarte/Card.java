package it.cs.unicam.pa2021.giochidicarte;

/**
 * Interfaccia che definisce
 * una generica
 */
public interface Card {

    /**
     * Metodo che ritorna il valore
     * della carta
     *
     * @return intero rappresentante il valore
     */
    int getValore();

    /**
     * Metodo che permette di modificare
     * il valore della carta
     *
     * @param nuovoValore intero rappresentante
     *                    il nuovo valore da
     *                    aggiungere
     */
    void setValore(int nuovoValore);
}
