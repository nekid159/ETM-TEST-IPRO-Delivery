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

    @Test
    public void StandardDelivery() throws InterruptedException
    {
        String tomorrowDay = MainPageObject.getTomorrowDay();
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(tomorrowDay, "11-20", "до 5 000₽");
        DeliveryPageObject.CheckDataForStandardMarket();
    }

    @Test
    public void ExpressDelivery() throws InterruptedException {
        String currentDay = MainPageObject.getCurrentDay();
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(currentDay, "11-20", "до 5 000₽");
        DeliveryPageObject.CheckDataForExpressMarket();
    }

    @Test
    public void StandardDeliveryFree() throws InterruptedException {
        String tomorrowDay = MainPageObject.getTomorrowDay();
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(tomorrowDay, "11-20", "более 5 000₽");
        DeliveryPageObject.CheckDataForStandardMarketFree();
    }

    @Test
    public void ExpressDeliveryFree() throws InterruptedException {
        String currentDay = MainPageObject.getCurrentDay();
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(currentDay, "11-20", "более 5 000₽");
        DeliveryPageObject.CheckDataForExpressMarketFree();
    }

    @Test
    public void OutOfDate() throws InterruptedException {
        String closestSunday = MainPageObject.getClosestSunday();
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setData(closestSunday, "11-20", "более 5 000₽");
        DeliveryPageObject.CheckOutOfDate();
    }

}
