package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.MainPage;

import java.util.List;

public class MainPageSteps {
    private final MainPage mainPage = new MainPage(Hooks.getInstance());

    @Given("User navigates to Test Dev Lab Page")
    public void user_navigates_to_test_dev_lab_page() {
        mainPage.openTestDevLabPage();
    }
    @Then("Sub sections must not be visible before hovering")
    public void sub_sections_must_not_be_visible_before_hovering() {
        List<WebElement> subMenuItems = mainPage.subMenuItems();
        subMenuItems.forEach(subMenu -> {
            Assert.assertTrue(mainPage.isVisible(subMenu));
            List<WebElement> subSectionItems = mainPage.subSectionItems(subMenu);
            subSectionItems.forEach(subSection -> {
                Assert.assertFalse(mainPage.isVisible(subSection));
            });
        });
    }
    @Then("User hovers to the sub-menu and sub sections must be visible")
    public void user_hovers_to_the_sub_menu() {
        List<WebElement> subMenuItems = mainPage.subMenuItems();
        subMenuItems.forEach(subMenu -> {
            mainPage.hoverOver(subMenu);
            List<WebElement> subSectionItems = mainPage.subSectionItems(subMenu);
            subSectionItems.forEach(subSection -> {
                Assert.assertTrue(mainPage.isVisible(subSection));
            });
        });
    }

    @When("User clicks contact us button")
    public void user_clicks_contact_us_button(){
        mainPage.clickContactUsButton();
    }
}
