package it.cs.unicam.pa2021.briscola;

import java.util.Random;

public class BotBriscolaPlayer extends BriscolaPlayer{

    public BotBriscolaPlayer(String nomeGiocatore) {
        super(nomeGiocatore);
    }

    public BriscolaCard selezioneCartaDaGiocare() {
        Random random = new Random();
        int cartaSelezionata = random.nextInt(3);
        return giocaCarta(cartaSelezionata);
    }
}
