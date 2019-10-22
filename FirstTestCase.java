package scenarios;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class FirstTestCase {
    WebDriver driver;
    String baseUrl;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        baseUrl = "http://www.google.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @Test
    public void myFirstTest(){
        WebElement myWebElement = driver.findElement(By.name("q"));
        myWebElement.sendKeys("This is an amazing class!");
        if (myWebElement.isDisplayed()) {
            System.out.print("Assertion Passed Successfully");
        } else {
            System.out.print("Assertion Failed");
        }
    }
    @AfterMethod
    public void theEnd(){
        driver.quit();
    }
}
