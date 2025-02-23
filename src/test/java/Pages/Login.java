package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
    private final By EmailLocator = By.id("input-email");
    private final By PasswordLocator = By.id("input-password");
    private final By LoginButtonLocator = By.xpath("//input[@value='Login']");

    public Login(WebDriver driver) {
        super(driver);
    }

    public void LoginMethod(String username, String password) {
        Type(username, EmailLocator);
        Type(password, PasswordLocator);
        click(LoginButtonLocator);
    }
}
