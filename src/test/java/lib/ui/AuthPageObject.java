package lib.ui;
import lib.BaseSeleniumPage;
import lib.ui.MainPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPageObject extends BaseSeleniumPage {
    private static final

    String LOGIN_MARKET="9191640883";
    String PASSWORD_MARKET="Dd17549bb";
    String LOGIN_IPRO="60004392tes";
    String PASSWORD_IPRO="alyd8965";
    MainPageObject MainPageObject = new MainPageObject();



    public void marketAuthorization() throws InterruptedException {

        Thread.sleep(500);

        MainPageObject.waitForElementAndClick("//span[contains(.,'Все понятно')]","not found and click element of cookies",5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'Все верно')]","not found and click element of city",5);
        //driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
        //driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
        driver.findElement(By.xpath("//button[@data-testid='authorization-button']")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(LOGIN_MARKET);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PASSWORD_MARKET);
        driver.findElement(By.xpath("//button[@data-testid='go-to-system']")).click();
    }
    public void iPROAuthorization(){

        driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
        driver.findElement(By.xpath("//button[@data-testid='authorization-button']")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(LOGIN_IPRO);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PASSWORD_IPRO);
        driver.findElement(By.xpath("//button[@data-testid='go-to-system']")).click();
    }
}