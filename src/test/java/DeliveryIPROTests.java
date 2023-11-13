import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;

public class DeliveryIPROTests extends CoreTestCase {
    String SITE_URL = "https://idev.etm.ru/catalog";
    String DELIVERY_URL = "https://idev.etm.ru/ipro3/delivery";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();

    String tomorrowDay = MainPageObject.getTomorrowDay();
    String currentDay = MainPageObject.getCurrentDay();
    String closestSunday = MainPageObject.getClosestSunday();
    String closestMonday = MainPageObject.getClosestMonday();
    @Test
    public void StandardDeliveryIpro() throws InterruptedException {

        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        //MainPageObject.goToDelivery();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setDataIpro(tomorrowDay,"2 - 3");
        DeliveryPageObject.CheckDataOneCase("Стандартная", tomorrowDay, "В ближайшую дату");


    }

    @Test
    public void ExpressDeliveryIpro() throws InterruptedException {
        String currentDay = MainPageObject.getCurrentDay();

        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        //MainPageObject.goToDelivery();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setDataForIpro(currentDay,"0.25 - 0.5");
        //DeliveryPageObject.SetDataForStandardIpro();
        DeliveryPageObject.CheckForExpressIpro();

    }

    @Test
    public void OutOfDateIpro() throws InterruptedException {
        String tomorrowDay = MainPageObject.getTomorrowDay();

        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        //MainPageObject.goToDelivery();
        Thread.sleep(1000);
        driver.get(DELIVERY_URL);
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setDataForIpro(tomorrowDay,"10 - 12");
        //DeliveryPageObject.SetDataForStandardIpro();
        DeliveryPageObject.CheckOutOfDateIpro();

    }

}
