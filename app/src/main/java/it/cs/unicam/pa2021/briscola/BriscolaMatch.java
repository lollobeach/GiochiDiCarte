//package it.cs.unicam.pa2021.briscola;
//
//import it.cs.unicam.pa2021.giochidicarte.AbstractMatch;
//import it.cs.unicam.pa2021.giochidicarte.SimpleField;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//import java.util.function.Predicate;
//import java.util.stream.IntStream;
//
//
///**
// * Classe che rappresenta un partita di briscola 1 vs 1.
// * La lista dei giocatori deve contenere due giocatori e la lista
// * dei mazzi un solo mazzo
// */
//public class BriscolaMatch extends AbstractMatch<BriscolaPlayer, BriscolaDeck, SimpleField<BriscolaCard>> {
//
//
//    public BriscolaMatch(List<BriscolaPlayer> giocatori, List<BriscolaDeck> mazzi, SimpleField<BriscolaCard> campoDaGioco) {
//        super(giocatori, mazzi, campoDaGioco);
//        if (giocatori.size() > 2) { throw new IllegalArgumentException("Si può giocare con due giocatori"); }
//        if (mazzi.size() > 1) { throw new IllegalArgumentException("Si può giocare con un singolo mazzo"); }
//    }
//
//    @Override
//    public BriscolaPlayer getWinnerPlayer(Predicate<BriscolaPlayer> p) {
//        Optional<BriscolaPlayer> opt = getPlayersInGame().stream().filter(p).findFirst();
//        if (opt.isPresent()) {
//            System.out.println("Il vincitore è il giocatore: " + opt.get().getNomeGiocatore() + " - " + opt.get().getIdPlayer());
//            return opt.get(); }
//        return null;
//    }
//
//    private int primoGiocatore() {
//        Random random = new Random();
//        return random.nextInt(2);
//    }
//
//    private int secondoGiocatore(int i) {
//        if (i == 0) { return 1; }
//        return 0;
//    }
//
//    private BriscolaCard briscola() {
//        IntStream.range(0,3).forEach(x -> getSingleDeck(0).mischiaMazzo());
//        return getSingleDeck(0).rimuoviCarta(0);
//    }
//
//    @Override
//    public void initialize() {
//        System.out.println("Benvenuti nel gioco della briscola");
//        BriscolaCard cartaBriscola = briscola();
//        System.out.println("La briscola di questa partita è: " + cartaBriscola.toString());
//        int indicePrimoGiocatore = primoGiocatore();
//        int indiceSecondoGiocatore = secondoGiocatore(indicePrimoGiocatore);
//        BriscolaPlayer primoGiocatore = getSinglePlayerInGame(indicePrimoGiocatore);
//        BriscolaPlayer secondoGiocatore = getSinglePlayerInGame(indiceSecondoGiocatore);
//        System.out.println("Il giocatore iniziale è: " + primoGiocatore.toString());
//        BriscolaDeck mazzi = this.getSingleDeck(0);
//        primoGiocatore.pescaCarte(mazzi.getCarteMazzo(), 3);
//        secondoGiocatore.pescaCarte(mazzi.getCarteMazzo(), 3);
//    }
//
//    @Override
//    public void execute() {
//        initialize();
//    }
//}
