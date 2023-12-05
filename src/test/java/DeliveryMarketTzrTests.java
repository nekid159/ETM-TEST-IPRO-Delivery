import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;

public class DeliveryMarketTzrTests extends CoreTestCase {
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();
    String tomorrowDay = MainPageObject.getTomorrowDay();
    String currentDay = MainPageObject.getCurrentDay();
    String closestSunday = MainPageObject.getClosestSunday();
    String closestMonday = MainPageObject.getClosestMonday();
    String sessionId = AuthPageObject.getCurrentSession("9160058830", "Dd17549bb");

    //Стандартная доставка
    @Test
    public void StandardDelivery() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.AddCoockie(sessionId);
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(tomorrowDay, "11-20", "до 5 000₽");
        MainPageObject.waitForElementPresent("//span[contains(.,'Бесплатно при заказе от')]","Не пришла плашка",5);
        DeliveryPageObject.CheckDataOneCase("Стандартная", tomorrowDay, "Бесплатно при заказе от");
    }

    //Экспресс доставка
    @Test
    public void ExpressDelivery() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(currentDay, "11-20", "до 5 000₽");
        MainPageObject.waitForElementPresent("//span[contains(.,'Бесплатно при заказе от')]","Не пришла плашка",5);
        DeliveryPageObject.CheckDataTwoCases("Экспресс", currentDay, "Бесплатно при заказе от", "Стандартная", tomorrowDay);
    }

    //Стандартная доставка бесплатно
    @Test
    public void StandardDeliveryFree() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(tomorrowDay, "11-20", "более 5 000₽");
        DeliveryPageObject.CheckDataOneCase("Стандартная", tomorrowDay, "Бесплатно");
    }

    //Экспресс доставка бесплатно
    @Test
    public void ExpressDeliveryFree() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(currentDay, "11-20", "более 5 000₽");
        DeliveryPageObject.CheckDataTwoCases("Экспресс", currentDay, "Бесплатно", "Стандартная", tomorrowDay);
    }

    //Вне стандартного графика
    @Test
    public void OutOfDate() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(closestSunday, "11-20", "более 5 000₽");
        Thread.sleep(300);
        DeliveryPageObject.CheckDataTwoCases("По запросу", closestSunday, "Вне стандартного графика", "Стандартная", closestMonday);

    }
    //Вне стандартного графика (уточните у менеджера)
    @Test
    public void OutOfDateManager() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(currentDay, "11-20", "более 5 000₽");
        DeliveryPageObject.setConfiguratorCity("Ленинградская область, Ломоносовский район, Виллозское городское поселение", "Ленинградская область, Ломоносовский район, Виллозское городское поселение");
        Thread.sleep(1000);
        DeliveryPageObject.CheckDataOneCase("По запросу", "Вне стандартного графика", "Уточните у менеджера");
    }

    //Все стандартного маршрута (уточните у менеджера)
    @Test
    public void OutOfRouteManager() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setConfiguratorCity("Иркутск", "Иркутск");
        DeliveryPageObject.CheckDataOneCase("По запросу", "Вне стандартного маршрута", "Уточните у менеджера");
    }

}
