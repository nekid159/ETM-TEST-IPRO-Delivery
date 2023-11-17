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
    public void StandardDeliveryIpro() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setDataIpro(tomorrowDay, "2 - 3");
        DeliveryPageObject.CheckDataOneCase("Стандартная", tomorrowDay, "В ближайшую дату");
    }

    @Test
    public void ExpressDeliveryIpro() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setDataIpro(currentDay, "3 - 4");
        DeliveryPageObject.CheckDataTwoCases("Экспресс-доставка", currentDay, "День в день", "Стандартная", tomorrowDay);
    }

    @Test
    public void OutOfDateIpro() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        DeliveryPageObject.setDataIpro(closestSunday, "3 - 4");
        DeliveryPageObject.CheckDataTwoCases("Вне стандартного графика", closestSunday, "Уточните у менеджера", "Стандартная", closestMonday);

    }

}
