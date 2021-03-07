package io.advance.poker.dto;

import java.util.Comparator;

public class Card {
   private String number;
   private String suit;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }



    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
