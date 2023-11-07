import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;

public class DeliveryMarketTests extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();

    public static AuthPageObject authPageObject;

    @Test
    public void check() throws InterruptedException {
        driver.get(SITE_URL);

        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();

    }





}
