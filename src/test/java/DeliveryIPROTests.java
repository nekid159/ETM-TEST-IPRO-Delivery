import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeliveryIPROTests extends CoreTestCase
{
    //String SITE_URL = "https://idev.etm.ru/catalog";
    String SITE_URL = "https://itest.etm.ru:3004/";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();

    String tomorrowDay = MainPageObject.getTomorrowDay();
    String currentDay = MainPageObject.getCurrentDay();
    String closestSunday = MainPageObject.getClosestSunday();
    String closestMonday = MainPageObject.getClosestMonday();
    String closestSaturday = MainPageObject.getClosestSaturday();
    LocalDate tomorrowDate = MainPageObject.getTomorrowDate();

    //Стандартная доставка
    @Test
    public void StandardDeliveryIpro() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        Thread.sleep(500);
        DeliveryPageObject.setDataIpro(tomorrowDay, "2 - 3");
        DeliveryPageObject.CheckDataOneCase("Стандартная", tomorrowDay, "В ближайшую дату");
    }

    //Экспресс-доставка
    @Test
    public void ExpressDeliveryIpro() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        Thread.sleep(500);
        DeliveryPageObject.setDataIpro(currentDay, "3 - 4");
        DeliveryPageObject.CheckDataTwoCases("Экспресс-доставка", currentDay, "День в день", "Стандартная", tomorrowDay);
    }

    //Вне стандартного графика, "Уточните у менеджера"
    @Test
    public void OutOfDateIpro() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        Thread.sleep(1000);
        DeliveryPageObject.setDataIpro(closestSunday, "3 - 4");
        Thread.sleep(500);
        DeliveryPageObject.CheckDataTwoCases("Вне стандартного графика", closestSunday, "Уточните у менеджера", "Стандартная", closestMonday);

    }

    //Вне стандартного графика со стоимостью, стандартная
    @Test
    public void OutOfDateWithPriceIpro() throws InterruptedException
    {
    driver.get(SITE_URL);
    AuthPageObject.iPROAuthorization();
    MainPageObject.goToDelivery();
    MainPageObject.setMoscowInHeader();
    DeliveryPageObject.setConfiguratorCity("Московская область, Люберцы", "Московская область, Люберцы");
    DeliveryPageObject.setDataIpro(closestSaturday, "12 - 16");
    DeliveryPageObject.CheckDataTwoCases("Вне стандартного графика", closestSaturday, "По запросу", "Стандартная", closestMonday);
    }

    //Вне стандартного маршрута
    @Test
    public void OutOfRouteIpro() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        Thread.sleep(500);
        DeliveryPageObject.setDataIpro(tomorrowDay, "свыше 50");
        DeliveryPageObject.CheckDataOneCase("Вне стандартного маршрута", tomorrowDay, "Уточните у менеджера");
    }

    //Проверка данных в конфигураторе Доставка после заполнения и перехода по табам
    @Test
    public void TransitionBetweenTabsDelivery() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.setSpbInHeader();
        MainPageObject.goToDelivery();
        Thread.sleep(700);
        DeliveryPageObject.setConfiguratorCity("Ленинградская область, Всеволожск, Садовая улица", "Россия, Ленинградская область, Всеволожск, Садовая улица");
        DeliveryPageObject.setDataIpro(tomorrowDay, "12 - 16");
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","Не удалось перейти на таб Самовывоз", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-delivery']", "Не удалось перейти на таб Доставка", 5);
        Thread.sleep(1000);
        DeliveryPageObject.SearchAndCheckConfiguratorDelivery("Россия, Ленинградская область, Всеволожск, Садовая улица",tomorrowDate, "12 - 16");
    }



}
