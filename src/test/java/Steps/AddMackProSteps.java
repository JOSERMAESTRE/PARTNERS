package Steps;

import Pages.AddMacBookToCar;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddMackProSteps {
    private static WebDriver driver;
    private static AddMacBookToCar addMacBookToCar;

    @BeforeAll
    public static void setUp() {
        addMacBookToCar = new AddMacBookToCar(driver);
        driver = addMacBookToCar.GetDriver();
    }
    @Given("user is on the Laptops & Notebooks page")
    public void user_is_on_laptops_and_notebooks_page() {
        addMacBookToCar.visit("https://opencart.abstracta.us/index.php?route=product/category&path=18");
    }

    @When("user adds {string} to the cart")
    public void user_adds_macbook_pro_to_the_cart(String productName) {
        addMacBookToCar.AddMac(productName);
    }

    @Then("user sees a success message")
    public void user_sees_a_success_message() {
        Assert.assertTrue(addMacBookToCar.SucessMessage(), "Successfully Message Displayed.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
