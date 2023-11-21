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
    public void SdekSearchCheck() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","", 5);
        DeliveryPageObject.DisableCheckbox("checkbox-selfdelivery-etm");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0", "Римск");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0","Железн");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0","Тиш");
    }
    @Test
    public void EtmSearchCheck() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","", 5);
        DeliveryPageObject.DisableCheckbox("checkbox-selfdelivery-cdek");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0","Бал");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0","Дми");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0","Кот");
    }

    @Test
    public void CleanAfterChangeTab() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.marketAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='selfdelivery-search-input']", "Тест", "error", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-delivery']","", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","", 5);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-testid='selfdelivery-search-input']")).getAttribute("value").contains(""));
    }
}
