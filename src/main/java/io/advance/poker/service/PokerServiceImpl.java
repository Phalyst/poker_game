package io.advance.poker.service;

import io.advance.poker.dto.Card;
import io.advance.poker.model.Player;
import io.advance.poker.utility.Hand;
import io.advance.poker.utility.Number;
import io.advance.poker.utility.Suit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class PokerServiceImpl implements PokerService{

    @Autowired
    private Hand hand;

    /** Generate 52 cards for the game**/
    public ArrayList<Card> generateCards(){
        ArrayList<Card> cards = new ArrayList<>();

        for (Suit suit: Suit.values()) {

            for(Number number: Number.values()){
                Card card = new Card();
                card.setSuit(suit.toString());
                card.setNumber(number.getNumber());
                cards.add(card);
            }
        }

        return cards;
    }

    /** Shuffle cards and assign cards to players **/
    public Player shuffleCards(ArrayList<Card> cards){
        //TODO:config get number of players
        int numberOfplayers = 1;
        //TODO:config to get the number of cards to be assigned to players
        int numberOfCards = 5;

        Player player = new Player();
        player.setName("player 1");
        ArrayList<Card> playerCards = new ArrayList<>();
        for(int i =0; i < numberOfCards;i++){
            playerCards.add(getRandomCard(cards));
            player.setCard(playerCards);
        }

        return player;
    }

    /** Evaluate the ranks **/
    public Player EvaluateHand(Player player){

        String result = hand.handRankEvaluation(player);
        player.setHandEvaluation(result);
        return player;
    }

    public  void displayPlayerReport(Player player){
        String cardsOnHand = "";
       for (Card card:player.getCard()) {
            cardsOnHand += card.getNumber()+" "+card.getSuit()+" ";
        }
        System.out.println("Your hand : "+cardsOnHand);
        System.out.println("You have : "+player.getHandEvaluation());
    }

    /** Generate random cards from the 52 cards stack **/
    public Card getRandomCard(ArrayList<Card> cards) {
        Random rand = new Random();
        Card card = cards.get(rand.nextInt(cards.size()));

        return card;
    }
}