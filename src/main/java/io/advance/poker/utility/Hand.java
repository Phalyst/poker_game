package io.advance.poker.utility;

import io.advance.poker.dto.Card;
import io.advance.poker.model.Player;
import io.advance.poker.utility.CardSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class Hand {

    public String handRankEvaluation(Player player){

        String evaluation = "";
        player.getCard().sort(new CardSorter());
        int count2 = Collections.frequency(player.getCard(), player.getCard().get(0).getNumber());
        Card card0 = player.getCard().get(0);

        int count[] = new int[5];

        List<String> cardNumbers = new ArrayList<>();

       for (Card card: player.getCard()) {
           cardNumbers.add(card.getNumber());
       }
       for (String num: cardNumbers) {
            int  i =0;
            count[i] = Collections.frequency(cardNumbers, num);
            i++;
       }

        for(int i = 0;i < count.length;i++){
            if(count[i] == 4 ){
                evaluation = "Five of a kind";
                break;
            }else if(count[i] == 4 || count2 == 4){
                evaluation = "Four of a kind";break;
            }else if(count[i] == 3 || count2 == 3 ) {
                evaluation = "Three of a kind";break;
            }
            else if(count[i] == 2 && count2 == 2) {
                evaluation = "Two pair";break;
            }
            else if(count[i] == 2 || count2 == 2) {
                evaluation = "One pair";break;
            }
            else if(count[i] == 3 & count2 == 2){
                evaluation = "Full House";break;
            }
            else if(count[i] == 0 ){
                evaluation = "High Card";
            }
        }
        return evaluation;
    }

}
