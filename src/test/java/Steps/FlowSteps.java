package Steps;

import Pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class FlowSteps {
    private static WebDriver driver;
    private static Login login;
    private static MenuCategory menuCategory;
    private static SearchTablet searchTablet;
    private static AddMacBookToCar addMacBookToCar;
    private static ShoppinCart shoppinCart;
    private static BillingData billingData;

    @BeforeAll
    public static void setUp() {
        login = new Login(driver);
        driver = login.GetDriver();
        menuCategory = new MenuCategory(driver);
        searchTablet = new SearchTablet(driver);
        addMacBookToCar = new AddMacBookToCar(driver);
        shoppinCart = new ShoppinCart(driver);
        billingData = new BillingData(driver);
    }

    @Given("user visit on the login page")
    public void user_visit_on_the_login_page() {
        login.visit("https://opencart.abstracta.us/index.php?route=account/login");
    }

    @When("user types {string} and {string} and clicks the login button")
    public void user_types_and_clicks_login(String username, String password) {
        login.LoginMethod(username, password);
    }

    @Then("user should be redirected to the account dashboard")
    public void userShouldBeRedirectedToTheAccountDashboard() {
       Assert.assertTrue(login.IsDisplayed(By.xpath("//h2[text()='My Orders']")));
    }

    @When("user clicks on {string} and selects {string}")
    public void user_clicks_on_category_and_selects_option(String category, String option) {
        menuCategory.BrowseMenu(category, option);
    }

    @Then("user sees available laptops and notebooks")
    public void user_sees_available_items_in_category() {
        Assert.assertTrue(menuCategory.IsDisplayed(By.xpath("//h2[text()='Laptops & Notebooks']")));
    }
    @When("user places {string} in the cart")
    public void user_places_in_the_cart(String product) {
        addMacBookToCar.AddMac(product);
    }

    @Then("user receives a confirmation message")
    public void user_receives_a_confirmation_message() {
        Assert.assertTrue(addMacBookToCar.SucessMessage(), "Successfully Message Displayed.");
    }

    @When("user looks for {string} and selects the first product")
    public void user_looks_for_and_selects_the_first_product(String product) {
        searchTablet.SearchTabletMethod(product);
    }

    @Then("a confirmation message appears indicating the item has been added to the shopping cart")
    public void a_confirmation_message_appears_indicating_item_added() {
        Assert.assertTrue(searchTablet.SucessMessage(), "Successfully Message Displayed.");
    }
    @When("user goes to shopping car removes {string} and increases the {string} quantity by {int}")
    public void removeAndIncreaseQuantity(String productToRemove, String productToIncrease, int quantityIncrease) throws InterruptedException {
        shoppinCart.GotoCar();
        shoppinCart.RemoveMac(productToRemove);
        Thread.sleep(1000);
        shoppinCart.UpdateQuantity(productToIncrease,quantityIncrease);
    }
    @Then("Success message is displayed")
    public void verifySuccessMessageIsDisplayed() {
        Assert.assertTrue(shoppinCart.SucessMessage(), "Successfully Message Displayed.");
    }
    @When("user enters the following billing details:")
    public void userEntersBillingDetails(DataTable dataTable) {
        billingData.GotoCheckout();
        billingData.BillingDataMethod(dataTable);
        billingData.DeliveryDetails();
        billingData.DeliveryMethod();
        billingData.PaymentMethod();
        billingData.ComfirmButtonMethod();
    }

    @Then("message your order has been placed is displayed")
    public void verifyOrderPlacedMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Your order has been placed!']")));
        Assert.assertTrue(successMessage.isDisplayed(), "El mensaje 'Your order has been placed!' no se muestra.");
    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
