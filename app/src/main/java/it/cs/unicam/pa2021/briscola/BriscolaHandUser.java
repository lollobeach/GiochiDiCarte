package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe che definisce la mano di
 * un utente.
 * In questo caso &egrave; l'utente stesso a
 * selezionare la carta da giocare selezionando
 * l'indice della sua posizione nella mano
 */
public class BriscolaHandUser extends it.cs.unicam.pa2021.briscola.BriscolaHand {

    public BriscolaHandUser() { super();}

    @Override
    public TrevigianaCard playCard() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Seleziona la carta:");
        this.getCards().forEach(this::print);
        String cardPlayed = "";
        try {
            cardPlayed = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            this.playCard();
        }
        int card = Integer.parseInt(cardPlayed);
        System.out.println("Carta giocata: "+this.cardInPosition(card)+"\n");
        return this.removeCardInPos(card);
    }

    private void print(TrevigianaCard x) {
        System.out.println(this.getCards().lastIndexOf(x) + " -> " + x);
    }
}
