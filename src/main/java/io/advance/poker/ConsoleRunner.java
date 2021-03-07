package io.advance.poker;

import io.advance.poker.dto.Card;
import io.advance.poker.model.Player;
import io.advance.poker.service.PokerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private PokerServiceImpl pokerService;

    @Override
    public void run(String... args) throws Exception {
        ArrayList<Card> cards = pokerService.generateCards();
        Player player = pokerService.shuffleCards(cards);
        Player player1 = pokerService.EvaluateHand(player);
        pokerService.displayPlayerReport(player1);


    }
}

