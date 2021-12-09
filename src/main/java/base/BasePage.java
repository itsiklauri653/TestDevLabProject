package base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    protected final WebDriver driver;

    protected BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void open(String url){
        driver.get(url);
    }

    protected void click(WebElement el) {
        waitUntil(ExpectedConditions.elementToBeClickable(el));
        el.click();
    }

    protected void clear(WebElement el) {
        waitUntil(ExpectedConditions.visibilityOf(el));
        el.clear();
    }

    protected void sendKeys(WebElement el, String value){
        waitUntil(ExpectedConditions.visibilityOf(el));
        el.sendKeys(value);
    }

    protected WebElement findElement(By selector){
        return driver.findElement(selector);
    }

    protected List<WebElement> findElements(By selector){
        return driver.findElements(selector);
    }
    private void waitUntil(ExpectedCondition<WebElement> expectedCondition){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(expectedCondition);
    }

    public boolean isVisible(WebElement el){
        try {
            waitUntil(ExpectedConditions.elementToBeClickable(el));
            return true;
        } catch (TimeoutException ex){
            return false;
        }
    }

    protected void hoverOverElement(WebElement el){
        waitUntil(ExpectedConditions.visibilityOf(el));
        Actions actions = new Actions(driver);
        actions.moveToElement(el).perform();
    }
}
