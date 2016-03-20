package com.goeuro.testers;

import com.goeuro.init.SeleniumAsserter;
import com.goeuro.init.SeleniumClicker;
import com.goeuro.init.SeleniumFinder;

/**
 * Tester for the main page.
 *
 * @author Andrey Klimachev(andre.klim@gmail.com)
 * @since 0.0.1
 */
public class MainPageTester extends AbstractTester {

    /**
     * Construct tester for the main page.
     *
     * @param finder    Instance of selenium finder.
     * @param clicker   Instance of selenium clicker.
     * @param asserter  Instance of selenium asserter.
     */
    public MainPageTester(final SeleniumFinder finder, final SeleniumClicker clicker, final SeleniumAsserter asserter) {
        super(finder, clicker, asserter);
    }

    /*****************************************************************************************************
     *                                          E D I T S                                                *
     *****************************************************************************************************/

    /**
     * Edits from filter.
     *
     * @param from  Exact name of from place.
     */
    public void editFrom(final String from) {
        clicker.sendKeysToWebElement("$('#from_filter')", from);
    }

    /**
     * Edits to filter.
     *
     * @param to    Exact name of to place.
     */
    public void editTo(final String to) {
        clicker.sendKeysToWebElement("$('#to_filter')", to);
    }

    /**
     * Edit number of people.
     *
     * @param adults    Number of adults.
     * @param children  Number of children.
     * @param infants   Number of infants.
     */
    public void editPeople(final int adults, final int children, final int infants) {
        //click to open popover
        clicker.clickWebElement("$('#person-counter')");
        //1 adult is defined by default
        for (int i = 0; i < adults - 1; i++) {
            clicker.clickWebElement("$('.popover-content').find('.expand').eq(0).find('.analytics-spinner-right-btn')");
        }

        //edit number of children
        for (int i = 0; i < children; i++) {
            clicker.clickWebElement("$('.popover-content').find('.expand').eq(1).find('.analytics-spinner-right-btn')");
        }

        //edit number of infants
        for (int i = 0; i < infants; i++) {
            clicker.clickWebElement("$('.popover-content').find('.expand').eq(2).find('.analytics-spinner-right-btn')");
        }

        //click to close popover
        clicker.clickWebElement("$('body')");
    }

    /*****************************************************************************************************
     *                                        C L I C K S                                                *
     *****************************************************************************************************/

    /**
     * Clicks rount-trip button
     */
    public void clickRoundTrip() {
        clicker.clickWebElement("$('.analytics-round-trip-btn')");
    }

    /**
     * Clicks one-way button.
     */
    public void clickOneWay() {
        clicker.clickWebElement("$('.analytics-oneway-trip-btn')");
    }

    /**
     * Checks/unckecks airbnb checkbox.
     * By default the checkbox is checked.
     */
    public void clickAirbnb() {
        clicker.clickWebElement("$('label.hotel-checkbox__airbnb:visible').find('.checkbox')");
    }

    /**
     * Clicks search button.
     */
    public void clickSearch() {
        clicker.clickWebElement("$('#search-form__submit-btn')");
    }

    /*****************************************************************************************************
     *                                      A S S E R T S                                                *
     *****************************************************************************************************/

}
