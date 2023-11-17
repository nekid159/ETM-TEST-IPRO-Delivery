import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tarifs extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru/catalog";
    String DELIVERY_URL = "https://idev.etm.ru/ipro3/delivery";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();

    @Test
    public void LessThan25() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.cookiesAndCity();
        MainPageObject.goToDelivery();
        DeliveryPageObject.setWeightForTariffs("45");
    }
}
