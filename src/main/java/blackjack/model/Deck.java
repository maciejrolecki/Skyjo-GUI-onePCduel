/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marol
 */
public class Deck {

    private List<Card> cardList;
    private int numberCards;

    public Deck() {
        cardList = new ArrayList<>();
        Value[] value = Value.values();
        Color[] color = Color.values();

        for (Color color1 : color) {
            for (Value value1 : value) {
                cardList.add(new Card(color1, value1));
                this.numberCards++;
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public boolean isEmpty() {
        return this.cardList.isEmpty();
    }

    public Card hit() {
        if (isEmpty()&&numberCards==0) {
            cardList = new Deck().cardList;
            numberCards = cardList.size();
            this.shuffle();
        }
        numberCards--;
        return cardList.remove(0);
    }

    public int size() {
        return numberCards;
    }

    @Override
    public String toString() {
        String ret = "";
        for (Card card : cardList) {
            ret += card.toString();
            ret += '\n';
        }
        return ret;
    }
}
