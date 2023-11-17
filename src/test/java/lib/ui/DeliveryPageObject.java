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
    public void setWeightForTariffs(String weight) throws InterruptedException
    {
        MainPageObject.waitForElementAndClick("//button[@data-testid='delivery-terms-btn-calculate']", "Не удалось найти и кликнуть по элементу", 5);
        Thread.sleep(500);
        //Alert alert = driver.switchTo().alert();
       // MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-calculate']", "errowerr", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='input-order-weight']", "errowerr", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-order-weight']", "45", "error", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-calculate']", "errowerr", 5);
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

    public void CheckOutOfDateIpro() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Стандартная"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("По запросу"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Вне стандартного графика"));

        //Assert.assertFalse(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains("Экспресс"));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getDayAfterTomorrowDay()));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(MainPageObject.getTomorrowDay()));

    }

}
