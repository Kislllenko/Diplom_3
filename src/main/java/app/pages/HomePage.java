package app.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    public static final SelenideElement PROFILE_BUTTON = $(byXpath("//*[text()='Личный Кабинет']"));
    public static final SelenideElement COLLECT_BURGER_LABEL = $(byXpath("//*[text()='Соберите бургер']"));
    public static final SelenideElement CONSTRUCTOR_BUN = $(byXpath("//span[text()='Булки']"));
    public static final SelenideElement CONSTRUCTOR_SAUCE = $(byXpath("//span[text()='Соусы']"));
    public static final SelenideElement CONSTRUCTOR_FILLINGS = $(byXpath("//span[text()='Начинки']"));
    public static final SelenideElement CONSTRUCTOR_SECTION = $(byXpath("//*[contains(@class,'current')]"));

    public HomePage (String pageUrl) {
        super(pageUrl);
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public void clickEnterToAccountBtn () { PROFILE_BUTTON.click();}

    @Step("Клик по кнопке Личный Кабинет")
    public void clickProfileBtn () { PROFILE_BUTTON.click();}

    @Step("Клик по кнопке Булки")
    public void clickConstructorBunBtn () { CONSTRUCTOR_BUN.click(); }

    @Step("Клик по кнопке Соусы")
    public void clickConstructorSauceBtn () { CONSTRUCTOR_SAUCE.click(); }

    @Step("Клик по кнопке Начинки")
    public void clickConstructorFillingsBtn () { CONSTRUCTOR_FILLINGS.click(); }

    @Step("Проверка выбора раздела")
    public String getTextSection() {

        CONSTRUCTOR_SECTION.shouldBe(visible, Duration.ofSeconds(8));
        return CONSTRUCTOR_SECTION.getText();

    }

    public boolean isHomePageLoaded() {
        return COLLECT_BURGER_LABEL.shouldBe(visible).isDisplayed();
    }
}
