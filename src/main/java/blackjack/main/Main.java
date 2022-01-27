package blackjack.main;

import blackjack.model.Game;
import blackjack.controller.Controller;
import blackjack.view.View;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        var controller = new Controller(new Game(), new View());
        controller.play();
    }
}
