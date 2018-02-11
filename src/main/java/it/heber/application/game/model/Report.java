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
 * Abstract class to define which methods a specific report must implement or
 * can be used from this class.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public abstract class Report {

    private int numberOfGames;

    /**
     * Default constructor to create a new abstract Report object.
     *
     * @param numberOfGames which are to be played
     */
    public Report(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    /**
     * Option to set the number of games to be run dynamically
     *
     * @param numberOfGames to be run
     */
    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    /**
     * Gets the number of games to be run
     *
     * @return number of games to be run
     */
    public int getNumberOfGames() {
        return numberOfGames;
    }

    /**
     * Stores the final user scores for statistics calculation and triggers the
     * printing of statistics overview.
     *
     * @param userOne with its properties
     * @param userTwo with its properties
     */
    public abstract void provideOverview(User userOne, User userTwo);

}
