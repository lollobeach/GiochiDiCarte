package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianeFigures;
import it.cs.unicam.pa2021.giochidicarte.classicdeck.TrevigianeDeck;
import it.cs.unicam.pa2021.giochidicarte.match.AbstractMatchMultiplayer;
import it.cs.unicam.pa2021.giochidicarte.match.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public Match<TrevigianeDeck,BriscolaField> initialize() {
        System.out.println("Benvenuti nel gioco della briscola");
        TrevigianaCard cartaBriscola = briscola();
        this.getField().addCard(cartaBriscola);
        System.out.println("La briscola di questa partita è: " + cartaBriscola);
        int idFirstPlayer = first();
        int idSecondPlayer = second(idFirstPlayer);
        BriscolaPlayer firstPlayer = this.getSinglePlayerInGameById(idFirstPlayer);
        BriscolaPlayer secondPlayer = this.getSinglePlayerInGameById(idSecondPlayer);
        firstPlayer.getHand().addCards(this.getDeck().removeNCardsFromTop(3));
        secondPlayer.getHand().addCards(this.getDeck().removeNCardsFromTop(3));
        System.out.println("Il giocatore iniziale è: " + firstPlayer);
        List<BriscolaPlayer> players = new ArrayList<>();
        players.add(firstPlayer);
        players.add(secondPlayer);
        return new BriscolaMatch(players,this.getDeck(),this.getField());
    }

    @Override
    public void execute() throws IOException {
        BriscolaMatch match = (BriscolaMatch) initialize();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BriscolaPlayer firstPlayer = match.getPlayersInGame().get(0);
        BriscolaPlayer secondPlayer = match.getPlayersInGame().get(1);
        BriscolaPlayerBot bot;
        String card;
        if (firstPlayer instanceof BriscolaPlayerBot) {
            bot = (BriscolaPlayerBot) firstPlayer;
            TrevigianaCard playedCardByBot = bot.getHand().playCard();
            this.getField().addCard(playedCardByBot);
            System.out.println("Carta giocata dal bot: "+playedCardByBot);
            System.out.println("Briscola sul campo: "+this.getField().cardInPosition(0));
            System.out.println("Carte in mano:"+secondPlayer.getHand().getCards());
            System.out.println("0 -> "+secondPlayer.getHand().cardInPosition(0)+"\n1 -> "+secondPlayer.getHand().cardInPosition(1)
                    +"\n2 -> "+secondPlayer.getHand().cardInPosition(2));
            System.out.println("E' il tuo turno:");
            card = reader.readLine();
            int cardToPlay = Integer.parseInt(card);
            TrevigianaCard playedCardByUser = secondPlayer.getHand().playCard(cardToPlay);
            this.getField().addCard(playedCardByUser);
            System.out.println("Carta giocata: "+playedCardByUser);
            System.out.println("Carte in tavola:\n"+playedCardByBot+"\n"+playedCardByUser);

        }
        while (this.getDeck().nCards() != 0) {

        }
    }

    private TrevigianaCard checkWinRound(TrevigianaCard userCard, TrevigianaCard botCard) {
        TrevigianaCard briscola = this.getField().cardInPosition(0);
        TrevigianeFigures briscolaFigures = briscola.getFigures();
        TrevigianeFigures userCardFigures = userCard.getFigures();
        TrevigianeFigures botCardFigures = botCard.getFigures();
        if (userCardFigures.equals(briscolaFigures) && !botCardFigures.equals(briscolaFigures)) {
            return userCard;
        } else if (botCardFigures.equals(briscolaFigures) && !userCardFigures.equals(briscolaFigures)) {
            return botCard;
        }
        return null;
    }

}
