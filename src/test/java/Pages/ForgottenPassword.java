package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPassword extends Base{
    private final By ForgottenPasswordLink = By.linkText("Forgotten Password");
    private final By EmailLocator = By.id("input-email");
    private final By ContinueButtonLocator = By.cssSelector(".btn.btn-primary");
    public ForgottenPassword(WebDriver driver) {
        super(driver);
    }

    public void ForgottenPasswordMethod(String Username){
        click(ForgottenPasswordLink);
        Type(Username,EmailLocator);
        click(ContinueButtonLocator);
    }
}
