package it.cs.unicam.pa2021;

import it.cs.unicam.pa2021.briscola.*;
import it.cs.unicam.pa2021.giochidicarte.classicdeck.TrevigianeDeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Benvenuto, inserisci il tuo username:");
        String str = reader.readLine();

        BriscolaPlayerBot bot = new BriscolaPlayerBot("Bot", new BriscolaHandBot());
        BriscolaPlayerUser user = new BriscolaPlayerUser(str, new BriscolaHandUser());

        List<BriscolaPlayer> players = new ArrayList<>();
        players.add(bot);
        players.add(user);

        BriscolaMatch match = new BriscolaMatch(players,new TrevigianeDeck(), new BriscolaField());
        match.execute();
    }
}
