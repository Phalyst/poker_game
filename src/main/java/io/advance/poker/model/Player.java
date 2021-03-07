package io.advance.poker.model;

import io.advance.poker.dto.Card;

import java.util.List;

public class Player {

    private String name;
    private List<Card> card;
    private String handEvaluation;

    public String getHandEvaluation() {
        return handEvaluation;
    }

    public void setHandEvaluation(String handEvaluation) {
        this.handEvaluation = handEvaluation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", card=" + card +
                ", handEvaluation='" + handEvaluation + '\'' +
                '}';
    }
}
