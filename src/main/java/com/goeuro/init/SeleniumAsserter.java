package com.goeuro.init;

import junit.framework.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Asserter class. This class is the basic class to assert basic elements (Strings, ints, etc) in the page.
 *
 * @author Andrey Klimachev(andre.klim@gmail.com)
 * @since 0.0.1
 */
public class SeleniumAsserter {
    /**
     * Logger.
     */
    private static Logger logger = LoggerFactory.getLogger(SeleniumAsserter.class);

    /**
     * Instance of selenium finder.
     */

    private SeleniumFinder finder;

    /**
     * Makes a selenium asserter.
     *
     * @param finder    Instance of selenium finder.
     */
    public SeleniumAsserter(final SeleniumFinder finder) {
        this.finder = finder;
    }

    /**
     * Asserts that a given {@code expected} text is found with the {@code jquery}.
     *
     * @param jquery      Jquery to find the text.
     * @param expected    Expected text to be found.
     * @param msg         Message for the assert.
     */
    public void assertEqualsText(final String jquery, final String expected, final String msg) {
        String found = finder.findString(jquery);
        Assert.assertEquals(msg, expected, found);
    }
}
