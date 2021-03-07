package io.advance.poker;

import io.advance.poker.dto.Card;
import io.advance.poker.model.Player;
import io.advance.poker.service.PokerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class PokerApplicationTests {

	@Autowired
	private PokerService pokerService;

	@Test
	void contextLoads() {
	}

	@Test
	void generate_cards_test(){
		ArrayList<Card> cards = pokerService.generateCards();
		Assertions.assertSame(cards.size(),52);

	}

	@Test
	void assign_cards_to_player_test(){
		ArrayList<Card> cards = pokerService.generateCards();
		Player player = pokerService.shuffleCards(cards);
		Assertions.assertSame(player.getCard().size(),5);
	}

	@Test
	void hand_rank_evaluation_test(){
		ArrayList<Card> cards = pokerService.generateCards();
		Player player = pokerService.shuffleCards(cards);
		Player player1 = pokerService.EvaluateHand(player);
		Assertions.assertNotNull(player1.getHandEvaluation());
	}

}
