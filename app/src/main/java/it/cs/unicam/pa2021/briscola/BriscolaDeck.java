package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.AbstractDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class BriscolaDeck extends AbstractDeck<BriscolaCard> {

    public BriscolaDeck() {
        super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(1), 11, BriscolaSeeds.BASTONI, BriscolaFigures.ASSE));
        super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(1), 11, BriscolaSeeds.SPADE, BriscolaFigures.ASSE));
        super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(1), 11, BriscolaSeeds.DENARI, BriscolaFigures.ASSE));
        super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(1), 11, BriscolaSeeds.COPPE, BriscolaFigures.ASSE));
        for (int i = 2; i < 11; i++) {
            if (i < 8) {
                if (i == 3) {
                    super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 10, BriscolaSeeds.BASTONI, null));
                    super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 10, BriscolaSeeds.SPADE, null));
                    super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 10, BriscolaSeeds.DENARI, null));
                    super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 10, BriscolaSeeds.COPPE, null));
                }
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 0, BriscolaSeeds.BASTONI, null));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 0, BriscolaSeeds.SPADE, null));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 0, BriscolaSeeds.DENARI, null));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 0, BriscolaSeeds.COPPE, null));
            }
            if (i == 8) {
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 2, BriscolaSeeds.BASTONI, BriscolaFigures.FANTE));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 2, BriscolaSeeds.SPADE, BriscolaFigures.FANTE));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 2, BriscolaSeeds.DENARI, BriscolaFigures.FANTE));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 2, BriscolaSeeds.COPPE, BriscolaFigures.FANTE));
            }
            if (i == 9) {
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 3, BriscolaSeeds.BASTONI, BriscolaFigures.CAVALLO));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 3, BriscolaSeeds.SPADE, BriscolaFigures.CAVALLO));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 3, BriscolaSeeds.DENARI, BriscolaFigures.CAVALLO));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 3, BriscolaSeeds.COPPE, BriscolaFigures.CAVALLO));
            }
            if (i == 10) {
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 4, BriscolaSeeds.BASTONI, BriscolaFigures.RE));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 4, BriscolaSeeds.SPADE, BriscolaFigures.RE));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 4, BriscolaSeeds.DENARI, BriscolaFigures.RE));
                super.getCarteMazzo().add(new it.cs.unicam.pa2021.briscola.BriscolaCard(String.valueOf(i), 4, BriscolaSeeds.COPPE, BriscolaFigures.RE));
            }
        }
    }

    @Override
    public void mischiaMazzo() {
        Collections.shuffle(this.getCarteMazzo());
    }
}
