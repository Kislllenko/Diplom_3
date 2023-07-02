package app.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage extends BasePage {

    public static final SelenideElement ENTER_BUTTON = $(byXpath("//*[text()='Войти']"));

    @Step("Клик по кнопке Войти")
    public void clickEnterBtn () { ENTER_BUTTON.click();}

    public ForgotPasswordPage (String pageUrl) {
        super(pageUrl);
    }
}
