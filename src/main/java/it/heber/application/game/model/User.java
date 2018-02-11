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

import java.util.Random;

/**
 * User object, which is needed for the interaction in the game.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public class User {

    private final String userName;
    private Move strategy;
    private int score;

    /**
     * Default constructor to instantiate a new user
     *
     * @param userName the user should have
     */
    public User(String userName) {
        this.userName = userName;
        this.score = 0;
    }

    /**
     * Gets the user name
     *
     * @return name of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the game strategy, which the user has choosed
     *
     * @param strategy selected by the user for the game
     */
    public void setStrategy(Move strategy) {
        this.strategy = strategy;
    }

    /**
     * Gets the user strategy
     *
     * @return game strategy of the user
     */
    public Move getStrategy() {
        return strategy;
    }

    /**
     * Gets the user score
     *
     * @return score of the user
     */
    public int getScore() {
        return score;
    }

    /**
     * Add a score value to the current user score
     *
     * @param value which should be added to the current score
     */
    public void addScore(int value) {
        this.score += value;
    }

    /**
     * Gets the move strategy for the user in the game.
     *
     * When the user has choosen {@link Move#CHANCE} as strategy, then a random
     * move ({@link Move#ROCK} , {@link Move#PAPER} or {@link Move#SCISSORS} )
     * is determined. Otherwise, the strategy selected by the user is returned.
     *
     * @return move strategy for the user
     */
    public Move getMove() {

        if (strategy.equals(Move.CHANCE)) {
            // shuffle possible moves
            Move[] moves = {Move.ROCK, Move.PAPER, Move.SCISSORS};
            Random random = new Random();
            int index = random.nextInt(moves.length);
            return moves[index];
        }
        return strategy;
    }
}
