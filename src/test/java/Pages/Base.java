package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;// TODO Auto-generated constructor stub
    }
    public WebDriver GetDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement FindElement(By locator) {
        return driver.findElement(locator);
    }

    public void Type(String inputText, By Locator) {
        driver.findElement(Locator).sendKeys(inputText);
    }

    public void click(By Locator) {
        driver.findElement(Locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void visit(String url) {
        driver.get(url);
    }

    public boolean IsDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
