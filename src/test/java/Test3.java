import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test3 {
    private ChromeDriver driver;
    private static final String DEMOQA_URL = "https://demoqa.com/automation-practice-form/";

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void shorTask4() {
        driver.get(DEMOQA_URL);
        WebElement genderWrapper = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='genterWrapper']/div[2]/div[1]/label"))); // GENDER
        genderWrapper.click();

        WebElement hobbyWrapper = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[1]/label"));
        hobbyWrapper.click();

        WebElement stateDropDown = driver.findElement(By.xpath("//div[@id='state']/div"));
        stateDropDown.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(stateDropDown).perform();
        getDropDownByName("NCR").click();

        WebElement cityDropDown = driver.findElement(By.xpath("//div[@id='city']/div"));
        cityDropDown.click();

        getDropDownByName("Delhi").click();
    }

    public WebElement getDropDownByName(String name) {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//div[contains(text(),'%s')]", name))));
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

}
