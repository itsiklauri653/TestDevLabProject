package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;
    public static WebDriver getInstance(){
        return driver;
    }

    @Before
    public void setup(){
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
