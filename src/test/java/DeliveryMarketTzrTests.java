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
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.SetDataForStandardMarket();
        DeliveryPageObject.CheckDataForStandardMarket();
    }

    @Test
    public void ExpressDelivery() throws InterruptedException {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.SetDataForExpressMarket();
        DeliveryPageObject.CheckDataForExpressMarket();
    }

    @Test
    public void StandardDeliveryFree() throws InterruptedException {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.SetDataForStandardMarketFree();
        DeliveryPageObject.CheckDataForStandardMarketFree();
    }

    @Test
    public void ExpressDeliveryFree() throws InterruptedException {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.SetDataForExpressMarketFree();
        DeliveryPageObject.CheckDataForExpressMarketFree();
    }

    @Test
    public void OutOfDate() throws InterruptedException {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.SetOutOfDate();
    }

}
