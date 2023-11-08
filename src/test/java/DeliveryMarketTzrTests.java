import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.example.Main;
import org.junit.jupiter.api.Test;

public class DeliveryMarketTzrTests extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru/catalog";
    String DELIVERY_URL = "https://idev.etm.ru/ipro3/delivery";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();

    @Test
    public void StandardDelivery() throws InterruptedException {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.SetDataForStandardMarket();


    }





}
