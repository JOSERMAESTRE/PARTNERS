package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchTablet extends Base{
    private final By SearchLocator = By.xpath("//input[@name='search']");
    private final By SearchButtonLocator = By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");
    public SearchTablet(WebDriver driver) {
        super(driver);
    }

    public void SearchTabletMethod(String Product){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(SearchLocator));
        searchBox.sendKeys(Product);
        click(SearchButtonLocator);
        List<WebElement> Products = driver.findElements(By.xpath("//div[@class='product-thumb']//i[@class='fa fa-shopping-cart']"));
        if (Product.equals("Samsung Galaxy Tab 10.1")) {
            Products.getFirst().click();
        }
    }

    public boolean SucessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        return successMessage.isDisplayed();
    }
}
