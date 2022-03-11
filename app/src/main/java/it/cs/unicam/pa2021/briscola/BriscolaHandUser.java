package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BriscolaHandUser extends BriscolaHand{

    public BriscolaHandUser() { super();}

    @Override
    public TrevigianaCard playCard() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Seleziona la carta:");
        System.out.println("0 -> "+this.cardInPosition(0));
        System.out.println("1 -> "+this.cardInPosition(1));
        System.out.println("2 -> "+this.cardInPosition(2));
        String cardPlayed = "null";
        try {
            cardPlayed = reader.readLine();
        } catch (IOException e) {
            System.out.println("Si è presentato un errore, ritenta");
            this.playCard();
        }
        int card = Integer.parseInt(cardPlayed);
        System.out.println("Carta giocata: "+this.cardInPosition(card));
        return this.removeCard(card);
    }
}
