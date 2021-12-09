package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSendButton(){
        WebElement btn = findElement(By.cssSelector(".send-btn"));
        click(btn);
    }

    public WebElement firstNameInput(){
        return findElement(By.xpath("//input[@id='firstName']/parent::div/parent::div"));
    }

    public WebElement lastNameInput(){
        return findElement(By.xpath("//input[@id='lastName']/parent::div/parent::div"));
    }

    public WebElement emailInput(){
        return findElement(By.xpath("//input[@id='email']/parent::div/parent::div"));
    }

    public WebElement messageTextArea(){
        return findElement(By.xpath("//textarea[@id='message']/parent::div/parent::div"));
    }

    public WebElement privacyCheckBox(){
        return findElements(By.cssSelector(".custom-checkbox-field")).get(0);
    }

    public List<WebElement> errorFields(){
        return findElements(By.cssSelector(".input-field.invalid"));
    }
}
