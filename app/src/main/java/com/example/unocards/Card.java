package com.example.unocards;

import java.util.Objects;

public class Card {
    private String value;
    private String color;

    public Card() {}

    public Card(String value, String color) {this.value = value; this.color = color;}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value.equals(card.value) && color.equals(card.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color);
    }

    @Override
    public String toString() {
        return "Card{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
