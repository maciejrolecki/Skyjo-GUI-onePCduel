/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

/**
 *
 * @author marol
 */
public class Croupier {

    private Hand hand;
    private int times = 0;

    public Croupier() {
        hand = new Hand();
    }

    public void hit(Deck deck) {
        if (times == 1) {
            hand.add(deck.hit());
            hand.getCardList().get(1).setDisplayable(false);
            times++;
        } else {
            hand.add(deck.hit());
            times++;
        }
    }

    public void displaySecondCard() {
        hand.getCardList().get(1).setDisplayable(true);
    }

    public Hand getHand() {
        return hand;
    }

    public int getScore() {
        return hand.points();
    }

    public void newHand() {
        this.hand = new Hand();
        this.times = 0;

    }
}
