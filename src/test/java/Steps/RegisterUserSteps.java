package Steps;

import Pages.RegisterUser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterUserSteps {
    private static WebDriver driver;
    private static RegisterUser registerUser;

    @BeforeAll
    public static void setUp() {
        registerUser = new RegisterUser(driver);
        driver = registerUser.GetDriver();
    }

    @Given("user navigates to the registration page")
    public void user_navigates_to_the_registration_page() {
        registerUser.visit("https://opencart.abstracta.us/index.php?route=account/register");
    }

    @When("user fills the registration form with the following data:")
    public void user_fills_the_registration_form_with_the_following_data(DataTable dataTable) {
        registerUser.RegisterUserMethod(dataTable);
    }

    @Then("Page shows a success message")
    public void page_shows_a_success_message() {
        Assert.assertTrue(registerUser.IsDisplayed(By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']")));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
