package Steps;

import Pages.SearchTablet;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchTabletSteps {
    private static WebDriver driver;
    private static SearchTablet searchTablet;

    @BeforeAll
    public static void setUp() {
        searchTablet = new SearchTablet(driver);
        driver = searchTablet.GetDriver();
    }

    @Given("user is on the home store page")
    public void user_is_on_the_home_store_page() {
        searchTablet.visit("https://opencart.abstracta.us/");
    }

    @When("user searches for {string} and adds the first result")
    public void user_searches_for_and_adds_the_first_result(String product) {
        searchTablet.SearchTabletMethod(product);
    }

    @Then("the message confirms item is added to the shopping cart")
    public void the_message_confirms_item_is_added_to_the_shopping_cart() {
        Assert.assertTrue(searchTablet.SucessMessage(), "Successfully Message Displayed.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
