package lib.webelements;
import lib.ui.MainPageObject;
import org.openqa.selenium.By;


public class webelements {



    lib.ui.MainPageObject MainPageObject = new MainPageObject();
    //покупка
    public By buttonDigineticaMainDescr = By.xpath("//*[@data-testid='diginetica-main-descr-2415539']");
    public By buttonAgreeCheckbox = By.xpath("//input[@data-testid='checkbox-0']/following::input[3]");
    public By buttonSaveEstimate = By.xpath("//button[@data-testid='btn-save-as-estimate']");
    public By buttonDigineticaMainDescr8157448 = By.xpath("//*[@data-testid='diginetica-main-descr-8157448']");
    public By fieldCntInBasket = By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']");
    public By buttonAddToBasket = By.xpath("//p[contains(.,'В корзину')]");///button[@data-testid='add_to_basket_button']
    public By buttonNotistackSnackbar = By.xpath("//div/div[@id='notistack-snackbar']");
    public By buttonCurrentCity = By.xpath("//button[@data-testid='current-city']");
    public By buttonClearBasket = By.xpath("//div[@data-testid='action-item-4']");
    public By buttonYesDelete = By.xpath("//button[@data-testid='confirm-delete-yes']");
    public By buttonFastOrder = By.xpath("//button[@data-testid='btn-fast-order']");
    public By buttonOptionDeliveryPickup = By.xpath("//div[@data-testid='option-delivery'][1]");
    public By buttonOptionDelivery = By.xpath("//div[@data-testid='option-delivery'][2]");
    public By buttonDelivery = By.xpath("//div/div/div/div/div/div/div/div/div/div[contains(.,'Доставка')]");
    public By buttonDateFake = By.xpath("//input[@name='date_fake']");
    public By buttonDateDelivery = By.xpath("//span/p[contains(.,'" + MainPageObject.between() + "')]");
    public By buttonTimeDelivery = By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']");
    public By buttonEightTimeDelivery = By.xpath("//li[@data-value='8:00']");
    public By buttonTimeEndDelivery = By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']/following::div[2]");
    public By buttonSixteenTimeDelivery = By.xpath("//li[@data-value='16:00']");
    public By buttonTwelveTimeDelivery = By.xpath("//li[@data-value='12:00']");
    public By buttonNote = By.xpath("//textarea[@placeholder='Примечание']");
    public By buttonPromoCode = By.xpath("//input[@name='promocode']");
    public By buttonGoCheckout = By.xpath("//button[@data-testid='go-checkout-btn']");
    public By buttonSavePromoCode = By.xpath("//div[@data-testid='save-promo']");
    public By buttonOrder = By.xpath("//a[contains(.,'Заказы')]");
    public By buttonCarDelivery = By.xpath(" //button[@data-testid='btn-1-delivery']");
    public By buttonDeletePromoCode = By.xpath("//button[@class='style_promocode_btn_close__rygKX']");
    public By buttonUponReceipt = By.xpath("//*[@data-testid='option-payment-5']");//При получении
    public By buttonCardOnline = By.xpath("//*[@data-testid='option-payment-3']");//Картой онлайн
    public By buttonQrCode = By.xpath("//*[@data-testid='option-payment-4']");//По QR-code
    public By buttonBill = By.xpath("//*[@data-testid='option-payment-1']");//По Выписать счет
    public By fieldInn = By.xpath("//input[@data-testid='inn_org']");
    public By fieldKpp = By.xpath("//input[@data-testid='kpp_org']");
    public By buttonSetCompany = By.xpath("//button[@data-testid='set-company-button']");
    public By buttonClosePopup = By.xpath("//button[@data-testid='closePopup']");
    public By fieldNumberCard = By.xpath("//input[@id='iPAN_sub']");//номер карты
    public By fieldNumberMonth = By.xpath("//input[@id='input-month']");//номер месяца
    public By fieldNameHolder = By.xpath("//input[@id='iTEXT']");//имя держателя
    public By fieldNumberYear = By.xpath("//input[@id='input-year']");//номер года
    public By fieldNumberCvc = By.xpath("//input[@id='iCVC']");//cvc карты
    public By buttonSubmitPayment = By.xpath("//button[@id='buttonPayment']");
    public By fieldPasswordPayment = By.xpath("//input[@id='password']");

    public By buttonBall = By.xpath("//*[@data-testid='option-payment-7']");//баллами
}