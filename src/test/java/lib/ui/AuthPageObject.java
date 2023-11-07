package lib.ui;
import lib.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPageObject extends BaseSeleniumPage {
    private static final

    String LOGIN_MARKET="9216572712";
    String PASSWORD_MARKET="qakras1234";
    String LOGIN_IPRO="60004392kal";
    String PASSWORD_IPRO="thqu5943";



    public void marketAuthorization(){

        driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
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