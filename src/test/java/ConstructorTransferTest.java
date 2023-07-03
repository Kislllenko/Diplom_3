import app.api.TokenResponse;
import app.api.UserRequest;
import app.url.PagesUrl;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.WebDriverRunner.url;

@DisplayName("Переход из личного кабинета в конструктор")
public class ConstructorTransferTest extends BaseTest {

    @Before
    public void login() {

        UserRequest.create(createUser);
        app.homePage.open();
        app.homePage.clickEnterToAccountBtn();
        app.loginPage.login("kislenko-s@yandex.ru", "1Qwe%G");
        app.homePage.isHomePageLoaded();
        app.homePage.clickEnterToAccountBtn();

    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на «Конструктор»")
    @Description("В данном сценарии проверяется переход в конструктор по клику на «Конструктор»")
    public void openConstructor() {

        app.profilePage.clickConstructorBtn();
        Assert.assertTrue("Главная страница не загружена", app.homePage.isHomePageLoaded());
        Assert.assertEquals("Главная страница не отображается", PagesUrl.BASE_URL, url());

    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на «Stellar Burgers»")
    @Description("В данном сценарии проверяется переход в конструктор по клику на «Stellar Burgers»")
    public void openConstructorThroughLogo() {

        app.profilePage.clickLogoBtn();
        Assert.assertTrue("Главная страница не загружена", app.homePage.isHomePageLoaded());
        Assert.assertEquals("Главная страница не отображается", PagesUrl.BASE_URL, url());

    }

    @After
    public void deleteUser() {

        String userAccessToken = UserRequest.login(createUser).then().extract().response().as(TokenResponse.class).getAccessToken();
        UserRequest.delete(userAccessToken);
    }
}
