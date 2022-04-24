package it.cs.unicam.pa2021.briscola;

/**
 * Classe che rappresenta un giocatore bot.
 * A differenze del giocatore umano il
 * giocatore bot gioca con una mano bot che gli
 * permette di scegliere in modo casuale la carta da
 * giocare
 */
public class BriscolaPlayerBot extends BriscolaPlayer {

    public BriscolaPlayerBot(String name, BriscolaHandBot hand) {
        super(name, hand);
    }
}