package lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

abstract public class CoreTestCase {
    protected WebDriver driver;
    @BeforeEach
    public  void setUp() throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("--disable-gpu");
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }
    @AfterEach
    public void tearDown(){
        // driver.close();
        // driver.quit();
    }
}