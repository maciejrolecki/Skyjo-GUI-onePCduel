/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

/**
 * Enumeration representing the value of a Card.
 *
 * @author marol
 */
public enum Value {
    ACE("As", 1, "A"), TWO("Deux", 2, "2"), THREE("Trois", 3, "3"), FOUR("Quatre", 4, "4"), FIVE("Cinq", 5, "5"),
    SIX("Six", 6, "6"), SEVEN("Sept", 7, "7"), EIGHT("Huit", 8, "8"), NINE("Neuf", 9, "9"), TEN("Dix", 10, "10"),
    JACK("Valet", 10, "J"), QUEEN("Dame", 10, "Q"), KING("Roi", 10, "K");

    /**
     * A constructor for a new enumeration of type Value.
     * 
     * @param name a name for the corresponding card.
     * @param val  a possible value.
     */
    private Value(String name, int val, String valD) {
        this.name = name;
        this.val = val;
        this.valD = valD;
    }

    public final String name;
    public final int val;
    public final String valD;

    public int getVal() {
        return val;
    }

    public String getValD() {
        return valD;
    }

    /**
     * Get the name of the enumeration.
     * 
     * @return the name of the enumeration.
     */
    @Override
    public String toString() {
        return name;
    }
}
