import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SelfDeliveryMarket extends CoreTestCase{
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();
    String sessionId = AuthPageObject.getCurrentSession("9160058830", "Dd17549bb");

    //Поиск по точкам самовывоза СДЭК
    @Test
    public void SdekSearchCheck() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.AddCoockie(sessionId);
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","Не удалось переключиться на Самовывоз", 5);
        DeliveryPageObject.DisableCheckbox("checkbox-selfdelivery-etm");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0", "Римск");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0","Железн");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0","Тиш");
    }

    //Поиск по точкам самовывоза ЭТМ
    @Test
    public void EtmSearchCheck() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.AddCoockie(sessionId);
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","Не удалось переключиться на Самовывоз", 5);
        DeliveryPageObject.DisableCheckbox("checkbox-selfdelivery-cdek");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0","Бал");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0","Дми");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-etm-0","Кот");
    }

    //Очистка инпута при переключении по табам Доставка и Самовывоз
    @Test
    public void CleanAfterChangeTab() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.AddCoockie(sessionId);
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","Не удалось переключиться на Самовывоз", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='selfdelivery-search-input']", "Тест", "Не удалось ввести в поиск", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-delivery']","Не удалось переключиться на Доставку", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","Не удалось переключиться на Самовывоз", 5);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-testid='selfdelivery-search-input']")).getAttribute("value").contains(""));
    }
}
