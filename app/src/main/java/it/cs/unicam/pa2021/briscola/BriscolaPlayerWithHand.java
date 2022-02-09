package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.player.AbstractPlayerWithHand;
import it.cs.unicam.pa2021.giochidicarte.PileCards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Classe che rappresenta un tipico giocatore di briscola
 */
public class BriscolaPlayerWithHand extends AbstractPlayerWithHand<BriscolaCard> {

    private final String nomeGiocatore;
    private final List<BriscolaCard> carteInMano;
    private final List<BriscolaCard> carteInPossesso;
    private int punti;

    public BriscolaPlayerWithHand(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
        this.carteInMano = new ArrayList<>();
        this.carteInPossesso = new ArrayList<>();
        this.punti = 0;
    }

    public String getNomeGiocatore() {
        return this.nomeGiocatore;
    }

    @Override
    public List<BriscolaCard> getCarteInMano() {
        return this.carteInMano;
    }

    @Override
    public List<BriscolaCard> getCartePossedute() {
        return this.carteInPossesso;
    }

    public int getPunti() {
        return this.punti;
    }

    public void setPunti(int punteggio) {
        this.punti = punteggio;
    }

    @Override
    public BriscolaCard giocaCarta(int carta) {
        BriscolaCard card = null;
        try {
            card = this.carteInMano.remove(carta);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indice non disponibile, riprova!");
        }
        return card;
    }

    @Override
    public void pescaCarta(PileCards<BriscolaCard> from, int carta) {
        this.getCarteInMano().add(from.remove(carta));
    }

    @Override
    public void pescaCarte(PileCards<BriscolaCard> from, int carte) {
        IntStream.range(0,carte).forEach(x -> pescaCarta(from, 0));
    }
    @Override
    public String toString() {
        return "BriscolaPlayerWithHand{" +
                "nomeGiocatore='" + nomeGiocatore + '\'' +
                '}';
    }
}
