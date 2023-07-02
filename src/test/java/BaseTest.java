import app.App;
import helpers.Driver;
import org.junit.After;
import org.junit.Before;

class BaseTest {

    protected App app;

    @Before
    public void setUp() {

        app = new App();

        Driver.initDriver();

    }

    @After
    public void tearDown() {
        Driver.close();
    }
}
