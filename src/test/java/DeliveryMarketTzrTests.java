import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.example.Main;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeliveryMarketTzrTests extends CoreTestCase {
    String SITE_URL = "https://idev.etm.ru/catalog";
    String DELIVERY_URL = "https://idev.etm.ru/ipro3/delivery";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();
    String tomorrowDay = MainPageObject.getTomorrowDay();
    String currentDay = MainPageObject.getCurrentDay();
    String closestSunday = MainPageObject.getClosestSunday();
    String closestMonday = MainPageObject.getClosestMonday();

    @Test
    public void StandardDelivery() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(tomorrowDay, "11-20", "до 5 000₽");
        MainPageObject.waitForElementPresent("//span[contains(.,'Бесплатно при заказе от')]","not found and click element of cookies",5);
        DeliveryPageObject.CheckDataOneCase("Стандартная", tomorrowDay, "Бесплатно при заказе от");
    }

    @Test
    public void ExpressDelivery() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(currentDay, "11-20", "до 5 000₽");
        MainPageObject.waitForElementPresent("//span[contains(.,'Бесплатно при заказе от')]","not found and click element of cookies",5);
        DeliveryPageObject.CheckDataTwoCases("Экспресс", currentDay, "Бесплатно при заказе от", "Стандартная", tomorrowDay);
    }

    @Test
    public void StandardDeliveryFree() throws InterruptedException {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(tomorrowDay, "11-20", "более 5 000₽");
        DeliveryPageObject.CheckDataOneCase("Стандартная", tomorrowDay, "Бесплатно");
    }

    @Test
    public void ExpressDeliveryFree() throws InterruptedException {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(currentDay, "11-20", "более 5 000₽");
        DeliveryPageObject.CheckDataTwoCases("Экспресс", currentDay, "Бесплатно", "Стандартная", tomorrowDay);
    }

    @Test
    public void OutOfDate() throws InterruptedException {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(closestSunday, "11-20", "более 5 000₽");
        Thread.sleep(300);
        DeliveryPageObject.CheckDataTwoCases("По запросу", closestSunday, "Вне стандартного графика", "Стандартная", closestMonday);

    }
    @Test
    public void OutOfDateManager() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        Thread.sleep(1000);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(currentDay, "11-20", "более 5 000₽");
        DeliveryPageObject.setConfiguratorCity("Ленинградская область, Ломоносовский район, Виллозское городское поселение", "Ленинградская область, Ломоносовский район, Виллозское городское поселение");
        DeliveryPageObject.CheckDataOneCase("По запросу", "Вне стандартного графика", "Уточните у менеджера");
    }
    @Test
    public void OutOfRouteManager() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        DeliveryPageObject.setConfiguratorCity("Иркутск", "Россия, Иркутск");
        DeliveryPageObject.CheckDataOneCase("По запросу", "Вне стандартного маршрута", "Уточните у менеджера");
    }

}
