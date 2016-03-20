import com.goeuro.enumerationtypes.SortModes;
import com.goeuro.testers.SearchResultTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains tests for the search result page.
 *
 * @author Andrey Klimachev(andre.klim@gmail.com)
 * @since 0.0.1
 */
public class SearchResultTest extends AbstractTest {
    /**
     * Logger.
     */
    private static Logger logger = LoggerFactory.getLogger(SearchResultTest.class);

    /**
     * Tester for the search result page.
     */
    private SearchResultTester tester;

    /**
     * Set up the test environment.
     *
     * @description Opens browser.
     * Fill in from form with: Berlin, Germany.
     * Fill in to form with: Prague, Czech Republic.
     * Uncheck airbnb checkbox.
     * Perform search.
     */
    @Before
    public void before() {
        initDriver();
        tester = api.tester().search();

        //fill in from and to fields, uncheck airbnb option and click search button
        api.tester().main().editFrom("Berlin, Germany");
        api.tester().main().editTo("Prague, Czech Republic");
        api.tester().main().clickAirbnb();
        api.tester().main().clickSearch();

    }

    /**
     * Quit browser.
     */
    @After
    public void after() {
        quitDriver();
    }

    /**
     * Tests the sort by price. If cheapest button is selected, the list should be sorted by price.
     *
     * @description Clicks cheapest button.
     * @assertion Assert that cheapest button is selected and that the search result list is correctly sorted by price.
     */
    @Test
    public void testCheapestSort() {
        tester.clickCheapest();
        tester.assertSortButton(SortModes.CHEAPEST);
        tester.assertSortTrain(SortModes.CHEAPEST);
    }

    /**
     * Tests the sort by time. If fastest button is selected, the list should be sorted by time.
     *
     * @description Clicks fastest button.
     * @assertion Assert that fastest button is selected and that the search result list is correctly sorted by time.
     */
    @Test
    public void testFastestSort() {
        tester.clickFastest();
        tester.assertSortButton(SortModes.FASTEST);
        tester.assertSortTrain(SortModes.FASTEST);
    }

    /**
     * Tests the sort by departure time. If departure time button is selected, the list should be sorted by departure time.
     *
     * @description Clicks departure time button.
     * @assertion Assert that departure time button is selected and that the search result list is correctly sorted by departure time.
     */
    @Test
    public void testDepartureTimeSort() {
        tester.clickDepartureTime();
        tester.assertSortButton(SortModes.DEPARTURE_TIME);
        tester.assertSortTrain(SortModes.DEPARTURE_TIME);
    }

    /**
     * Tests the sort by arrival time. If departure time button is selected, the list should be sorted by arrival time.
     *
     * @description Clicks arrival time button.
     * @assertion Assert that arrival time button is selected and that the search result list is correctly sorted by departure time.
     */
    @Test
    public void testArrivalTimeSort() {
        tester.clickArrivalTime();
        tester.assertSortButton(SortModes.ARRIVAL_TIME);
        tester.assertSortTrain(SortModes.ARRIVAL_TIME);
    }
}
