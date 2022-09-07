package com.example.unocards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> cards;

    public Hand() {cards = new ArrayList<>();}

    public void add(Card card) {
        cards.add(card);
    }

    public boolean remove(Card card) {
        return cards.remove(card);
    }
}
