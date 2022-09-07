package com.example.unocards;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String firstName, lastName, email, image;

    List<Card> cards = new ArrayList<>();

    public Player(String firstName, String lastName, String email, String image) {
        this.firstName = firstName;
        this.lastName= lastName;
        this.email=email;
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
