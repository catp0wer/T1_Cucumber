package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {}

    public static WebDriver getWebDriver() {
        if (driver==null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeWebBrowser(){
        if (driver!=null){
            driver.quit();
        }
        driver = null;
    }
}
