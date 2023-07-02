package app.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage {

    public static final SelenideElement PROFILE_DESCRIPTION = $(byXpath("//*[text()='В этом разделе вы можете изменить свои персональные данные']"));
    public static final SelenideElement LOGOUT_BUTTON = $(byXpath("//*[text()='Выход']"));
    public static final SelenideElement CONSTRUCTOR_BUTTON = $(byXpath("//*[text()='Конструктор']"));
    public static final SelenideElement LOGO_BUTTON = $(byXpath("//*[contains(@class,'logo')]"));

    public ProfilePage (String pageUrl) {
        super(pageUrl);
    }

    @Step("Клик по кнопке Выход")
    public void clickLogoutBtn () { LOGOUT_BUTTON.click();}

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorBtn () { CONSTRUCTOR_BUTTON.click();}
    @Step("Клик по лого Stellar Burgers")
    public void clickLogoBtn () { LOGO_BUTTON.click();}

    @Step("Проверка отображения текста - В этом разделе вы можете изменить свои персональные данные")
    public boolean isProfilePage() {
        return PROFILE_DESCRIPTION.shouldBe(visible).isDisplayed();
    }
}
