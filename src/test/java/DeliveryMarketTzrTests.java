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
    public void Case1_StandardDelivery() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.SetDataForStandardMarket();
        DeliveryPageObject.CheckDataForStandardMarket();
    }

    //@Test
    //public void Case2_ExpressDelivery()
   // {
   //     DeliveryPageObject.SetDataForExpressMarket();
    //    DeliveryPageObject.CheckDataForExpressMarket();
   // }





}
