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
package it.heber.application.game;

import it.heber.application.game.controller.Controller;
import it.heber.application.game.controller.RockPaperScissorsController;
import it.heber.application.game.model.Move;
import it.heber.application.game.model.Report;
import it.heber.application.game.model.User;
import org.apache.commons.lang3.StringUtils;

/**
 * Main class to start the game
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public class RockPaperScissors {

    private static final String USER_ONE = "User1";
    private static final String USER_TWO = "User2";

    private final User userOne;
    private final User userTwo;

    private final Report report;
    private final Controller controller;

    /**
     * Standard constructor. Initializes the custom game controller, prints some
     * game information to system out and prepare the game for later reporting
     */
    public RockPaperScissors() {
        controller = new RockPaperScissorsController("ROCK, PAPER, SCISSORS");
        controller.showTitle();
        userOne = controller.createUser(USER_ONE);
        userTwo = controller.createUser(USER_TWO);
        report = controller.buildReportInstance();
    }

    /**
     * Starts the game, based on the user input, displays the intermediate
     * states for each run and provides a report after completion.
     */
    public void startGame() {

        System.out.println(" " + StringUtils.repeat("-", 7));

        for (int idx = 0; idx < report.getNumberOfGames(); idx++) {
            // Get moves        
            Move userOneMove = userOne.getMove();
            Move userTwoMove = userTwo.getMove();

            // Compare both moves and add score point to the winner
            int compareResult = userOneMove.compareWith(userTwoMove);
            switch (compareResult) {
                case 0: // Tie
                    System.out.println(" Run #" + String.format("%02d", (idx + 1))
                            + " - Tie!");
                    break;
                case 1: // User1 wins
                    System.out.println(" Run #" + String.format("%02d", (idx + 1))
                            + " - " + userOneMove + " beats " + userTwoMove
                            + ". User1 wins!");
                    userOne.addScore(1);
                    break;
                case -1: // User2 wins
                    System.out.println(" Run #" + String.format("%02d", (idx + 1))
                            + " - " + userTwoMove + " beats " + userOneMove
                            + ". User2 wins!");
                    userTwo.addScore(1);
                    break;
                default:
                // should never reached
                String msg = "Illegal compare result '%d' for this game detected";
                throw new IllegalArgumentException(
                        String.format(msg, compareResult));
            }
        }
        report.provideOverview(userOne, userTwo);
    }

    /**
     * Represents the entry point into the execution of this application.
     *
     * @param args which can be passed to the program. Currently no arguments
     * are evaluated/processed
     */
    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        game.startGame();
    }
}
