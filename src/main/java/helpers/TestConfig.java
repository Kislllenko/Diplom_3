package helpers;

public class TestConfig {

    public static String browser = "yandexdriver";
    public static String headless = "0";

    public static void initConfig() {
        browser = System.getProperty("browser") == null ? browser : System.getProperty("browser");
        headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
    }

    public static boolean isHeadless() {
        return headless.contains("1");
    }
}
