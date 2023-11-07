import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.MainPageObject;
import org.example.Main;
import org.junit.jupiter.api.Test;

public class DeliveryMarketTzrTests extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();

    @Test
    public void TzrTests() throws InterruptedException {
        driver.get(SITE_URL);

        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.getCurrentDay();
        MainPageObject.getTomorrowDay();
        MainPageObject.getClosestSunday();

    }





}
