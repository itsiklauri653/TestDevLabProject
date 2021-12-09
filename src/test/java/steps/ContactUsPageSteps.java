package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.MainPage;

import java.util.List;

import static constants.Borders.RED_BORDER;
import static constants.Colors.RED;

public class ContactUsPageSteps {
    private final ContactUsPage contactUsPage = new ContactUsPage(Hooks.getInstance());

    @When("User clicks send button")
    public void user_clicks_send_button(){
        contactUsPage.clickSendButton();
    }
    @Then("Error messages must be visible")
    public void error_messages_must_be_visible() {
        WebElement firstNameError = contactUsPage.firstNameInput()
                .findElement(By.cssSelector(".field-error"));
        Assert.assertTrue(contactUsPage.isVisible(firstNameError));
        Assert.assertEquals(firstNameError.getText(),"This field is required");

        WebElement lastNameError = contactUsPage.lastNameInput()
                .findElement(By.cssSelector(".field-error"));
        Assert.assertTrue(contactUsPage.isVisible(lastNameError));
        Assert.assertEquals(lastNameError.getText(),"This field is required");

        WebElement emailNameError = contactUsPage.emailInput()
                .findElement(By.cssSelector(".field-error"));
        Assert.assertTrue(contactUsPage.isVisible(emailNameError));
        Assert.assertEquals(emailNameError.getText(),"This field is required");

        WebElement messageTextAreaError = contactUsPage.messageTextArea()
                .findElement(By.cssSelector(".form-field-error-msg"));
        Assert.assertTrue(contactUsPage.isVisible(messageTextAreaError));
        Assert.assertEquals(messageTextAreaError.getText(),"This field is required");

        WebElement privacyCheckBoxError = contactUsPage.privacyCheckBox()
                .findElement(By.cssSelector(".form-field-error-msg"));
        Assert.assertTrue(contactUsPage.isVisible(privacyCheckBoxError));
        Assert.assertEquals(privacyCheckBoxError.getText(),"This field is required");

        List<WebElement> errorFields = contactUsPage.errorFields();
        errorFields.forEach(errorField -> {
            Assert.assertEquals(errorField.findElement(By.cssSelector(".field"))
                    .getCssValue("border"),RED_BORDER);
            Assert.assertEquals(errorField.findElement(By.cssSelector(".field-error"))
                    .getCssValue("color"),RED);
        });
    }
    @Then("Error icons must be visible")
    public void error_icons_must_be_visible() {
        WebElement firstNameErrorIcon = contactUsPage.firstNameInput()
                .findElement(By.cssSelector(".error-icn"));
        Assert.assertTrue(contactUsPage.isVisible(firstNameErrorIcon));

        WebElement lastNameErrorIcon = contactUsPage.lastNameInput()
                .findElement(By.cssSelector(".error-icn"));
        Assert.assertTrue(contactUsPage.isVisible(lastNameErrorIcon));

        WebElement emailNameErrorIcon = contactUsPage.emailInput()
                .findElement(By.cssSelector(".error-icn"));
        Assert.assertTrue(contactUsPage.isVisible(emailNameErrorIcon));
    }
    @Then("Error star icons must be visible")
    public void error_star_icons_must_be_visible() {
        List<WebElement> errorStarIcons = contactUsPage.errorStarIcons();
        errorStarIcons.forEach(errorStarIcon -> {
            Assert.assertTrue(contactUsPage.isVisible(errorStarIcon));
        });
    }
}
