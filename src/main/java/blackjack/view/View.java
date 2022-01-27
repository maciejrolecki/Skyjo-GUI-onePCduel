/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import blackjack.model.Croupier;
import blackjack.model.Hand;
import blackjack.model.Player;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author marol
 */
public class View {

    public static void welcomeBanner() {
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("WELCOME TO BLACKJACK (SIMPLIFIED VERSION)");
        System.out.println("");
        System.out.println("=========================================");
    }

    public static void displayHand(Hand hand){
        ArrayList<ArrayList<String>> display = hand.toDisplay();
        for (int i = 0; i < display.size(); i++) {
            System.out.print(display.get(i).toString());
            System.out.println();
        }
    }

    public static  void displayMessage(String str) {
        System.out.print(str + "\n");
    }

    public static  void displayGame(Player player, Croupier croupier) throws InterruptedException {
        displayMessage("Croupier's hand");
        displayHand(croupier.getHand());
        displayMessage("Your hand");
        displayHand(player.getHand());
        displayMessage("");
        displayMessage("");
        TimeUnit.SECONDS.sleep(2);
    }
}
