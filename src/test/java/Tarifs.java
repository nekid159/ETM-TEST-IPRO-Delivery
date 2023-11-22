import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;

public class Tarifs extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();

    //Своими силами
    @Test
    public void selfLessThan25() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-selfUnloading']", "Не удалось нажать на чекбокс Своими силами", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось нажать на применить", 5);
        DeliveryPageObject.CheckOneTariff("Разгрузка своими силами", "0 ₽");
    }

    //Подъём на первый этаж
    @Test
    public void firstFloorRise() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-riseToTheFloor']", "Не удалось нажать на чекбокс Подъём", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось нажать на применить", 5);
        DeliveryPageObject.CheckOneTariff("Подъем на этаж", "100 ₽");
    }

    //Подъём на девятый этаж без лифта
    @Test
    public void nineFloorRiseNoLift() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setTariffsWithFloorLift("45", "9", false);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось нажать на применить", 5);
        Thread.sleep(1000);
        DeliveryPageObject.CheckOneTariff("Подъем на этаж", "1350 ₽");
    }

    //Подъём на девятый этаж с лифтом
    @Test
    public void nineFloorRiseLift() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setTariffsWithFloorLift("45", "9", true);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось нажать на применить", 5);
        DeliveryPageObject.CheckOneTariff("Подъем на этаж", "100 ₽");
    }

    //Разгрузка менее 50
    @Test
    public void unloadingLess50() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-unloading']", "Не удалось нажать на чекбокс Разгрузка", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось нажать на применить", 5);
        DeliveryPageObject.CheckOneTariff("Разгрузка", "800 ₽");
    }

    //Разгрузка более 50
    @Test
    public void unloadingMore50() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-unloading']", "Не удалось нажать на чекбокс Разгрузка", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='radiobox-more50']", "Не удалось нажать на радиобаттон более 50", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-distance-unloading']", "200", "Не удалось ввести дистанцию", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось нажать на применить", 5);
        DeliveryPageObject.CheckOneTariff("Разгрузка", "3200 ₽");
    }

    //Манипулятор
    @Test
    public void manipulator() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-manipulator']", "Не удалось нажать на чекбокс Манипулятор", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось нажать на применить", 5);
        DeliveryPageObject.CheckOneTariff("Манипулятор", "3000 ₽");
    }
}
