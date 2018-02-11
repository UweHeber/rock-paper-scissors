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

import it.heber.application.game.model.Report;
import it.heber.application.game.model.User;

/**
 * Abstract class to define which methods a specific controller must implement
 * or can be used from this class.
 *
 * @author Uwe Heber <uwe.heber@gmx.de>
 * @since 1.0
 */
public abstract class Controller {

    private final String title;

    /**
     * Standard constructor to create a new abstract Controller object.
     *
     * @param title of the current game
     */
    public Controller(String title) {
        this.title = title;
    }

    /**
     * Returns the title of the current game
     *
     * @return the title of the current game
     */
    public String getTitle() {
        return title;
    }

    /**
     * Formats the title of the game and displays it on the console
     */
    public abstract void showTitle();

    /**
     * Creates a report object, which holds the required information about the
     * progress of the current game.
     *
     * @return initialized report object
     */
    public abstract Report buildReportInstance();

    /**
     * Creates a new user for the game.
     *
     * @param userName of the user to be created
     * @return the newly created user with its preferred game strategy
     */
    public abstract User createUser(String userName);
}
