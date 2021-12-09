package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openTestDevLabPage(){
        open("https://www.testdevlab.com/");
    }

    public List<WebElement> subMenuItems(){
        return findElements(By.cssSelector(".sub-menu"));
    }

    public List<WebElement> subSectionItems(WebElement subMenu){
        return subMenu.findElements(By.cssSelector(".link-name"));
    }

    public void clickContactUsButton(){
        WebElement btn = findElement(By.cssSelector(".right-side .contact-us-btn"));
        click(btn);
    }

    public void hoverOver(WebElement el){
        hoverOverElement(el);
    }
}
