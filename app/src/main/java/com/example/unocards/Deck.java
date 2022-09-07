package com.example.unocards;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {
    Queue<Card> cards;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Deck() {
        cards = new LinkedList<Card>();

        ArrayList<Card> tempCards = new ArrayList<Card>();
        int colorCount = 0;
        for (int num =0; num < 12; ++num) {
            String value = num + "";
            if (num == 10)
                value = "S";
            else if (num == 11) {
                value = "D4";
                tempCards.add(new Card(value, "BL"));
                tempCards.add(new Card(value, "BL"));
                tempCards.add(new Card(value, "BL"));
                tempCards.add(new Card(value, "BL"));
                continue;
            }

            for (colorCount = 0; colorCount < 4; ++colorCount) {
                if (colorCount == 0) tempCards.add(new Card(value, "R"));
                else if (colorCount == 1) tempCards.add(new Card(value + "", "B"));
                else if (colorCount == 2) tempCards.add(new Card(value + "", "G"));
                else if (colorCount == 3) tempCards.add(new Card(value + "", "Y"));
            }

            if (colorCount == 3) colorCount = 0;
        }

        List<Integer> range = IntStream.rangeClosed(0, 47).boxed().collect(Collectors.toList());
        Collections.shuffle(range);

        for (int i =0; i < range.size(); ++i) {
            cards.add(tempCards.get(range.get(i)));
        }

        Log.d("myapp", "deck card " + cards);
    }

    public Card getTopCard() {
        return (cards!= null && !cards.isEmpty()) ? cards.remove() : null;
    }
}
