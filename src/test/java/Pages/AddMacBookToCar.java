package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddMacBookToCar extends Base {

    public AddMacBookToCar(WebDriver driver) {
        super(driver);
    }

    public void AddMac(String product) {
        List<WebElement> Products = driver.findElements(By.xpath("//div[@class='product-thumb']//i[@class='fa fa-shopping-cart']"));
        if (product.equals("MacBook Pro")) {
            Products.get(3).click();
        }
    }

    public boolean SucessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        return successMessage.isDisplayed();
    }
}
