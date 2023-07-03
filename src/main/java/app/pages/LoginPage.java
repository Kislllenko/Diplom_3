package app.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    public static final SelenideElement ENTER_LABEL = $(byXpath("//h2[text()='Вход']"));
    public static final SelenideElement EMAIL_FIELD = $(byXpath("//*[text() = 'Email']//..//*[@name='name']"));
    public static final SelenideElement ENTER_BUTTON = $(byXpath("//*[text()='Войти']"));
    public static final SelenideElement PASSWORD_FIELD = $(byXpath("//*[@name='Пароль']"));
    public LoginPage (String pageUrl) {
        super(pageUrl);
    }

    @Step("Вход в аккаунт")
    public void login (String email, String password) {

        EMAIL_FIELD.setValue(email);
        PASSWORD_FIELD.setValue(password);
        ENTER_BUTTON.click();

    }
    @Step("Проверка отображения текста - Вход")
    public boolean isLoginPage() { return ENTER_LABEL.shouldBe(visible).isDisplayed(); }
}
