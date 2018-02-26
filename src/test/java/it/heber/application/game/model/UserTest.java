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

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for testing logic of {@link User}.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public class UserTest {

    private static final String TEST_USER = "Test_User";
    private User user;

    @Before
    public void setup() {
        user = new User(TEST_USER);
    }

    /**
     * Test {@link User#getMove()} method, when user has selected a fixed
     * strategy for the game.<br>
     * <br>
     * Expectation: In case of a selected fixed strategy, this strategy must be
     * returend with method call. *
     */
    @Test
    public void testGetMoveFixedStrategy() {
        user.setStrategy(Move.ROCK);
        assertEquals("Expected Move does not match", Move.ROCK, user.getMove());
        user.setStrategy(Move.PAPER);
        assertEquals("Expected Move does not match", Move.PAPER, user.getMove());
        user.setStrategy(Move.SCISSORS);
        assertEquals("Expected Move does not match", Move.SCISSORS, user.getMove());
    }

    /**
     * Test {@link User#getMove()} method, when user has selected the Chance as
     * strategy for the game.<br>
     * <br>
     * Expectation: In case of, the user has selected the Chance, the method
     * must return one of the following strategies:<br>
     * {@link Move#ROCK}, {@link Move#PAPER}, {@link Move#SCISSORS}
     */
    @Test
    public void testGetMoveChanceStrategy() {
        user.setStrategy(Move.CHANCE);

        // all possible strategies, when user selects the Chance
        List<Move> moves = new ArrayList<>();
        moves.add(Move.ROCK);
        moves.add(Move.PAPER);
        moves.add(Move.SCISSORS);

        user.getMove();
        assertTrue("Expected Move does not match", moves.contains(user.getMove()));
    }

    /**
     * Test {@link User#addScore(int)} method.<br>
     * <br>
     * Expectation: With initial user generation, the score count must be 0.
     * After adding multiple scores, the summary must match with the expected.
     */
    @Test
    public void testAddScore() {
        assertEquals("Initial user score does not match", 0, user.getScore());
        for (int i = 0; i < 10; i++) {
            user.addScore(1);
        }
        assertEquals("Final user score does not match", 10, user.getScore());
    }
}
