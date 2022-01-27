/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.controller;

import blackjack.model.Croupier;
import blackjack.model.Game;
import blackjack.model.Player;
import blackjack.model.Status;
import blackjack.view.View;
import static blackjack.view.View.*;

import java.util.Objects;

/**
 *
 * @author marol
 */
public class Controller {

    private final Game game;

    /**
     * Lets the player see the visual display of the game.
     *
     * @param game decides which game to play.
     * @param view decides how to visualize it.
     */
    public Controller(Game game, View view) {
        this.game = Objects.requireNonNull(game, "Won't start alone");
    }

    public void play() throws InterruptedException {
        Player player = game.getPlayer();
        Croupier croupier = game.getCroupier();

        View.welcomeBanner();
        View.displayMessage("With how much would you like to play with ?");
        game.getDeck().shuffle();
        player.setMise(Game.requestInt());
        player.startPlaying();
        while (player.getStatus() == Status.PLAYING) {
            displayMessage("How much would you like to bet ?");
            player.setBet(Game.requestBet(player.getMise()));
            player.hit(game.getDeck());
            displayGame(player, croupier);
            croupier.hit(game.getDeck());
            displayGame(player, croupier);
            player.hit(game.getDeck());
            displayGame(player, croupier);
            croupier.hit(game.getDeck());
            displayGame(player, croupier);
            var choice = game.actionChoice();
            while (choice == 'h'||choice == 'H') {
                player.hit(game.getDeck());
                displayGame(player, croupier);
                if (player.getScore() > 21) {
                    player.newHand();
                    croupier.newHand();
                    displayMessage("You lost");
                    break;
                }
                choice = game.actionChoice();
            }
            if (choice == 's'||choice == 'S') {
                int pCrou = game.finishCroupier(player.getScore());
                if (pCrou < 21 && pCrou > player.getScore()) {
                    displayMessage("You lost");
                    player.newHand();
                    croupier.newHand();
                }
                if (pCrou == player.getScore() && pCrou <= 21) {
                    player.draw(player.getHand().getBet());
                    displayMessage("DRAW");
                    player.newHand();
                    croupier.newHand();
                } else if (pCrou>21 && player.getScore()<=21) {
                    player.won(player.getHand().getBet());
                    displayMessage("You won");
                    player.newHand();
                    croupier.newHand();
                }
            }
            if (choice == 'q'||choice == 'Q') {
                player.stop();
            }

        }

    }

}
