package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classiccards.trevigianecards.TrevigianaCard;
import it.cs.unicam.pa2021.giochidicarte.classicdeck.TrevigianeDeck;
import it.cs.unicam.pa2021.giochidicarte.match.AbstractMatchMultiplayer;
import it.cs.unicam.pa2021.giochidicarte.match.Match;

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

    private List<BriscolaPlayer> inizializationPlayers(BriscolaPlayer... players) {
        BriscolaPlayerBot bot;
        List<BriscolaPlayer> playersInitialized = new ArrayList<>();
        if (players[0] instanceof BriscolaPlayerBot) {
            bot = (BriscolaPlayerBot) players[0];
            bot.getHand().addCards(this.getDeck().removeNCardsFromTop(3));
            players[1].getHand().addCards(this.getDeck().removeNCardsFromTop(3));
            playersInitialized.add(bot);
            playersInitialized.add(players[1]);
        } else {
            players[0].getHand().addCards(this.getDeck().removeNCardsFromTop(3));
            bot = (BriscolaPlayerBot) players[1];
            bot.getHand().addCards(this.getDeck().removeNCardsFromTop(3));
            playersInitialized.add(players[0]);
            playersInitialized.add(bot);
        }
        return playersInitialized;
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
        System.out.println("Il giocatore iniziale è: " + firstPlayer);
        List<BriscolaPlayer> players = this.inizializationPlayers(firstPlayer, secondPlayer);
        return new BriscolaMatch(players,this.getDeck(),this.getField());
    }

    @Override
    public void execute() {
        initialize();

    }
}
