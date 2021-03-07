package io.advance.poker.utility;


import io.advance.poker.dto.Card;

import java.util.Comparator;

public class CardSorter implements Comparator<Card>
{
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getNumber().compareTo(o2.getNumber());
    }
}