package app.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;

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

    @Step("Проверка выбора раздела «Булки»")
    public void  checkBunsSection() {

        CONSTRUCTOR_SECTION.shouldBe(visible, Duration.ofSeconds(8));
        String actualText = CONSTRUCTOR_SECTION.getText();
        MatcherAssert.assertThat(actualText, containsString("Булки"));

    }

    @Step("Проверка выбора раздела «Соусы»")
    public void  checkSauceSection() {

        CONSTRUCTOR_SECTION.shouldBe(visible, Duration.ofSeconds(8));
        String actualText = CONSTRUCTOR_SECTION.getText();
        MatcherAssert.assertThat(actualText, containsString("Соусы"));

    }

    @Step("Проверка выбора раздела «Начинки»")
    public void  checkFillingsSection() {

        CONSTRUCTOR_SECTION.shouldBe(visible, Duration.ofSeconds(8));
        String actualText = CONSTRUCTOR_SECTION.getText();
        MatcherAssert.assertThat(actualText, containsString("Начинки"));

    }

    public boolean isHomePageLoaded() {
        return COLLECT_BURGER_LABEL.shouldBe(visible).isDisplayed();
    }
}
