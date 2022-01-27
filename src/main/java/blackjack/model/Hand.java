/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marol
 */
public class Hand {

    private List<Card> cardList;
    private int bet;

    public Hand() {
        this.cardList = new ArrayList<>();
        this.bet = 0;
    }

    public int points() {
        int tot = 0;
        for (Card card : cardList) {
            tot += card.getValue().getVal();
        }
        return tot;
    }
    
    public void add(Card card){
        this.cardList.add(card);
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
        
    }

    
    @Override
    public String toString() {
        String ret = "";
        for (Card card : cardList) {
            ret += card.toString();
            ret += "\n";
        }
        return ret;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int getSizeCardList() {
        return cardList.size();
    }

    public ArrayList<ArrayList<String>>  toDisplay(){
        ArrayList<ArrayList<String>>  display = new ArrayList<> ();
        for (int i = 0; i < 7; i++) {
            display.add(new ArrayList<>());
            display.get(i).add(" ");
        }
        for (Card card : cardList) {
           display = card.toDisplay(display);
        }
        return display;
    }
}