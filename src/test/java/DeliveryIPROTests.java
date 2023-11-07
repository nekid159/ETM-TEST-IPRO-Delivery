import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;

public class DeliveryIPROTests extends CoreTestCase {
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    @Test
    public void DeliveryIproTzrTests(){
        driver.get(SITE_URL);

        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();

    }
}
