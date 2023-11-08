package lib.ui;
import io.qameta.allure.Attachment;
import lib.BaseSeleniumPage;
import lib.webelements.webelements;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
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

    public void SetDataForStandardMarket(){
        String tomorrowDay = MainPageObject.getTomorrowDay();
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-date']", "not found and click go-checkout-btn", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + tomorrowDay + "')]", "not found and click element of cookies", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "not found and click go-checkout-btn", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'11-20')]","not found and click element of cookies",5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'до 5 000₽')]","not found and click element of cookies",5);
        MainPageObject.waitForElementPresent("//span[contains(.,'Бесплатно при заказе от')]","not found and click element of cookies",5);
    }

    public void CheckDataForStandard(){

    }



}
