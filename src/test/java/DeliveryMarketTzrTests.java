import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.MainPageObject;
import org.example.Main;
import org.junit.jupiter.api.Test;

public class DeliveryMarketTzrTests extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru:3003/catalog";
    String DELIVERY_URL = "https://idev.etm.ru:3003/ipro3/delivery";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();

    @Test
    public void TzrTests() throws InterruptedException {
        String tomorrowDay = MainPageObject.getTomorrowDay();
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(2000);
        driver.get(DELIVERY_URL);
        MainPageObject.waitForElementAndClick("//input[@data-testid='configurator-delivery-date']", "not found and click go-checkout-btn", 5);
        MainPageObject.waitForElementAndClick("//button[contains(.,'" + tomorrowDay + "')]", "not found and click element of cookies", 5);
    }





}
