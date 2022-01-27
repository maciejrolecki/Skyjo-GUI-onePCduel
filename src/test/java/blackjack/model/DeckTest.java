/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author marol
 */
public class DeckTest {
    
    @Test
    void size() {
        Deck d = new Deck();
        int expResul = 52;
        int result = d.size();
        assertEquals(result, expResul);
    }
}
