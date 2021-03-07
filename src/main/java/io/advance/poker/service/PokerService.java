package io.advance.poker.service;

import io.advance.poker.dto.Card;
import io.advance.poker.model.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface PokerService {

    ArrayList<Card> generateCards();
    Player shuffleCards(ArrayList<Card> cards);
    Player EvaluateHand(Player player);
    void displayPlayerReport(Player player);
    Card getRandomCard(ArrayList<Card> cards);
}
