package com.example.unocards;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {
    TextView firstCard, secondCard, thirdCard, fourthCard;
    TextView firstNum, secondNum, thirdNum, fourthNum;
    Player player = new Player("Tom", "Va", null, null);


    Deck deck = new Deck();
    Deck pile = new Deck();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Card card1 = deck.getTopCard();
        Card card2 = deck.getTopCard();
        Card card3 = deck.getTopCard();
        Card card4 = deck.getTopCard();

        firstCard = findViewById(R.id.textViewCard1);
        secondCard = findViewById(R.id.textViewCard2);
        thirdCard = findViewById(R.id.textViewCard3);
        fourthCard = findViewById(R.id.textViewCard4);
        firstNum = findViewById(R.id.textViewNum1);
        secondNum = findViewById(R.id.textViewNum2);
        thirdNum = findViewById(R.id.textViewNum3);
        fourthNum = findViewById(R.id.textViewNum4);

        drawFromDeck(7);

        onClickDeck();

        onClickPlayerCard();
    }

    private void onClickPlayerCard() {
            findViewById(R.id.textViewCard4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int lastCard = 3;
                    if (player.cards.get(3).getValue().equalsIgnoreCase("D4")) {
                        player.cards.remove(0);
                        player.cards.remove(0);
                        player.cards.remove(0);
                        lastCard = 0;
                    }
                    Card card  = player.cards.remove(lastCard);
                    findViewById(R.id.textViewPileCard).setVisibility(View.VISIBLE);
                    findViewById(R.id.textViewPileNum).setVisibility(View.VISIBLE);
                    updateUICard(card, findViewById(R.id.textViewPileCard), findViewById(R.id.textViewPileNum));

                    Card c1 = null;
                    Card c2 = null;
                    Card c3 = null;
                    Card c4 = null;
                    for (int i = 0; i < player.cards.size(); ++i) {
                        if (i == 0)  c1 = player.getCard(i);
                        else if (i == 1) c2 = player.getCard(i);
                        else if (i == 2) c3 = player.getCard(i);
                        else if (i == 3) c4 = player.getCard(i);
                    }
                    updateUIPlayerCards(c1, c2, c3, c4);
                }
            });
    }

    private void onClickDeck() {
        findViewById(R.id.textViewDeck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawFromDeck(1);
            }
        });
    }

    private void drawFromDeck(int numOfCards) {
        if (numOfCards > deck.cards.size())
            numOfCards = deck.cards.size();

        List<Card> tempCards = new ArrayList<>();
        for (int i = 0; i < numOfCards; ++i) {
            tempCards.add(deck.getTopCard());
        }

        for (int i = 0; i < tempCards.size(); ++i) {
            if (player.getCards().size() == 0)
                player.getCards().add(tempCards.get(i));
            else if (player.getCards().size() >= 4 && numOfCards == 1) {
                player.getCards().add(3, tempCards.get(i));
            }
            else {
                int curIndexWithoutCard = player.cards.size();
                player.getCards().add(curIndexWithoutCard, tempCards.get(i));
            }
        }

        updateUIPlayerCards(player.cards.size() > 0 ? player.getCard(0): null,
                player.cards.size() > 1 ? player.getCard(1): null,
                player.cards.size() > 2 ? player.getCard(2): null,
                player.cards.size() > 3 ? player.getCard(3): null);

    }

    private void updateUIPlayerCards(Card c1, Card c2, Card c3, Card c4) {
        updateUICard(c1, firstCard, firstNum);
        updateUICard(c2, secondCard, secondNum);
        updateUICard(c3, thirdCard, thirdNum);
        updateUICard(c4, fourthCard, fourthNum);
    }

    private void updateUICard(Card c, TextView background, TextView number) {
        if (c == null) {
            background.setVisibility(View.INVISIBLE);
            number.setVisibility((View.INVISIBLE));
            return;
        }

        background.setVisibility(View.VISIBLE);
        number.setVisibility((View.VISIBLE));

        if (c.getColor().equalsIgnoreCase("BL")) { // black and draw 4
            background.setBackgroundColor(Color.parseColor("#FF000000"));
        }
        else if (c.getColor().equalsIgnoreCase("R")) {
            background.setBackgroundColor(Color.parseColor("#ff0000"));
        } else if (c.getColor().equalsIgnoreCase("B")) // blue
            background.setBackgroundColor(Color.parseColor("#0000FF"));
        else if (c.getColor().equalsIgnoreCase("G"))
            background.setBackgroundColor(Color.parseColor("#00FF00"));
        else if (c.getColor().equalsIgnoreCase("Y"))
            background.setBackgroundColor(Color.parseColor("#FFF633"));

        number.setText(c.getValue());
        number.setTextColor(Color.parseColor("#FFFFFF"));
    }
}