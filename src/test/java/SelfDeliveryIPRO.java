import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.DeliveryPageObject;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SelfDeliveryIPRO extends CoreTestCase {
    String SITE_URL = "https://idev.etm.ru/catalog";
    AuthPageObject AuthPageObject = new AuthPageObject();
    MainPageObject MainPageObject = new MainPageObject();
    DeliveryPageObject DeliveryPageObject = new DeliveryPageObject();

    // Поиск по точкам самовывоза ЭТМ
    @Test
    public void ETMSearchPoints() throws InterruptedException {
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
    // Поиск по точкам самовывоза СДЭК
    @Test
    public void SdekSearchPoints() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.setSpbInHeader();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']","Не удалось перейти на вкладку Самовывоз", 5);
        DeliveryPageObject.DisableCheckbox("checkbox-selfdelivery-etm");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0", "Восста");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0", "Куш");
        DeliveryPageObject.SearchAndCheckSelfDelivery("selfdelivery-store-cdeck-0", "Буда");

    }
    //Чекбоксы таба Самовывоз возвращаются в дефолт после перехода по табам
    @Test
    public void TransitionBetweenTabsSelfDelivery() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']", "Не удалось перейти на таб Самовывоз", 5);
        DeliveryPageObject.DisableCheckbox("checkbox-selfdelivery-cdek");
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-delivery']", "Не удалось перейти на таб Доставка", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']", "Не удалось перейти на таб Самовывоз", 5);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-testid='checkbox-selfdelivery-etm']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-testid='checkbox-selfdelivery-cdek']")).isSelected());
    }
    //Инпут таба Самовывоз возвращается в дефолт после перехода по табам
    @Test
    public void TransitionBetweenTabsCleaningInputSelfDelivery() throws InterruptedException
    {
        driver.get(SITE_URL);
        AuthPageObject.iPROAuthorization();
        MainPageObject.goToDelivery();
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']", "Не удалось перейти на таб Самовывоз", 5);
        MainPageObject.waitForElementClearAndSendKeys("//input[@data-testid='selfdelivery-search-input']", "Шуша", "Не удалось ввести название пункта", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-delivery']", "Не удалось перейти на таб Доставка", 5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='tab-list-selfDelivery']", "Не удалось перейти на таб Самовывоз", 5);
        WebElement inputSelfDelivery = driver.findElement(By.xpath("//input[@data-testid='selfdelivery-search-input']"));
        String inputValue = inputSelfDelivery.getAttribute("value");
        Assert.assertTrue(inputValue.isEmpty());
    }
}
