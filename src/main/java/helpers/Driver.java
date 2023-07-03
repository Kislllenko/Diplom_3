package helpers;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class Driver {

    public static void initDriver() {

        TestConfig.initConfig();

        // Кастомные настройки для selenide browser

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;

        Configuration.headless = TestConfig.isHeadless();

        switch (TestConfig.browser)
        {
            case "firefox":
                Configuration.browser = Browsers.FIREFOX;
                break;
            case "yandexdriver":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                options.addArguments("--remote-allow-origins=*");
                ChromeDriver driver = new ChromeDriver(options);
                setWebDriver(driver);
                break;
            default:
                Configuration.browser = Browsers.CHROME;
                break;
        }
    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void close() {
        currentDriver().quit();
    }

}
