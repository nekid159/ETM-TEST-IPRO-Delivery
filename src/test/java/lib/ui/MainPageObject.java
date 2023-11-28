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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

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

    public void setSpbInHeader() throws InterruptedException
    {
        Thread.sleep(1000);
        waitForElementAndClick("//button[@data-testid='current-city']", "not found and click city in header", 5);
        waitForElementAndClick("//span[contains(.,'Санкт-Петербург и ЛО')]","not found and click element of spb city",5);
    }



    public void goToDelivery() throws InterruptedException
    {
        Thread.sleep(1500);
        waitForElementAndClick("//a[@data-testid='top-menu-delivery']","not found and click element of cookies",5);
    }

    public String getCurrentDay()
    {
        LocalDate currentDate = LocalDate.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        return String.valueOf(dayOfMonth);
    }
    public String getTomorrowDay()
    {
        LocalDate currentDate = LocalDate.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        int tomorrow = dayOfMonth+1;
        return String.valueOf(tomorrow);
    }

    public String getDayAfterTomorrowDay()
    {
        LocalDate currentDate = LocalDate.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        int dayAfterTomorrow = dayOfMonth+2;
        return String.valueOf(dayAfterTomorrow);
    }
    public String getClosestSunday()
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextSunday = currentDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        int dayOfMonthAgain = nextSunday.getDayOfMonth();
        return String.valueOf(dayOfMonthAgain);
    }
    public String getClosestMonday()
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextMonday = currentDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        int closestMonday = nextMonday.getDayOfMonth();
        return String.valueOf(closestMonday);
    }

    public void checkMonthHasDay(String date) {
        LocalDate currentDate = LocalDate.now();
        int today = currentDate.getDayOfMonth();
        int dayToCheck = Integer.parseInt(date);
        if (today > dayToCheck)
        {
            waitForElementAndClick("//button[@aria-label='Следующий месяц']", "Не удалось выбрать дату", 5);
        }
    }

    public WebElement waitForElementClearAndSendKeys(String xpath, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(xpath,error_message,timeoutInSeconds);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
        return element;
    }
    public WebElement waitForElementScrollAndClick(String xpath,String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(xpath,error_message,  timeoutInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        //Thread.sleep(1000);
        element.click();
        return element;
    }

    public WebElement waitForElementAndClickable(String xpath, String error_message, long timeoutInSeconds){
        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.withMessage(error_message + "\n");
        return wait.until
                (ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

    }


    public WebElement waitForElementAndSendKeys(String xpath, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(xpath,error_message,timeoutInSeconds);
        element.sendKeys(value);

        return element;

    }

    public boolean waitForElementNotPresent(String xpath, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath))
        );
    }

    public WebElement waitForElementAndClear(String xpath, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(xpath,error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
    public WebElement waitForElementLocated(String xpath, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
        );
    }
    public void clickVisible(By by ,String error_message, long timeoutInSeconds ){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        final Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }
    public void assertElementHasText(String xpath, String expected_text, String error_message) {

        long timeoutInSeconds = 0;
        WebElement element = waitForElementPresent( xpath, error_message,timeoutInSeconds);
        Assertions.assertTrue(
                element.getAttribute("text").contains(expected_text),
                error_message
        );
    }



    public void scrollWebPageUp() {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,250)");
    }


    public void scrollWebPageTillElementNotVisible(String xpath,String error_message, int max_swipes) {
        int already_swiped = 0;
        long timeoutInSeconds = 0;
        By by = null;
        WebElement element = this.waitForElementPresent(xpath, error_message,timeoutInSeconds);

        while (!this.isElementLocatedOnTheScreen(xpath)) {

            scrollWebPageUp();
            already_swiped++;
            if (already_swiped > max_swipes) {
                assertTrue(element.isDisplayed(), error_message);
            }
        }
    }




    public int getAmountOfElements(By locator) {


        List<?> elements = driver.findElements(locator);
        return elements.size();
    }

    public void assertElementNotPresent(By locator, String error_message) {

        int amount_of_elements = getAmountOfElements(locator);

        if (amount_of_elements > 0) {
            String default_message = "An element '" + locator + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public String waitForElementAndGetAttribute(String xpath, String attribute, String error_message, long timeout_in_seconds) {

        WebElement element = waitForElementPresent(xpath, error_message, timeout_in_seconds);
        return element.getAttribute(attribute);
    }

    public void assertElementPresent(By locator, String error_message) {


        if (driver.findElements(locator).size() < 1) {
            String default_message = "An element '" + locator + "' supposed to be present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }



    private boolean isElementLocatedOnTheScreen(String xpath){

        int element_location_by_y = this.waitForElementPresent(
                        xpath,
                        "Cannot find element by locator",
                        15)
                .getLocation().getY();

        {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            Object js_result = jsExecutor.executeScript("return window.pageYOffset");
            element_location_by_y -= Integer.parseInt(js_result.toString());
        }
        int screen_size_by_y = driver.manage().window().getSize().getHeight();

        return element_location_by_y < screen_size_by_y;
    }

    public boolean isElementPresent(By locator) {
        return getAmountOfElements(locator) > 0;
    }

    public void tryClickElementWithFewAttempts(String xpath, String error_message, int amount_of_attempts) {

        int current_attempts = 0;
        boolean need_more_attempts = true;

        while (need_more_attempts) {
            try {
                this.waitForElementAndClick(
                        xpath,
                        error_message,
                        10
                );
                need_more_attempts = false;
            } catch (Exception exception) {
                if (current_attempts > amount_of_attempts) {
                    this.waitForElementAndClick(
                            xpath,
                            error_message,
                            10
                    );
                }
            }
            current_attempts++;
        }
    }



    protected void clickTrashBinElementToDeleteSavedArticle(String xpath, String error_message) {

        WebElement element = this.waitForElementAndClick(xpath, error_message, 10);
    }

    public String takeScreenshot(String name) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name + "_screenshot.png";

        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken: " + path);
        } catch (Exception e) {
            System.out.println("Cannot take screenshot. Error " + e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path) {

        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
        }
        return bytes;
    }
    public int between() {
        LocalDate startInclusive = LocalDate.now().plusDays(1);
        LocalDate endExclusive = LocalDate.now().plusDays(13);
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay).getDayOfMonth();
    }
    public void twst() {
        WebElement webElement = driver.findElement(elements.buttonDateDelivery);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

    public void clickOrderDelivery() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elements.buttonDateFake));
        driver.findElement(elements.buttonDateFake).click();
        if (driver.findElement(elements.buttonDateDelivery).isDisplayed()) {
            twst();
        } else {
            return;
        }
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elements.buttonTimeDelivery));
        driver.findElement(elements.buttonTimeDelivery).click();
        if (driver.findElement(elements.buttonEightTimeDelivery).isDisplayed()) {
            driver.findElement(elements.buttonEightTimeDelivery).click();
        } else {
            return;
        }
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elements.buttonTimeEndDelivery));
        driver.findElement(elements.buttonTimeEndDelivery).click();
        if (driver.findElement(elements.buttonSixteenTimeDelivery).isDisplayed()) {
            driver.findElement(elements.buttonSixteenTimeDelivery).click();
        } else {
            return;
        }
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div/div/div/div/div/div/div/div[contains(.,'Стоимость:')]")));
        //driver.findElement(By.xpath("div[contains(.,'Стоимость: 390 руб.')]")).isDisplayed();
    }
}