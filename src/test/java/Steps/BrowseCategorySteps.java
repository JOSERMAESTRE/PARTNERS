package Steps;

import Pages.MenuCategory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class BrowseCategorySteps {
    private static WebDriver driver;
    private static MenuCategory menuCategory;

    @BeforeAll
    public static void setUp() {
        menuCategory = new MenuCategory(driver);
        driver = menuCategory.GetDriver();
    }

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        menuCategory.visit("https://opencart.abstracta.us/index.php?route=common/home");
    }


    @When("user navigates to {string} and selects {string}")
    public void user_navigates_and_selects(String category, String option) {
        menuCategory.BrowseMenu(category,option);
    }

    @Then("user sees all available laptops and notebooks")
    public void user_sees_all_available_laptops_and_notebooks() {
        Assert.assertTrue(menuCategory.IsDisplayed(By.xpath("//h2[text()='Laptops & Notebooks']")));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
