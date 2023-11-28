package lib.ui;
import lib.BaseSeleniumPage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DeliveryPageObject extends BaseSeleniumPage{
    MainPageObject MainPageObject = new MainPageObject();

    //Метод для ввода значений для доставки логина market
    public void setData(String timeSelector, String weightValue, String priceValue) throws InterruptedException
    {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//*[@id=\"simple-tab-panel-0\"]/div/div[3]/div[1]/div/div/div/div/button", "Не удалось нажать на календарь", 5);
        Thread.sleep(500);
        MainPageObject.checkMonthHasDay(timeSelector);
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + timeSelector + "')]", "Не удалось выбрать дату", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "Не удалось нажать на поле ввода веса", 5);
        MainPageObject.waitForElementAndClick("//span[contains(.,'" + weightValue + "')]", "Не удалось выбрать вес", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + priceValue + "')]", "Не удалось выбрать сумму", 5);
    }

    //Метод для ввода значений для доставки логина Ipro
    public void setDataIpro(String timeSelector, String weightValue) throws InterruptedException
    {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//*[@id=\"simple-tab-panel-0\"]/div/div[3]/div[1]/div/div/div/div/button", "Не удалось нажать на календарь", 5);
        Thread.sleep(200);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + timeSelector + "')]", "Не удалось выбрать дату", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-weight']", "Не удалось нажать на поле ввода веса", 5);
        Thread.sleep(300);
        MainPageObject.waitForElementAndClick("//span[contains(.,'" + weightValue + "')]", "Не удалось выбрать вес", 5);
    }

    //Метод проверки одного варианта вывода доставки
    public void CheckDataOneCase(String deliveryName, String deliveryTime, String plashka) throws InterruptedException
    {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-tarif-table']")).getText().contains(deliveryName));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-tarif-table']")).getText().contains(deliveryTime));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-tarif-table']")).getText().contains(plashka));
    }

    //Метод проверки двух вариантов вывода доставки
    public void CheckDataTwoCases(String deliveryName, String deliveryTime, String plashka, String secondDeliveryName, String secondDeliveryTime)
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(deliveryName));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(deliveryTime));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(plashka));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(secondDeliveryName));
        Assert.assertTrue(driver.findElement(By.xpath("//div/table[contains(.,'Вид доставки')]")).getText().contains(secondDeliveryTime));
    }

    //Метод для ввода города в конфигураторе
    public void setConfiguratorCity(String cityName, String pointName) throws InterruptedException
    {
        Thread.sleep(1000);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='configurator-delivery-address']", cityName, "Не удалось ввести город", 5);
        Thread.sleep(1000);
        MainPageObject.waitForElementPresent("//div/div[3]/div[1]/div[contains(.,'" + pointName + "')]", "Не дождались город в списке",5);
        MainPageObject.waitForElementAndClick("//div/div[3]/div[1]/div[contains(.,'" + pointName + "')]", "Не удалось выбрать город",5);
    }

    //Метод для установки веса в Услугах по разгрузке
    public void setWeightForTariffs(String weight) throws InterruptedException {
        Thread.sleep(1500);
        MainPageObject.waitForElementAndClick("//button[@data-testid='delivery-terms-btn-calculate']", "Не удалось нажать на кнопку Рассчитать", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='input-order-weight']", "Не удалось нажать на поле ввода веса", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-order-weight']", weight, "Не удалось ввести вес", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-calculate']", "Не удалось нажать на кнопку Применить", 5);
    }

    //Метод для установки веса и выборе лифта в Услугах по разгрузке
    public void setTariffsWithFloorLift(String weight, String floor, Boolean lift) throws InterruptedException
    {
        Thread.sleep(1500);
        MainPageObject.waitForElementAndClick("//button[@data-testid='delivery-terms-btn-calculate']", "Не удалось нажать на кнопку Рассчитать", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='input-order-weight']", "Не удалось нажать на поле ввода веса", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-order-weight']", weight, "Не удалось ввести вес", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-calculate']", "Не удалось нажать на кнопку Применить", 5);
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-riseToTheFloor']", "Не удалось нажать на чекбокс Подъём", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-elevation-floor']", floor, "Не удалось ввести этаж", 5);
        Thread.sleep(1000);
        if (!lift) {
            MainPageObject.waitForElementAndClick("//input[@data-testid='switch-elevator']", "Не удалось нажать на свичер лифт", 5); }
        Thread.sleep(500);
    }

    //Проверка одной услуги по разгрузке
    public void CheckOneTariff(String tariffName, String tariffPrice) throws InterruptedException
    {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-terms-table']")).getText().contains(tariffName));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='delivery-terms-table']")).getText().contains(tariffPrice));
    }

    //Метод для отключения одного чекбокса в Самовывозе
    public void DisableCheckbox(String pointType)
    {
        MainPageObject.waitForElementAndClick("//input[@data-testid='" + pointType + "']", "Не удалось отключить чекбокс пункт самовывоза", 5);
    }

    //Метод для поиска и проверки поиска в Самовывозе
    public void SearchAndCheckSelfDelivery(String cardType, String searchText) throws InterruptedException
    {
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='selfdelivery-search-input']", searchText, "Не удалось ввести название пункта", 5);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='" + cardType + "']")).getText().contains(searchText));
    }
}
