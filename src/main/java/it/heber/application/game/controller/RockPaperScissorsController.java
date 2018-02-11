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
package it.heber.application.game.controller;

import it.heber.application.game.model.Move;
import it.heber.application.game.model.RockPaperScissorsReport;
import it.heber.application.game.model.User;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Provides the business logic for the game.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public class RockPaperScissorsController extends Controller {

    /**
     * Avoid duplicates for choosed strategies
     */
    private final Set<Move> strategies;

    private static final int MIN_NUMBER_OF_GAMES = 1;
    private static final int MAX_NUMBER_OF_GAMES = 30;

    /**
     * Default constructor to create a new statistics object.
     *
     * Controls the user interaction during game start up and determines the
     * required information from the user.
     *
     * @param title
     */
    public RockPaperScissorsController(String title) {
        super(title);
        this.strategies = new HashSet<>();
    }

    @Override
    public void showTitle() {
        StringBuilder result = new StringBuilder();
        result.append("\n+").append(StringUtils.repeat("-", 111)).append("+\n");
        result.append(
                String.format("|  Game for Java application:  %-79s  |\n", 
                        getTitle()));
        result.append("+").append(StringUtils.repeat("-", 111)).append("+\n");
        System.out.print(result.toString());
    }

    @Override
    public final RockPaperScissorsReport buildReportInstance() {
        RockPaperScissorsReport report = new RockPaperScissorsReport();
        /*
         * If one of the two users has selected the random selection as
         * strategy, the number of games can be defined by the user. Otherwise,
         * only one run is carried out.
         */
        if (strategies.contains(Move.CHANCE)) {
            setNumberOfGames(report);
        }
        return report;
    }

    @Override
    public final User createUser(String userName) {
        User person = new User(userName);
        setUserStrategy(person);
        return person;
    }

    /**
     * Sets the number of games desired by the user.
     *
     * If the user has entered more than 30 runs, the entry is limited to this.
     * If the user enters an integer &lt; 1, the default run count (one) is
     * used.
     *
     * @param report which must be adapted with the user input
     */
    protected void setNumberOfGames(RockPaperScissorsReport report) {
        System.out.print(getStep() + " - Please select the number of games "
                + "(allowed range: 1 to " + MAX_NUMBER_OF_GAMES + ") you want "
                + "to play: ");

        String userInput = getUserInput();

        if (StringUtils.isBlank(userInput)) {
            // use default count (MIN_NUMBER_OF_GAMES)
            return;
        }

        if (NumberUtils.isParsable(userInput)) {

            int numberOfGames = NumberUtils.toInt(userInput);

            if (numberOfGames > MAX_NUMBER_OF_GAMES) {
                report.setNumberOfGames(MAX_NUMBER_OF_GAMES);
                return;
            }

            if (numberOfGames > MIN_NUMBER_OF_GAMES) {
                report.setNumberOfGames(numberOfGames);
            }
            return;
        }

        // User has not entered a valid input. Prompt again.
        setNumberOfGames(report);
    }

    /**
     * Determine and save the user's preferred game strategy.
     *
     * @param user for whom the game strategy is to be determined and saved
     */
    protected void setUserStrategy(User user) {
        System.out.print(getStep() + " - Please select the game strategy"
                + " [C]hance, [R]ock, [P]aper or [S]cissors for "
                + user.getUserName() + ": ");

        String userInput = getUserInput().toUpperCase();

        switch (StringUtils.left(userInput, 1)) {
            case "C":
                saveStrategy(user, Move.CHANCE);
                break;
            case "R":
                saveStrategy(user, Move.ROCK);
                break;
            case "P":
                saveStrategy(user, Move.PAPER);
                break;
            case "S":
                saveStrategy(user, Move.SCISSORS);
                break;
            default:
                // User has not entered a valid input. Prompt again.
                setUserStrategy(user);
        }
    }

    /**
     * Save the selected user strategy.
     *
     * Each individual user strategy is stored in a set to remove duplicates and
     * use this as a type of dictionary to determine whether more than one run
     * per game can be selected.
     *
     * @see #buildReportInstance()
     *
     * @param user for whom the game strategy is to be saved
     * @param strategy which should be saved
     */
    private void saveStrategy(User user, Move strategy) {
        user.setStrategy(strategy);
        strategies.add(strategy);
    }

    /**
     * Helper to generate the next step entry for user interaction
     *
     * @return formatted string containing the next step für user input
     */
    private String getStep() {
        return "Step #" + String.format("%02d", (strategies.size() + 1));
    }

    /**
     * Gets the user input from console. Method is protected because it is used
     * for mocking this system call during Unit tests.
     *
     * @return user input from console
     */
    protected String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
