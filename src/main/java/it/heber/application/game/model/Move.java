/*
 * The MIT License
 * Copyright (c) 2017 Uwe Heber
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package it.heber.application.game.model;

/**
 * Type-safe object to define possible move strategies in this game.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public enum Move {
    /**
     * Option, to let the movement be determined randomly
     */
    CHANCE("Chance"), 
    
    /**
     * Option, to use "Rock" as default strategy during the game
     */
    ROCK("Rock"), 
    
    /**
     * Option, to use "Paper" as default strategy during the game
     */
    PAPER("Paper"), 
    
    /**
     * Option, to use "Scissors" as default strategy during the game
     */
    SCISSORS("Scissors");

    private final String fieldValue;

    /**
     * Private constructor - Avoids that this class can be initialized from the
     * outside
     *
     * @param value of the enumeration constant
     */
    private Move(String value) {
        fieldValue = value;
    }

    /**
     * Retruns the value from the current enumeration constant
     *
     * @return the value of the enumeration constant
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * Compares the current move with another move to determine a tie, win or
     * loss.
     *
     * @param otherMove to be compared
     * @return 1 if the current move beats the other move, -1 if the current
     * move loses against to the other move, 0 if both moves are equal
     */
    public int compareWith(Move otherMove) {
        // Tie
        if (this == otherMove) {
            return 0;
        }

        switch (this) {
            case ROCK:
                return (otherMove == SCISSORS ? 1 : -1);
            case PAPER:
                return (otherMove == ROCK ? 1 : -1);
            case SCISSORS:
                return (otherMove == PAPER ? 1 : -1);
            default:
                // should never reached
                String msg = "Illegal move '%s' for this game detected";
                throw new IllegalArgumentException(
                        String.format(msg, this.getFieldValue()));
        }
    }
}
