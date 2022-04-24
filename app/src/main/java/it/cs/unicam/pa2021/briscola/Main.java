package it.cs.unicam.pa2021.briscola;

import it.cs.unicam.pa2021.giochidicarte.classicdeck.TrevigianeDeck;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BriscolaPlayerUser userPlayer = new BriscolaPlayerUser("Lorenzo",new BriscolaHandUser());
        BriscolaPlayerBot botPlayer = new BriscolaPlayerBot("Bot",new BriscolaHandBot());

        List<BriscolaPlayer> players = new ArrayList<>() {{
            add(userPlayer);
            add(botPlayer);
        }};

        BriscolaMatch match = new BriscolaMatch(players, new TrevigianeDeck(), new BriscolaField());
        match.execute();

    }
}
