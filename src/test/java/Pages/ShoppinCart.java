package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppinCart extends Base{
    private final By ShoppingCarLocator = By.cssSelector("a[title='Shopping Cart']");
    public ShoppinCart(WebDriver driver) {
        super(driver);
    }

    public void GotoCar(){
        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cartElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ShoppingCarLocator)
        );

        cartElement.click();

    }

    public void RemoveMac(String product){
        WebElement productRow = driver.findElement(
                By.xpath("//tr[.//a[text()='" + product + "']]")
        );
        WebElement removeButton = productRow.findElement(
                By.xpath("//button[@data-original-title='Remove']")
        );
        removeButton.click();

    }

    public void UpdateQuantity(String product, int quiantity){
        WebElement productRowUP = driver.findElement(
                By.xpath("//tr[.//a[text()='" + product + "']]")
        );

        WebElement Quantity = productRowUP.findElement(
                By.xpath("//input[contains(@name, 'quantity')]")
        );
            String val = Quantity.getAttribute("value");
            int GetQuantity = Integer.parseInt(val);
            Quantity.clear();
            Quantity.sendKeys(String.valueOf(GetQuantity+quiantity));
        WebElement UpdateButton = productRowUP.findElement(
                By.xpath("//button[@data-original-title='Update']")
        );
        UpdateButton.click();
    }

    public boolean SucessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        return successMessage.isDisplayed();
    }

}
