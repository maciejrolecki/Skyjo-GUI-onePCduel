/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import java.util.ArrayList;

/**
 *
 * @author marol
 */
public class Card {

    private Color color;
    private Value value;
    private boolean displayable;
    String defaultColor = "\u001b[0m";
    String redBoldCharacter = "\u001b[31;1m";
    String topBottom = "-------";
    String sides = "|";
    String emptyLine = sides + "     " + sides;

    /**
     * Initializes a Card with given values if those are not null.
     *
     * @param color a given color.
     * @param value a given value.
     */
    public Card(Color color, Value value) {
        if (color != null && value != null) {
            this.color = color;
            this.value = value;
            this.displayable = true;
        } else {
            throw new IllegalArgumentException("Invalid card input");
        }
    }

    /**
     * Get the colour of a given Card.
     *
     * @return the color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Get the value of a given Card.
     *
     * @return the value.
     */
    public Value getValue() {
        return value;
    }

    public Boolean getDisplayable() {
        return displayable;
    }

    /**
     *
     * @param displayable
     */
    public void setDisplayable(Boolean displayable) {
        this.displayable = displayable;
    }

    public ArrayList<ArrayList<String>> toDisplay(ArrayList<ArrayList<String>> displ) {
        if (this.displayable == false) {
            displ.get(0).add(topBottom + "  ");
            displ.get(6).add(topBottom + "  ");
            for (int j = 1; j < 6; j++) {
                displ.get(j).add(sides + "     " + sides + "  ");
            }
        } else {
            String colorC;
            if ("RED".equals(this.getColor().getColor())) {
                colorC = redBoldCharacter;
            } else {
                colorC = defaultColor;
            }
            String sign = this.getColor().getSign();
            String valueC = this.getValue().getValD();
            displ.get(0).add(colorC + topBottom + defaultColor + "  ");
            displ.get(6).add(colorC + topBottom + defaultColor + "  ");
            displ.get(2).add(colorC + emptyLine + defaultColor + "  ");
            displ.get(4).add(colorC + emptyLine + defaultColor + "  ");
            displ.get(1).add(colorC + sides + sign + "   " + sign + sides + defaultColor + "  ");
            displ.get(5).add(colorC + sides + sign + "   " + sign + sides + defaultColor + "  ");
            if (this.getValue() == Value.TEN) {
                displ.get(3).add(colorC + sides + "  " + valueC + " " + sides + defaultColor + "  ");
            } else {
                displ.get(3).add(colorC + sides + "  " + valueC + "  " + sides + defaultColor + "  ");
            }
        }
        return displ;
    }

    /**
     *
     * @return the card value as a string;
     */
    @Override
    public String toString() {
        return value + " de " + color;
    }
}
