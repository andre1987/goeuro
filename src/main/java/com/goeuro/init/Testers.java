package com.goeuro.init;

import com.goeuro.testers.MainPageTester;
import com.goeuro.testers.SearchResultTester;
import org.openqa.selenium.WebDriver;

/**
 * An endpoint to all the testers that can be called.
 *
 * @author Andrey Klimachev(andre.klim@gmail.com)
 * @since 0.0.1
 */
public class Testers {
    /**
     * Web driver to manipulates the browser.
     */
    private WebDriver driver;

    /**
     * Manipulates jquery to find an element.
     */
    private SeleniumFinder finder;

    /**
     * Clicks in jquery element.
     */
    private SeleniumClicker clicker;

    /**
     * Asserts element in the page.
     */
    private SeleniumAsserter asserter;

    /**
     * Constructor for all resources.
     *
     * @param driver    Instance of web driver.
     * @param finder    Instance of selenium finder.
     * @param clicker   Instance of selenium clicker.
     * @param asserter  Instance of selenium asserter.
     */
    public Testers(final WebDriver driver, final SeleniumFinder finder, final SeleniumClicker clicker, final SeleniumAsserter asserter) {
        this.driver = driver;
        this.finder = finder;
        this.clicker = clicker;
        this.asserter = asserter;
    }

    /**
     * Tester for the main page.
     */
    private MainPageTester mainPageTester;

    /**
     * Tests for the search result page.
     */
    private SearchResultTester searchResultTester;

    /**
     * Gets tester for the main page.
     *
     * @return  tester for the main page.
     */
    public MainPageTester main() {
        if (mainPageTester == null) {
            mainPageTester = new MainPageTester(finder, clicker, asserter);
        }
        return mainPageTester;
    }

    /**
     * Gets tester for the search result page.
     *
     * @return  tester for the search result page.
     */
    public SearchResultTester search() {
        if (searchResultTester == null) {
            searchResultTester = new SearchResultTester(finder, clicker, asserter);
        }
        return searchResultTester;
    }
}
