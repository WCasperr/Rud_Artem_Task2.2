import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test2 {
    private ChromeDriver driver;
    private static final String W3_SEARCH_URL = "https://www.google.com.ua/search?q=w3 website";
    private static final String DEMOQA_URL = "https://demoqa.com/automation-practice-form/";

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void shortTask2() {
        driver.get(W3_SEARCH_URL);
        driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div[1]/a/h3")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(W3_SEARCH_URL);
        driver.navigate().refresh();
    }

    @Test
    public void shortTask3() {
        driver.get(DEMOQA_URL);
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Artem");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Rud");
        WebElement element = driver.findElement(By.xpath("//button[@id='submit']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click(element);
    }


    @AfterTest
    public void quit() {
        driver.quit();
    }

}
