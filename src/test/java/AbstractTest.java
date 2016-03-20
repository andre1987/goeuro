import com.goeuro.init.GoEuroSeleniumApi;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract tester for all tests.
 *
 * @author Andrey Klimachev(andre.klim@gmail.com)
 * @since 0.0.1
 */
public abstract class AbstractTest {
    /**
     * Logger.
     */
    private static Logger logger = LoggerFactory.getLogger(AbstractTest.class);

    /**
     * Rule to retrieve the test name in run time.
     */
    @Rule
    public TestName name = new TestName();

    /**
     * GoEuro selenium API used in the test.
     */
    public static GoEuroSeleniumApi api;

    /**
     * Starts the selenium driver. Must be called in the @Before method of all tests.
     */
    public void initDriver() {
        if(api == null) {
            api = new GoEuroSeleniumApi();
            api.init();
        }
    }

    /**
     * Quites the selenium web driver. Must be called in the @After method of all tests.
     */
    public void quitDriver() {
        api.quitDriver();
        api = null;
    }
}
