package app.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage {

    public static final SelenideElement NAME_FIELD = $(byXpath("//*[text() = 'Имя']//..//*[@name='name']"));
    public static final SelenideElement EMAIL_FIELD = $(byXpath("//*[text() = 'Email']//..//*[@name='name']"));
    public static final SelenideElement PASSWORD_FIELD = $(byXpath("//*[@name='Пароль']"));
    public static final SelenideElement REGISTRATION_BUTTON = $(byXpath("//*[text()='Зарегистрироваться']"));
    public static final SelenideElement INCORRECT_PASSWORD = $(byXpath("//*[text()='Некорректный пароль']"));
    public static final SelenideElement ENTER_BUTTON = $(byXpath("//*[text()='Войти']"));

    public RegistrationPage(String pageUrl) {
        super(pageUrl);
    }

    @Step("Проверка отображения текста - Некорректный пароль")
    public boolean isWarningVisible() {
        return INCORRECT_PASSWORD.isDisplayed();
    }

    @Step("Клик по кнопке Войти")
    public void clickEnterBtn () { ENTER_BUTTON.click();}

    @Step("Регистрация пользователя")
    public void registration (String name, String email, String password) {

        NAME_FIELD.setValue(name);
        EMAIL_FIELD.setValue(email);
        PASSWORD_FIELD.setValue(password);
        REGISTRATION_BUTTON.click();

    }

}
