package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianeFigures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianeSeeds;
import it.cs.unicam.pa2021.giochidicarte.classicdeck.TrevigianeDeck;
import it.cs.unicam.pa2021.giochidicarte.match.AbstractMatchMultiplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Classe che rappresenta un partita di briscola 1 vs 1
 */
public class BriscolaMatch extends AbstractMatchMultiplayer<BriscolaPlayer, TrevigianeDeck, BriscolaField> {

    public BriscolaMatch(List<BriscolaPlayer> players, TrevigianeDeck deck, BriscolaField briscolaField) {
        super(players, deck, briscolaField);
        this.initialize();
    }

    private int first() {
        Random random = new Random();
        return random.nextInt(2) + 1;
    }

    private int second(int i) {
        if (i == 1) { return 2; }
        return 1;
    }

    private TrevigianaCard briscola() {
        this.getDeck().shuffleDeck(3);
        return this.getDeck().removeCardInPos(0);
    }

    @Override
    public void initialize() {
        System.out.println("Benvenuti nel gioco della briscola");
        TrevigianaCard cartaBriscola = briscola();
        this.getField().addCard(cartaBriscola);
        System.out.println("La briscola di questa partita e': " + cartaBriscola);
        int idFirstPlayer = first();
        int idSecondPlayer = second(idFirstPlayer);
        BriscolaPlayer firstPlayer = this.getSinglePlayerInGameById(idFirstPlayer);
        BriscolaPlayer secondPlayer = this.getSinglePlayerInGameById(idSecondPlayer);
        firstPlayer.getHand().drawCards(this.getDeck(),3);
        secondPlayer.getHand().drawCards(this.getDeck(),3);
        System.out.println("Il giocatore iniziale e': " + firstPlayer.getName());
        List<BriscolaPlayer> players = new ArrayList<>();
        players.add(firstPlayer);
        players.add(secondPlayer);
        this.setPlayersInGame(players);
    }

    @Override
    public void execute() {
        BriscolaPlayer firstPlayer = this.getPlayersInGame().get(0);
        BriscolaPlayer secondPlayer = this.getPlayersInGame().get(1);
        TrevigianaCard briscola = this.getField().cardInPosition(0);
        this.setPlayersInGame(this.checkWinRound(briscola, firstPlayer,secondPlayer));
        this.getPlayersInGame().get(0).getHand().drawCard(this.getDeck(),0);
        while (this.getDeck().nCards() > 0) {
            this.getPlayersInGame().get(1).getHand().drawCard(this.getDeck(),0);
            this.checkWinRound(briscola, this.getPlayersInGame().get(0),this.getPlayersInGame().get(1));
            this.getPlayersInGame().get(0).getHand().drawCard(this.getDeck(),0);
        }
        this.getPlayersInGame().get(1).getHand().drawCard(this.getField(),0);
        IntStream.range(0,3).sequential().forEach(x -> checkWinRound(briscola, this.getPlayersInGame().get(0),this.getPlayersInGame().get(1)));
        int pointsFirstPlayer = this.sumPoints(this.getPlayersInGame().get(0).getWonCards());
        if (pointsFirstPlayer > 60) {
            System.out.println("Il vincitore della partita e': "+this.getPlayersInGame().get(0).getName());
        } else if (pointsFirstPlayer < 60) {
            System.out.println("Il vincitore della partita e': "+this.getPlayersInGame().get(1).getName());
        } else {
            System.out.println("La partita e' finita con il pareggio");
        }
        this.restart();
    }

    private void restart() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Vuori rigiocare un'altra partita?\nRispondi si o no");
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            System.out.println("Errore");
        }
        if (str.equals("si")) {
            this.getPlayersInGame().get(0).getWonCards().clear();
            this.getPlayersInGame().get(1).getWonCards().clear();
            BriscolaMatch briscolaMatch = new BriscolaMatch(this.getPlayersInGame(),new TrevigianeDeck(), this.getField());
            briscolaMatch.execute();
        } else {
            System.out.println("Arrivederci e buona giornata");
        }
    }

    private int sumPoints(List<TrevigianaCard> cards) {
        List<TrevigianaCard> points = cards.stream().filter(x -> x.getFigures() != null || x.getIndex() == 3).collect(Collectors.toList());
        if (points.isEmpty()) { return 0; }
        int sum = 0;
        for(TrevigianaCard card: points) {
            if (card.getFigures() == TrevigianeFigures.ASSE) sum += 11;
            if (card.getFigures() == TrevigianeFigures.RE) sum += 4;
            if (card.getFigures() == TrevigianeFigures.CAVALLO) sum += 3;
            if (card.getFigures() == TrevigianeFigures.FANTE) sum += 2;
            if (card.getIndex() == 3) sum += 10;
        }
        return sum;
    }

    private List<BriscolaPlayer> checkWinRound(TrevigianaCard briscola, BriscolaPlayer firstPlayer, BriscolaPlayer secondPlayer) {
        List<BriscolaPlayer> players = this.getPlayersInGame();
        TrevigianeSeeds briscolaSeed = briscola.getSeed();
        System.out.println("E' il turno di: "+firstPlayer.getName());
        TrevigianaCard firstCard = firstPlayer.getHand().playCard();
        TrevigianeSeeds firstCardSeed = firstCard.getSeed();
        System.out.println("E' il turno di: "+secondPlayer.getName());
        TrevigianaCard secondCard = secondPlayer.getHand().playCard();
        TrevigianeSeeds secondCardSeed = secondCard.getSeed();
        if (firstCardSeed.equals(briscolaSeed) && !secondCardSeed.equals(briscolaSeed) ||
                !firstCardSeed.equals(briscolaSeed) && !secondCardSeed.equals(briscolaSeed) ||
                firstCard.equals(caseWithSameSeeds(firstCard,secondCard))) {
            System.out.println("Il vincitore della mano e': "+firstPlayer.getName());
            firstPlayer.winCards(firstCard,secondCard);
        } else {
            System.out.println("Il vincitore della mano e': "+secondPlayer.getName());
            secondPlayer.winCards(firstCard,secondCard);
            players.clear();
            players.add(secondPlayer);
            players.add(firstPlayer);
            this.setPlayersInGame(players);
        }
        return players;
    }

    private TrevigianaCard caseWithSameSeeds(TrevigianaCard firstCard, TrevigianaCard secondCard) {
        if (firstCard.getFigures() == TrevigianeFigures.ASSE) {
            return firstCard;
        } else if (secondCard.getFigures() == TrevigianeFigures.ASSE) {
            return secondCard;
        } else if (firstCard.getIndex() == 3) {
            return firstCard;
        } else if (secondCard.getIndex() == 3) {
            return secondCard;
        } else if (firstCard.getIndex() > secondCard.getIndex()) {
            return firstCard;
        }
        return secondCard;
    }

}
