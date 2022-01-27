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
public class Player {

    private Hand hand;
    private int mise;
    private Status status;

    public Player() {
        hand = new Hand();
        this.mise = 0;
        status = Status.PLAYING;
    }

    public void hit(Deck deck) {
        this.hand.add(deck.hit());
    }

    public int getMise() {
        return mise;
    }
    
    public void setMise(int amount) {
        mise = amount;
    }
public void setBet(int amount){
    mise -= amount;
    this.hand.setBet(amount);
}
    public Hand getHand() {
        return hand;
    }

    public void newHand() {
        this.hand = new Hand();
    }

    public int getScore(){
        return hand.points();
    }

    public void startPlaying(){
        status = Status.PLAYING;
    }

    public void won(int mise){
        this.mise+=(2*mise);
        
    }
    

    public void draw(int mise){
        this.mise+=mise;
    }

    public Status getStatus() {
        return status;
    }
    
    public void stop(){
        this.status= Status.QUIT;
    }
    
    
}
