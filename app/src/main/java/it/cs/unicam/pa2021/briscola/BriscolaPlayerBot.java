package it.cs.unicam.pa2021.briscola;

public class BriscolaPlayerBot extends BriscolaPlayer {

    public BriscolaPlayerBot(String name, BriscolaHandBot hand) {
        super(name, hand);
    }

    @Override
    public BriscolaHandBot getHand() {
        return (BriscolaHandBot) super.getHand();
    }
}