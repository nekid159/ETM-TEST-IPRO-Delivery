import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class SelfDeliveryIPRO extends CoreTestCase
{
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();


    @Test
    public void ETMSearchPoints() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']", "Не удалось перейти на Самовывоз", 5);
        DeliveryPageObject.DisableCheckbox("checkbox-selfdelivery-cdek");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0", "Мыт");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0", "Римск");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0", "Все");
    }
}