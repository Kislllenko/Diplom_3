import app.App;
import app.pojo.CreateUserJson;
import helpers.Driver;
import org.junit.After;
import org.junit.Before;

class BaseTest {

    protected App app;

    CreateUserJson createUser = new CreateUserJson("kislenko-s@yandex.ru", "1Qwe%G", "Kislenko");

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
