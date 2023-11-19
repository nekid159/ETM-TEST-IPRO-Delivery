import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tarifs extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru/catalog";
    String DELIVERY_URL = "https://idev.etm.ru/ipro3/delivery";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();

    @Test
    public void selfLessThan25() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-selfUnloading']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось найти и кликнуть по элементу", 5);
        DeliveryPageObject.CheckOneTariff("Разгрузка своими силами", "0 ₽");
    }

    @Test
    public void firstFloorRise() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-riseToTheFloor']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось найти и кликнуть по элементу", 5);
        DeliveryPageObject.CheckOneTariff("Подъем на этаж", "100 ₽");
    }
    @Test
    public void nineFloorRiseNoLift() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setTariffsWithFloorLift("45", "9", false);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось найти и кликнуть по элементу", 5);
        DeliveryPageObject.CheckOneTariff("Подъем на этаж", "1350 ₽");
    }
    @Test
    public void nineFloorRiseLift() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setTariffsWithFloorLift("45", "9", true);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось найти и кликнуть по элементу", 5);
        DeliveryPageObject.CheckOneTariff("Подъем на этаж", "100 ₽");
    }
    @Test
    public void unloadingLess50() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-unloading']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось найти и кликнуть по элементу", 5);
        DeliveryPageObject.CheckOneTariff("Разгрузка", "800 ₽");
    }

    @Test
    public void unloadingMore50() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-unloading']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//input[@data-testid='radiobox-more50']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='input-distance-unloading']", "200", "error", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось найти и кликнуть по элементу", 5);
        DeliveryPageObject.CheckOneTariff("Разгрузка", "3200 ₽");
    }
    @Test
    public void manipulator() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
        MainPageObject.waitForElementAndClick("//input[@data-testid='checkbox-manipulator']", "Не удалось найти и кликнуть по элементу", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='popup-unloading-apply']", "Не удалось найти и кликнуть по элементу", 5);
        DeliveryPageObject.CheckOneTariff("Манипулятор", "3000 ₽");
    }
}
