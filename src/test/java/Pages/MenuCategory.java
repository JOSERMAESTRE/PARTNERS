package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuCategory extends Base {

    public MenuCategory(WebDriver driver) {
        super(driver);
    }
    public void BrowseMenu(String category, String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Esperar hasta que el elemento de la categoría esté visible y clickeable
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + category + "')]")));
        categoryElement.click();

        // Esperar hasta que el elemento de la opción esté visible y clickeable
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + option + "')]")));
        optionElement.click();
    }
}
