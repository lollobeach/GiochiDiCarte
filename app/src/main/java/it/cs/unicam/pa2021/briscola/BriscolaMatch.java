package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianeFigures;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianeSeeds;
import it.cs.unicam.pa2021.giochidicarte.classicdeck.TrevigianeDeck;
import it.cs.unicam.pa2021.giochidicarte.match.AbstractMatchMultiplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Classe che rappresenta un partita di briscola 1 vs 1
 */
public class BriscolaMatch extends AbstractMatchMultiplayer<BriscolaPlayer, TrevigianeDeck, BriscolaField> {

    public BriscolaMatch(List<BriscolaPlayer> players, TrevigianeDeck deck, BriscolaField briscolaField) {
        super(players, deck, briscolaField);
        this.initialize();
    }

    @Override
    public BriscolaPlayer getWinnerPlayer(Predicate<BriscolaPlayer> p) {
        Optional<BriscolaPlayer> opt = getPlayersInGame().stream().filter(p).findFirst();
        if (opt.isPresent()) {
            System.out.println("Il vincitore è il giocatore: " + opt.get().getName() + " - " + opt.get().getId());
            return opt.get(); }
        return null;
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
        return this.getDeck().removeCard(0);
    }

    @Override
    public void initialize() {
        System.out.println("Benvenuti nel gioco della briscola");
        TrevigianaCard cartaBriscola = briscola();
        this.getField().addCard(cartaBriscola);
        System.out.println("La briscola di questa partita è: " + cartaBriscola);
        int idFirstPlayer = first();
        int idSecondPlayer = second(idFirstPlayer);
        BriscolaPlayer firstPlayer = this.getSinglePlayerInGameById(idFirstPlayer);
        BriscolaPlayer secondPlayer = this.getSinglePlayerInGameById(idSecondPlayer);
        firstPlayer.getHand().drawCards(this.getDeck(),3);
        secondPlayer.getHand().drawCards(this.getDeck(),3);
        System.out.println("Il giocatore iniziale è: " + firstPlayer);
        List<BriscolaPlayer> players = new ArrayList<>();
        players.add(firstPlayer);
        players.add(secondPlayer);
        this.setPlayersInGame(players);
    }

    @Override
    public void execute() {
//        BriscolaPlayer firstPlayer = this.getPlayersInGame().get(0);
//        BriscolaPlayer secondPlayer = this.getPlayersInGame().get(1);
//        BriscolaPlayerBot bot;
//        String card;
        BriscolaPlayer firstPlayer = this.getPlayersInGame().get(0);
        BriscolaPlayer secondPlayer = this.getPlayersInGame().get(1);
        this.setPlayersInGame(this.checkWinRound(firstPlayer,secondPlayer));
        while (this.getDeck().nCards() != 0) {
            if (this.getDeck().nCards() == 1) {
                this.getPlayersInGame().get(0).getHand().drawCard(this.getDeck(),0);
                this.getPlayersInGame().get(1).getHand().drawCard(this.getField(),0);
            }
            this.getPlayersInGame().get(0).getHand().drawCard(this.getDeck(),0);
            this.getPlayersInGame().get(1).getHand().drawCard(this.getDeck(),0);
            this.checkWinRound(this.getPlayersInGame().get(0),this.getPlayersInGame().get(1));
        }
    }

//            if (firstPlayer instanceof BriscolaPlayerBot) {
//        bot = (BriscolaPlayerBot) firstPlayer;
//        TrevigianaCard playedCardByBot = bot.getHand().playCard();
//        this.getField().addCard(playedCardByBot);
//        System.out.println("Carta giocata dal bot: "+playedCardByBot);
//        System.out.println("Briscola sul campo: "+this.getField().cardInPosition(0));
//        System.out.println("Carte in mano:"+secondPlayer.getHand().getCards());
//        System.out.println("0 -> "+secondPlayer.getHand().cardInPosition(0)+"\n1 -> "+secondPlayer.getHand().cardInPosition(1)
//                +"\n2 -> "+secondPlayer.getHand().cardInPosition(2));
//        System.out.println("E' il tuo turno:");
//        card = reader.readLine();
//        int cardToPlay = Integer.parseInt(card);
//        TrevigianaCard playedCardByUser = secondPlayer.getHand().playCard();
//        this.getField().addCard(playedCardByUser);
//        System.out.println("Carta giocata: "+playedCardByUser);
//        System.out.println("Carte in tavola:\n"+playedCardByBot+"\n"+playedCardByUser);
//
//    }

    private List<BriscolaPlayer> checkWinRound(BriscolaPlayer firstPlayer, BriscolaPlayer secondPlayer) {
        List<BriscolaPlayer> players = this.getPlayersInGame();
        TrevigianaCard briscola = this.getField().cardInPosition(0);
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
            System.out.println("Il vincitore della mano è: "+firstPlayer);
            firstPlayer.winCards(firstCard,secondCard);
//            firstPlayer.getHand().drawCard(this.getDeck(), 0);
//            secondPlayer.getHand().drawCard(this.getDeck(),0);
        } else {
            System.out.println("Il vincitore della mano è: "+secondPlayer);
            secondPlayer.winCards(firstCard,secondCard);
//            secondPlayer.getHand().drawCard(this.getDeck(),0);
//            firstPlayer.getHand().drawCard(this.getDeck(),0);
            players.clear();
            players.add(secondPlayer);
            players.add(firstPlayer);
            this.setPlayersInGame(players);
        }
        return players;
    }

    private TrevigianaCard caseWithSameSeeds(TrevigianaCard firstCard, TrevigianaCard secondCard) {
        if (firstCard.getFigures().equals(TrevigianeFigures.ASSE)) {
            return firstCard;
        } else if (secondCard.getFigures().equals(TrevigianeFigures.ASSE)) {
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
