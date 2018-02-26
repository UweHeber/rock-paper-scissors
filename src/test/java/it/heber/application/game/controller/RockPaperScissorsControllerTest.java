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
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Test class for testing logic of {@link RockPaperScissorsController}.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public class RockPaperScissorsControllerTest {

    private static final String TEST_USER = "Test_User";
    private User user;
    private RockPaperScissorsReport report;
    private RockPaperScissorsController controller;

    @Before
    public void setup() {
        user = new User(TEST_USER);
        report = new RockPaperScissorsReport();
        /**
         * Spy the controller to call the normal methods while tracking every
         * interaction
         */
        controller = spy(new RockPaperScissorsController("Test title"));
    }

    /**
     * Test
     * {@link RockPaperScissorsController#setUserStrategy(it.heber.application.game.model.User)}
     * to verify setting user strategy depending on the current user input.<br>
     * <br>
     * Expectation: Depending on the user input, the appropriate strategy is
     * set. In case of, the user has enterred an invalid value this method is
     * called again (recursively). Only when the user has entered the correct
     * data the method will be exited.
     */
    @Test
    public void testSetUserStrategy() {

        doReturn("rock").when(controller).getUserInput();
        controller.setUserStrategy(user);
        assertEquals("User strategy does not match",
                Move.ROCK, user.getStrategy());

        doReturn("paper").when(controller).getUserInput();
        controller.setUserStrategy(user);
        assertEquals("User strategy does not match",
                Move.PAPER, user.getStrategy());

        doReturn("sciccors").when(controller).getUserInput();
        controller.setUserStrategy(user);
        assertEquals("User strategy does not match",
                Move.SCISSORS, user.getStrategy());

        /**
         * Simulate a triple wrong input
         */
        doReturn("")
                .doReturn("any")
                .doReturn("12e")
                .doReturn("scissors")
                .when(controller).getUserInput();
        controller.setUserStrategy(user);

        // finally, setStrategy() was 7 times called within this test
        verify(controller, times(7)).setUserStrategy(user);
    }

    /**
     * Test
     * {@link RockPaperScissorsController#setNumberOfGames(it.heber.application.game.model.RockPaperScissorsReport)}
     * to verify setting number of games depending on the current user
     * input.<br>
     * <br>
     * Expectation: Depending on the user input, the number of games will be
     * set. When a user enters a value, which is lower than 1, then the default
     * minimum value of 1 run will be used. The maximum run count is limited to
     * 30, so values above this maximum will be cutted to 30. In case of, the
     * user has enterred an invalid value this method is called again
     * (recursively). Only when the user has entered the correct data the method
     * will be exited.
     */
    @Test
    public void testSetNumberOfGames() {

        // empty input, the default value will be used
        doReturn("").when(controller).getUserInput();
        controller.setNumberOfGames(report);
        assertEquals("", 1, report.getNumberOfGames());

        // values > 1, the default value will be used
        doReturn("-1").when(controller).getUserInput();
        controller.setNumberOfGames(report);
        assertEquals("", 1, report.getNumberOfGames());

        // values > 1, the default value will be used
        doReturn("0").when(controller).getUserInput();
        controller.setNumberOfGames(report);
        assertEquals("", 1, report.getNumberOfGames());

        doReturn("1").when(controller).getUserInput();
        controller.setNumberOfGames(report);
        assertEquals("", 1, report.getNumberOfGames());

        // cannot be parsed to int, the default value will be used
        doReturn("2.55").when(controller).getUserInput();
        controller.setNumberOfGames(report);
        assertEquals("", 1, report.getNumberOfGames());

        doReturn("15").when(controller).getUserInput();
        controller.setNumberOfGames(report);
        assertEquals("", 15, report.getNumberOfGames());

        doReturn("30").when(controller).getUserInput();
        controller.setNumberOfGames(report);
        assertEquals("", 30, report.getNumberOfGames());

        // max limit reached, the max limit value will be used
        doReturn("31").when(controller).getUserInput();
        controller.setNumberOfGames(report);
        assertEquals("", 30, report.getNumberOfGames());

        /**
         * Simulate a triple wrong input
         */
        doReturn("any")
                .doReturn("12e")
                .doReturn("$a1")
                .doReturn("17")
                .when(controller).getUserInput();
        controller.setNumberOfGames(report);

        // finally, setNumberOfGames() was 12 times called within this test
        verify(controller, times(12)).setNumberOfGames(report);
    }
}
