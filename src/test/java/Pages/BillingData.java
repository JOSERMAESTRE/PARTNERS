package Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BillingData extends Base{
    private final By CheckoutLocator = By.cssSelector("a[title='Checkout']");
    private final By FirstNameLocator = By.id("input-payment-firstname");
    private final By LastNameLocator = By.id("input-payment-lastname");
    private final By CompanyLocator = By.id("input-payment-company");
    private final By AddressFLocator = By.id("input-payment-address-1");
    private final By AddressSLocator = By.id("input-payment-address-2");
    private final By CityLocator = By.id("input-payment-city");
    private final By PoCodeLocator = By.id("input-payment-postcode");
    private final By CountryLocator = By.id("input-payment-country");
    private final By RegionLocator = By.id("input-payment-zone");
    private final By ContinueButtonLocator = By.id("button-payment-address");
    private final By ContinueButtonLocator1 = By.id("button-shipping-address");
    private final By ContinueButtonLocator2 = By.id("button-shipping-method");
    private final By ContinueButtonLocator3 = By.id("button-payment-method");
    private final By Cashlocator = By.xpath("//input[@type='radio' and @name='payment_method' and @value='cod']");
    private final By TermsLocator = By.xpath("//input[@type='checkbox' and @value='1']");
    private final By ExistingAddressLocator = By.xpath("//input[@type='radio' and @name='payment_address' and @value='existing']");
    private final By ComfirmButtonLocator = By.id("button-confirm");
    public BillingData(WebDriver driver) {
        super(driver);
    }

    public void GotoCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(CheckoutLocator)
        );
        cartElement.click();
    }

    public void BillingDataMethod(DataTable dataTable){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueButtonLocator));
        if (IsDisplayed(ExistingAddressLocator)){
            click(ContinueButtonLocator);
        }else{
            wait.until(ExpectedConditions.visibilityOfElementLocated(FirstNameLocator));
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            Map<String, String> userDetails = data.getFirst();
            Type(userDetails.get("first_name"),FirstNameLocator);
            Type(userDetails.get("last_name"),LastNameLocator);
            Type(userDetails.get("company"),CompanyLocator);
            Type(userDetails.get("address1"),AddressFLocator);
            Type(userDetails.get("address2"),AddressSLocator);
            Type(userDetails.get("city"),CityLocator);
            Type(userDetails.get("postcode"),PoCodeLocator);
            WebElement countryDropdown = driver.findElement(CountryLocator);
            Select countrySelect = new Select(countryDropdown);
            countrySelect.selectByVisibleText(userDetails.get("country"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement regionDropdown = driver.findElement(RegionLocator);
            Select regionSelect = new Select(regionDropdown);
            regionSelect.selectByVisibleText(userDetails.get("region"));
            click(ContinueButtonLocator);
        }

    }

    public void DeliveryDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueButtonLocator1));
        click(ContinueButtonLocator1);
    }

    public void DeliveryMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueButtonLocator2));
        Type("Everything is ok",By.name("comment"));
        click(ContinueButtonLocator2);
    }
    public void PaymentMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TermsLocator));
        click(Cashlocator);
        click(TermsLocator);
        click(ContinueButtonLocator3);
    }
    public void ComfirmButtonMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ComfirmButtonLocator));
        click(ComfirmButtonLocator);
    }
}
