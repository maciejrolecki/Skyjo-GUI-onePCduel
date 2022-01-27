/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import blackjack.view.View;
import java.util.Scanner;

/**
 *
 * @author marol
 */
public class Game {

    private Deck deck;
    private Croupier croupier;
    private Player player;

    public Game() {
        this.croupier = new Croupier();
        this.deck = new Deck();
        this.player = new Player();
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer() {
        return player;
    }

    public Croupier getCroupier() {
        return croupier;
    }

    public void shuffleGame() {
        deck.shuffle();
    }

    public int finishCroupier(int pointsPlayer) {
        while(croupier.getScore()<21&&croupier.getScore()<pointsPlayer){
            croupier.hit(deck);
        }
        return croupier.getScore();
    }

    public static char requestChar() {
        Scanner scanner = new Scanner(System.in);
        var in = scanner.nextLine();
        while (in.charAt(0) != 'h' && in.charAt(0) != 's' && in.charAt(0) != 'Q') {
            System.out.println("Use only proposed characters");
            in = scanner.nextLine();
        }
        return in.charAt(0);

    }

    public static int requestInt() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Only decimal numbers allowed");
            scanner.next();
        }
        return scanner.nextInt(); 
    }
    public static int requestBet(int mise) {
        var scanner = requestInt();
        while (scanner > mise) {
            System.out.println("Exceeds your budget");
            scanner = requestInt();
        }
        return scanner;
    }

    public char actionChoice() {
        View.displayMessage("What would you like to do? Press h to hit.");
        View.displayMessage("Press s to stay. Press Q to leave the game");
        return Game.requestChar();
    }
}
