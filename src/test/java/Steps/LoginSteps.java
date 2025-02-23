package Steps;

import Pages.Login;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    private static WebDriver driver;
    private static Login login;

    @BeforeAll
    public static void setUp() {
        login = new Login(driver);
        driver = login.GetDriver();
    }

    @Given("user opens the login page")
    public void user_opens_the_login_page() {
        login.visit("https://opencart.abstracta.us/index.php?route=account/login");
    }

    @When("user enter {string} and {string} and user click on the login button")
    public void user_enters_credentials_and_clicks_login(String username, String password) {
        login.LoginMethod(username, password);
    }

    @Then("user should see the account page")
    public void userShouldSeeTheAccountPage() {
        Assert.assertTrue(login.IsDisplayed(By.xpath("//h2[text()='My Affiliate Account']")));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
