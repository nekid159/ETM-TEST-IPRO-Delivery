package lib.ui;
import io.qameta.allure.Attachment;
import lib.BaseSeleniumPage;
import lib.webelements.webelements;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryPageObject extends BaseSeleniumPage{
    MainPageObject MainPageObject = new MainPageObject();
    public void setData(String timeSelector, String weightValue, String priceValue) throws InterruptedException {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-date']", "не найден и не может нажать кнопку 'go-checkout-btn'", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'" + timeSelector + "')]", "не найден и не может нажать элемент 'cookies'", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "не найден и не может нажать кнопку 'go-checkout-btn'", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'" + weightValue + "')]", "не найден и не может нажать элемент 'cookies'", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + priceValue + "')]", "не найден и не может нажать элемент 'cookies'", 5);
    }

    public void CheckDataForStandardMarket() throws InterruptedException {
        Thread.sleep(500);
        //MainPageObject.waitForElementPresent("//span[contains(.,'Бесплатно при заказе от')]","not found and click element of cookies",5);
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        Assert.assertFalse(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Экспресс"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Бесплатно при заказе от "));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getTomorrowDay()));
    }

    public void CheckDataForExpressMarket() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Экспресс"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Бесплатно при заказе от "));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getTomorrowDay()));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getCurrentDay()));
    }

    public void CheckDataForStandardMarketFree() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        Assert.assertFalse(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Экспресс"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Бесплатно"));
        //Assert.assertFalse(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("при заказе от"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getTomorrowDay()));
    }

    public void CheckDataForExpressMarketFree() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Экспресс"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Бесплатно"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getTomorrowDay()));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getCurrentDay()));
    }
    public void CheckOutOfDate() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("По запросу"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Вне стандартного графика"));
        //Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Бесплатно"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getClosestMonday()));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getClosestSunday()));
    }

    public void SetDataForExpressIpro(){
        String today = MainPageObject.getCurrentDay();
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-date']", "not found and click go-checkout-btn", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + today + "')]", "not found and click element of cookies", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "not found and click go-checkout-btn", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'0.5 - 1')]","not found and click element of cookies",5);
    }


    public void SetDataForStandardIpro(){
        String tomorrowDayForIpro = MainPageObject.getTomorrowDay();
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-date']", "not found and click go-checkout-btn", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + tomorrowDayForIpro + "')]", "not found and click element of cookies", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "not found and click go-checkout-btn", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'2 - 3')]","not found and click element of cookies",5);
    }



    public void setDataForIpro(String timeSelector, String weightValue) throws InterruptedException {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-date']", "не найден и не может нажать кнопку 'go-checkout-btn'", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'" + timeSelector + "')]", "не найден и не может нажать элемент 'cookies'", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "не найден и не может нажать кнопку 'go-checkout-btn'", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'" + weightValue + "')]", "не найден и не может нажать элемент 'cookies'", 5);
    }

    public void CheckForStandardIpro()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        //Assert.assertFalse(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Экспресс"));
        Assert.assertFalse(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("По запросу"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getDayAfterTomorrowDay()));
    }

    public void CheckForExpressIpro()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Экспресс"));

        //Assert.assertFalse(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("По запросу"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getTomorrowDay()));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getCurrentDay()));
    }

    public void CheckOutOfDateIpro()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("По запросу"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Вне стандартного графика"));

        //Assert.assertFalse(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Экспресс"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getDayAfterTomorrowDay()));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getTomorrowDay()));

    }

}
