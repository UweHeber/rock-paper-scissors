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

import it.heber.application.game.model.Move;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for testing logic of {@link Move}.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public class MoveTest {

    Move thisMove;
    Move otherMove;

    @Before
    public void setup() {
        // Add logic if necessary
    }

    /**
     * Test {@link Move#compareWith(it.heber.application.game.model.Move) } to
     * verify, whether the implemented game rules works as expected.<br>
     * <br>
     * The game ruls are:<br>
     * 1. Paper beats Rock<br>
     * 2. Rock beats Scissors<br>
     * 3. Scissors beats Paper<br>
     * <br>
     * Expectation: The rules of the game must apply and be observed equally for
     * both users (here: thisMove vs. otherMove).
     */
    @Test
    public void testCompareWith() {
        /**
         * thisMove = Move.PAPER
         */
        thisMove = Move.PAPER;
        otherMove = Move.PAPER;
        assertEquals("Compare result for Moves does not match",
                0, thisMove.compareWith(otherMove));

        // Paper beats Rock
        otherMove = Move.ROCK;
        assertEquals("Compare result for Moves does not match",
                1, thisMove.compareWith(otherMove));

        // Scissors beats Paper
        otherMove = Move.SCISSORS;
        assertEquals("Compare result for Moves does not match",
                -1, thisMove.compareWith(otherMove));

        /**
         * thisMove = Move.Rock
         */
        // Paper beats Rock
        thisMove = Move.ROCK;
        otherMove = Move.PAPER;
        assertEquals("Compare result for Moves does not match",
                -1, thisMove.compareWith(otherMove));

        // Scissors beats Paper
        otherMove = Move.SCISSORS;
        assertEquals("Compare result for Moves does not match",
                1, thisMove.compareWith(otherMove));

        /**
         * thisMove = Move.SCISSORS
         */
        // Scissors beats Paper
        thisMove = Move.SCISSORS;
        otherMove = Move.PAPER;
        assertEquals("Compare result for Moves does not match",
                1, thisMove.compareWith(otherMove));

        // Rock beats Scissors
        otherMove = Move.ROCK;
        assertEquals("Compare result for Moves does not match",
                -1, thisMove.compareWith(otherMove));

        /**
         * thisMove = Move.CHANCE
         */
        // Exception
        this.thisMove = Move.CHANCE;
        try {
            thisMove.compareWith(otherMove);
            fail("Expected exception was not occured.");
        } catch (IllegalArgumentException ex) {
            //if execution reaches here, 
            //it indicates this exception was occured.
            //so we need not handle it.
        }

    }

}
