import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@DisplayName("Раздел «Конструктор»")
public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    @Description("В данном сценарии проверяется возможность перехода к разделу «Булки»")
    public void constructorBunTransfer() {

        app.homePage.open();
        app.homePage.isHomePageLoaded();
        app.homePage.clickConstructorFillingsBtn();
        app.homePage.clickConstructorBunBtn();
        app.homePage.checkBunsSection();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    @Description("В данном сценарии проверяется возможность перехода к разделу «Соусы»")
    public void constructorSauceTransfer() {

        app.homePage.open();
        app.homePage.isHomePageLoaded();
        app.homePage.clickConstructorSauceBtn();
        app.homePage.checkSauceSection();

    }

    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    @Description("В данном сценарии проверяется возможность перехода к разделу «Начинки»")
    public void constructorIngredientsTransfer() {

        app.homePage.open();
        app.homePage.isHomePageLoaded();
        app.homePage.clickConstructorFillingsBtn();
        app.homePage.checkFillingsSection();

    }
}
