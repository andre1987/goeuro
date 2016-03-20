package com.goeuro.testers;

import com.goeuro.enumerationtypes.SortModes;
import com.goeuro.init.SeleniumAsserter;
import com.goeuro.init.SeleniumClicker;
import com.goeuro.init.SeleniumFinder;
import junit.framework.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Tester for the search result page.
 *
 * @author Andrey Klimachev(andre.klim@gmail.com)
 * @since 0.0.1
 */
public class SearchResultTester extends AbstractTester {
    /**
     * Logger.
     */
    private static Logger logger = LoggerFactory.getLogger(SearchResultTester.class);

    /**
     * Date parser.
     */
    private SimpleDateFormat simpleDateFormat;

    /**
     * Construct tester for the main page.
     *
     * @param finder    Instance of selenium finder.
     * @param clicker   Instance of selenium clicker.
     * @param asserter  Instance of selenium asserter.
     */
    public SearchResultTester(final SeleniumFinder finder, final SeleniumClicker clicker, final SeleniumAsserter asserter) {
        super(finder, clicker, asserter);
        simpleDateFormat = new SimpleDateFormat("HH:mm");
    }

    /*****************************************************************************************************
     *                                          E D I T S                                                *
     *****************************************************************************************************/


    /*****************************************************************************************************
     *                                        C L I C K S                                                *
     *****************************************************************************************************/

    /**
     * Clicks 'Smartest' button.
     */
    public void clickSmartest() {
        clicker.clickWebElement("$('#sortby-smart').find('a')");
    }

    /**
     * Clicks 'Cheapest' button.
     */
    public void clickCheapest() {
        clicker.clickWebElement("$('#sortby-price').find('a')");
    }

    /**
     * Clicks 'Fastest' button.
     */
    public void clickFastest() {
        clicker.clickWebElement("$('#sortby-traveltime').find('a')");
    }

    /**
     * Clicks 'Departure time' button.
     */
    public void clickDepartureTime() {
        clicker.clickWebElement("$('#sortby-outboundDepartureTime').find('a')");
    }

    /**
     * Clicks 'Arrival time' button.
     */
    public void clickArrivalTime() {
        clicker.clickWebElement("$('#sortby-outboundArrivalTime').find('a')");
    }

    /*****************************************************************************************************
     *                                      A S S E R T S                                                *
     *****************************************************************************************************/

    /**
     * Assert sort button.
     *
     * @param sortMode    Sort mode.
     */
    public void assertSortButton(final SortModes sortMode) {
        switch (sortMode) {
            case SMARTEST:
                asserter.assertEqualsText("$('#sortby-smart').hasClass('active').toString()", "true", "Smartest button is selected");
                asserter.assertEqualsText("$('.analytics-sortby-price-btn:visible').parent().hasClass('active').toString()", "false", "Cheapest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-traveltime-btn:visible').parent().hasClass('active').toString()", "false", "Fastest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundDepartureTime-btn:visible').parent().hasClass('active').toString()", "false", "Departure time button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundArrivalTime-btn:visible').parent().hasClass('active').toString()", "false", "Arrival time button isn't selected");
                break;
            case CHEAPEST:
                asserter.assertEqualsText("$('#sortby-smart').hasClass('active').toString()", "false", "Smartest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-price-btn:visible').parent().hasClass('active').toString()", "true", "Cheapest button is selected");
                asserter.assertEqualsText("$('.analytics-sortby-traveltime-btn:visible').parent().hasClass('active').toString()", "false", "Fastest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundDepartureTime-btn:visible').parent().hasClass('active').toString()", "false", "Departure time button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundArrivalTime-btn:visible').parent().hasClass('active').toString()", "false", "Arrival time button isn't selected");
                break;
            case FASTEST:
                asserter.assertEqualsText("$('#sortby-smart').hasClass('active').toString()", "false", "Smartest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-price-btn:visible').parent().hasClass('active').toString()", "false", "Cheapest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-traveltime-btn:visible').parent().hasClass('active').toString()", "true", "Fastest button is selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundDepartureTime-btn:visible').parent().hasClass('active').toString()", "false", "Departure time button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundArrivalTime-btn:visible').parent().hasClass('active').toString()", "false", "Arrival time button isn't selected");
                break;
            case DEPARTURE_TIME:
                asserter.assertEqualsText("$('#sortby-smart').hasClass('active').toString()", "false", "Smartest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-price-btn:visible').parent().hasClass('active').toString()", "false", "Cheapest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-traveltime-btn:visible').parent().hasClass('active').toString()", "false", "Fastest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundDepartureTime-btn:visible').parent().hasClass('active').toString()", "true", "Departure time button is selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundArrivalTime-btn:visible').parent().hasClass('active').toString()", "false", "Arrival time button isn't selected");
                break;
            case ARRIVAL_TIME:
                asserter.assertEqualsText("$('#sortby-smart').hasClass('active').toString()", "false", "Smartest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-price-btn:visible').parent().hasClass('active').toString()", "false", "Cheapest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-traveltime-btn:visible').parent().hasClass('active').toString()", "false", "Fastest button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundDepartureTime-btn:visible').parent().hasClass('active').toString()", "false", "Departure time button isn't selected");
                asserter.assertEqualsText("$('.analytics-sortby-outboundArrivalTime-btn:visible').parent().hasClass('active').toString()", "true", "Arrival time button is selected");
                break;
            default:
                throw new RuntimeException("Provided invalid sort mode");
        }
    }

