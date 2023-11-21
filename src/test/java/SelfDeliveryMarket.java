import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.example.Main;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SelfDeliveryMarket extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();

    @Test
    public void CheckboxesCheck() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","", 5);
        DeliveryPageObject.DisableCheckbox("checkbox-selfdelivery-etm");
        DeliveryPageObject.SearchAndCheckSelfDelivery("Римск");
        DeliveryPageObject.SearchAndCheckSelfDelivery("Железн");
        DeliveryPageObject.SearchAndCheckSelfDelivery("Тиш");
    }
}
