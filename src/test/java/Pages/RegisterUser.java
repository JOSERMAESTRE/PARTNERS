package Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

public class RegisterUser extends Base {
    private final By FirstNameLocator = By.id("input-firstname");
    private final By LastNameLocator = By.id("input-lastname");
    private final By EmailLocator = By.id("input-email");
    private final By TelephoneLocator = By.id("input-telephone");
    private final By PasswordLocator = By.id("input-password");
    private final By ConfirmPasswordLocator = By.id("input-confirm");
    private final By SubscribeLocator = By.xpath("//input[@type='radio' and @name='newsletter' and @value='1']");
    private final By PolicyLocator = By.xpath("//input[@type='checkbox' and @name='agree' and @value='1']");
    private final By ContinueButtonLocator = By.cssSelector(".btn.btn-primary");

    public RegisterUser(WebDriver driver) {
        super(driver);
    }

    public void RegisterUserMethod(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> userDetails = data.getFirst();
        Type(userDetails.get("firstName"),FirstNameLocator);
        Type(userDetails.get("lastName"),LastNameLocator);
        Type(userDetails.get("email"),EmailLocator);
        Type(userDetails.get("phone"),TelephoneLocator);
        Type(userDetails.get("password"),PasswordLocator);
        Type(userDetails.get("confirmPassword"),ConfirmPasswordLocator);
        click(SubscribeLocator);
        click(PolicyLocator);
        click(ContinueButtonLocator);
    }
}
