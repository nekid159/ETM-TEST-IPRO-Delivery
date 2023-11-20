package lib.ui;
import lib.BaseSeleniumPage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class DeliveryPageObject extends BaseSeleniumPage{
    MainPageObject MainPageObject = new MainPageObject();
    public void setData(String timeSelector, String weightValue, String priceValue) throws InterruptedException {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//*[@id=\"simple-tab-panel-0\"]/div/div[3]/div[1]/div/div/div/div/button", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + timeSelector + "')]", "не найден и не может нажать элемент 'cookies'", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "не найден и не может нажать кнопку 'go-checkout-btn'", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'" + weightValue + "')]", "не найден и не может нажать элемент 'cookies'", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + priceValue + "')]", "не найден и не может нажать элемент 'cookies'", 5);
    }
    public void setDataIpro(String timeSelector, String weightValue) throws InterruptedException {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//*[@id=\"simple-tab-panel-0\"]/div/div[3]/div[1]/div/div/div/div/button", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + timeSelector + "')]", "не найден и не может нажать элемент 'cookies'", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "не найден и не может нажать кнопку 'go-checkout-btn'", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'" + weightValue + "')]", "не найден и не может нажать элемент 'cookies'", 5);
    }
    public void CheckDataOneCase(String deliveryName, String deliveryTime, String plashka) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-tarif-table']")).getText().contains(deliveryName));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-tarif-table']")).getText().contains(deliveryTime));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-tarif-table']")).getText().contains(plashka));
    }
    public void CheckDataTwoCases(String deliveryName, String deliveryTime, String plashka, String secondDeliveryName, String secondDeliveryTime)
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(deliveryName));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(deliveryTime));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(plashka));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(secondDeliveryName));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(secondDeliveryTime));
    }
    public void setConfiguratorCity(String cityName, String pointName) throws InterruptedException
    {
        Thread.sleep(1000);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='configurator-delivery-address']", cityName, "error", 5);
        Thread.sleep(1000);
        MainPageObject.waitForElementPresent("//div/div[3]/div[1]/div[contains(.,'" + pointName + "')]", "not found and click element of cookies",5);
        MainPageObject.waitForElementAndClick("//div/div[3]/div[1]/div[contains(.,'" + pointName + "')]", "not found and click element of cookies",5);
    }
    public void setWeightForTariffs(String weight) throws InterruptedException {
        Thread.sleep(1500);
        MainPageObject.waitForElementAndClick("//button[@data-testid='delivery-terms-btn-calculate']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='input-order-weight']", "errowerr", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-order-weight']", weight, "error", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-calculate']", "errowerr", 5);
    }
    public void setTariffsWithFloorLift(String weight, String floor, Boolean lift) throws InterruptedException
    {
        Thread.sleep(1500);
        MainPageObject.waitForElementAndClick("//button[@data-testid='delivery-terms-btn-calculate']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='input-order-weight']", "errowerr", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-order-weight']", weight, "error", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-calculate']", "errowerr", 5);
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-riseToTheFloor']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-elevation-floor']", floor, "error", 5);
        Thread.sleep(1000);
        if (!lift) {
            MainPageObject.waitForElementAndClick("//input[@data-testid='switch-elevator']", "errowerr", 5);

    }
        Thread.sleep(500);
    }
    public void CheckOneTariff(String tariffName, String tariffPrice) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-terms-table']")).getText().contains(tariffName));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-terms-table']")).getText().contains(tariffPrice));

    }


}
