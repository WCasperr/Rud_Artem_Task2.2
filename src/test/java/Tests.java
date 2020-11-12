import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Tests {
    private ChromeDriver driver;
    private static final String GOOGLE_URL = "https://www.google.com/";
    private static final String W3_SEARCH_URL = "https://www.google.com.ua/search?q=w3 website";

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(GOOGLE_URL);
    }

    @Test
    public void shortTask1() {
        driver.getTitle();
        int L = driver.getTitle().length();
        System.out.println(L);
        driver.getPageSource();
        int L1 = driver.getPageSource().length();
        System.out.println(L1);
        driver.getPageSource();
    }

    @Test
    public void shortTask2() {
        driver.get(W3_SEARCH_URL);
        driver.findElement(By.xpath("//div[@class=\"LC20lb DKV0Md\"]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(W3_SEARCH_URL);
        driver.navigate().refresh();
        quit();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
