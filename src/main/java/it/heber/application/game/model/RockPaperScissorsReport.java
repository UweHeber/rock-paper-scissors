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

import org.apache.commons.lang3.StringUtils;

/**
 * Provides statistical information about the game.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public class RockPaperScissorsReport extends Report {
    
    private int wins;
    private int losses;
    private int ties;
    
    public RockPaperScissorsReport() {
        super(1);
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    @Override
    public void provideOverview(User userOne, User userTwo) {
        this.wins = userOne.getScore();
        this.losses = userTwo.getScore();
        this.ties = getNumberOfGames() - wins - losses;
        
        printOverview(userOne, userTwo);
    }

    /**
     * Print the statistical summary for the game history.
     */
    private void printOverview(User userOne, User userTwo) {

        StringBuilder result = new StringBuilder();
        // Line
        result.append("+").append(StringUtils.repeat("-", 111)).append("+\n");

        // Header
        result.append(getTableHeader(userOne, userTwo));

        // Line
        result.append("|").append(StringUtils.repeat("-", 16));
        result.append("+").append(StringUtils.repeat("-", 16));
        result.append("+").append(StringUtils.repeat("-", 10));
        result.append("+").append(StringUtils.repeat("-", 16));
        result.append("+").append(StringUtils.repeat("-", 24));
        result.append("+").append(StringUtils.repeat("-", 24));
        result.append("|\n");

        // Result
        result.append(getTableContent());

        // Line
        result.append("+").append(StringUtils.repeat("-", 111)).append("+\n");

        System.out.println(result.toString());
    }

    /**
     * Builds the
     *
     * @return
     */
    private String getTableHeader(User userOne, User userTwo) {
        return String.format("|  %12s  |  %12s  |  %6s  |  %12s  |  %20s  |  "
                + "%20s  |\n",
                "WINS " + userOne.getUserName(),
                "WINS " + userTwo.getUserName(), "TIES", "GAMES PLAYED",
                "WIN PERCENTAGE " + userOne.getUserName(),
                "WIN PERCENTAGE " + userTwo.getUserName());
    }

    private String getTableContent() {
        // Percentage of games won/lost using half of the ties
        double percentageWon = (wins + ((double) ties) / 2) / getNumberOfGames();
        double percentageLost = (losses + ((double) ties) / 2) / getNumberOfGames();
        
        return String.format("|  %12d  |  %12d  |  %6d  |  %12d  |  %19.2f%%  |"
                + "  %19.2f%%  |\n",
                wins,
                losses, ties, getNumberOfGames(),
                percentageWon * 100,
                percentageLost * 100);
    }
}
