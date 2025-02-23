package Steps;

import Pages.ForgottenPassword;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;


public class ResetPasswordSteps {
    private static WebDriver driver;
    private static ForgottenPassword forgottenPassword;

    @BeforeAll
    public static void setUp() {
        forgottenPassword = new ForgottenPassword(driver);
        driver = forgottenPassword.GetDriver();
    }
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        forgottenPassword.visit("https://opencart.abstracta.us/index.php?route=account/login");
    }

    @When("user click forgotten pasword link and requests a password reset for {string}")
    public void user_requests_password_reset(String email) {
        forgottenPassword.ForgottenPasswordMethod(email);
    }

    @Then("user sees a confirmation message")
    public void user_sees_a_confirmation_message() {

        }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