    /**
     * Assert search result table by train cheapest.
     *
     * @param sortMode    Sort mode.
     */
    public void assertSortTrain(final SortModes sortMode) {
        final String jqueryPrefix = "$('#results-train').find('.result')";
        final int numberOfResults = finder.findInt(jqueryPrefix + ".length");
        logger.info("{} trains found", numberOfResults);

        switch (sortMode) {
            case CHEAPEST: assertCheapest(jqueryPrefix, numberOfResults); break;
            case FASTEST: assertFastest(jqueryPrefix, numberOfResults); break;
            case DEPARTURE_TIME: assertDepartureTime(jqueryPrefix, numberOfResults); break;
            case ARRIVAL_TIME: assertArrivalTime(jqueryPrefix, numberOfResults); break;
        }

    }

    /**
     * Assert if the search result list is correctly sorted by price.
     *
     * @param jqueryPrefix       jquery prefix.
     * @param numberOfResults    number of search results.
     */
    private void assertCheapest(final String jqueryPrefix, final int numberOfResults) {
        double previousPrice = 0;

        for (int i = 0; i < numberOfResults; i++) {
            final String beforeCommaJquery = jqueryPrefix + ".eq(" + i + ").find('.currency-beforecomma').text().trim()";
            final String decimalJquery = jqueryPrefix + ".eq(" + i + ").find('.currency-decimals').eq(1).text().trim()";
            if (i == 0) {
                previousPrice = Double.valueOf(finder.findString(beforeCommaJquery)) + Double.valueOf(finder.findString(decimalJquery)) / 100;
            } else {
                final double currentPrice = Double.valueOf(finder.findString(beforeCommaJquery)) + Double.valueOf(finder.findString(decimalJquery)) / 100;
                if (previousPrice > currentPrice) {
                    Assert.fail("Previous price " + previousPrice + " is greater than current price " + currentPrice);
                }
                previousPrice = currentPrice;
            }
        }
    }

    /**
     * Assert if the search result list is correctly sorted by time.
     *
     * @param jqueryPrefix       jquery prefix.
     * @param numberOfResults    number of search results.
     */
    private void assertFastest(final String jqueryPrefix, final int numberOfResults) {
        long previousTimestamp = 0;
        for (int i = 0; i < numberOfResults; i++) {
            if (i == 0) {
                //find string and replace 'h' by empty then convert data to timestamp
                previousTimestamp = convertStringToTimestamp(finder.findString(jqueryPrefix + ".eq(" + i + ").find('.total-leg-time').text()").replace("h", ""));
            } else {
                final long currentTimestamp = convertStringToTimestamp(finder.findString(jqueryPrefix + ".eq(" + i + ").find('.total-leg-time').text()").replace("h", ""));
                if (previousTimestamp > currentTimestamp) {
                    Assert.fail("Previous time " + previousTimestamp+ " is greater than current time " + currentTimestamp);
                }
                previousTimestamp = currentTimestamp;
            }
        }
    }

    /**
     * Assert if the search result list is correctly sorted by departure time.
     *
     * @param jqueryPrefix       jquery prefix.
     * @param numberOfResults    number of search results.
     */
    private void assertDepartureTime(final String jqueryPrefix, final int numberOfResults) {
        long previousTimestamp = 0;
        for (int i = 0; i < numberOfResults; i++) {
            if (i == 0) {
                //find string and convert data to timestamp
                previousTimestamp = convertStringToTimestamp(finder.findString(jqueryPrefix + ".eq(" + i + ").find('.time-dep').prev().eq(0).text().trim()"));
            } else {
                final long currentTimestamp = convertStringToTimestamp(finder.findString(jqueryPrefix + ".eq(" + i + ").find('.time-dep').prev().eq(0).text().trim()"));
                if (previousTimestamp > currentTimestamp) {
                    Assert.fail("Previous departure time " + previousTimestamp+ " is greater than current departure time " + currentTimestamp);
                }
                previousTimestamp = currentTimestamp;
            }
        }
    }

    /**
     * Assert if the search result list is correctly sorted by arrival time.
     *
     * @param jqueryPrefix       jquery prefix.
     * @param numberOfResults    number of search results.
     */
    private void assertArrivalTime(final String jqueryPrefix, final int numberOfResults) {
        long previousTimestamp = 0;
        for (int i = 0; i < numberOfResults; i++) {
            if (i == 0) {
                //find string and convert data to timestamp
                previousTimestamp = convertStringToTimestamp(finder.findString(jqueryPrefix + ".eq(" + i + ").find('.departure-datetime:visible').clone().children().remove().end().text().trim()"));
            } else {
                final long currentTimestamp = convertStringToTimestamp(finder.findString(jqueryPrefix + ".eq(" + i + ").find('.departure-datetime:visible').clone().children().remove().end().text().trim()"));
                if (previousTimestamp > currentTimestamp) {
                    Assert.fail("Previous arrival time " + previousTimestamp+ " is greater than current arrival time " + currentTimestamp);
                }
                previousTimestamp = currentTimestamp;
            }
        }
    }

    /**
     * Convert string to timestamp.
     *
     * @param dateString    String to be converted.
     * @return              Timestamp.
     */
    private long convertStringToTimestamp(String dateString) {
        try {
            return simpleDateFormat.parse(dateString).getTime();
        } catch (ParseException e) {
            throw new RuntimeException("Parse exception has occurred.");
        }
    }
}
