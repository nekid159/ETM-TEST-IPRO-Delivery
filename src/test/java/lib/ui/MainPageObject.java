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

public class MainPageObject extends BaseSeleniumPage {
    static webelements elements = new webelements();

    public WebElement waitForElementPresent(String xpath, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.xpath(xpath);

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    public WebElement waitForElementAndClick(String xpath,String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(xpath,error_message,  timeoutInSeconds);
        element.click();

        return element;

    }

    public void goToDelivery()  {
      waitForElementPresent("//a[text()='Доставка и самовывоз']","not found and click element of cookies",5);
    }
}