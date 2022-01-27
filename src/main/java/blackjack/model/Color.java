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
public enum Color {
    CLUB("trèfle", "?", "BLACK"), DIAMOND("carreau", "?", "RED"), HEART("coeur", "?", "RED"),
    SPADE("pique", "?", "BLACK");

    public final String name;
    public final String color;
    public final String sign;

    private Color(String name, String sign, String color) {
        this.name = name;
        this.sign = sign;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getSign() {
        return sign;
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
