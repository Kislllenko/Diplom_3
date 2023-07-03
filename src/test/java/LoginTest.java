import app.api.TokenResponse;
import app.api.UserRequest;
import app.pojo.CreateUserJson;
import app.url.PagesUrl;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.WebDriverRunner.url;

@DisplayName("Вход в аккаунт")
public class LoginTest extends BaseTest {

    CreateUserJson createUser = new CreateUserJson("kislenko-s@yandex.ru", "1Qwe%G", "Kislenko");

    @Before
    public void login() {

        UserRequest.create(createUser);

    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("В данном сценарии проверяется возможность войти в аккаунт через кнопку «Войти в аккаунт»")
    public void enterToAccountBtn() {

        app.homePage.open();
        app.homePage.clickEnterToAccountBtn();
        app.loginPage.login("kislenko-s@yandex.ru", "1Qwe%G");
        Assert.assertTrue("Пользователь не вошёл в аккаунт", app.homePage.isHomePageLoaded());
        Assert.assertEquals("Главная страница не отображается", PagesUrl.BASE_URL, url());

    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("В данном сценарии проверяется возможность войти в аккаунт через кнопку «Личный кабинет»")
    public void enterProfileBtn() {

        app.homePage.open();
        app.homePage.clickProfileBtn();
        app.loginPage.login("kislenko-s@yandex.ru", "1Qwe%G");
        Assert.assertTrue("Пользователь не вошёл в аккаунт", app.homePage.isHomePageLoaded());
        Assert.assertEquals("Главная страница не отображается", PagesUrl.BASE_URL, url());

    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("В данном сценарии проверяется возможность войти в аккаунт через кнопку в форме регистрации")
    public void enterBtn() {

        app.registrationPage.open();
        app.registrationPage.clickEnterBtn();
        app.loginPage.login("kislenko-s@yandex.ru", "1Qwe%G");
        Assert.assertTrue("Пользователь не вошёл в аккаунт", app.homePage.isHomePageLoaded());
        Assert.assertEquals("Главная страница не отображается", PagesUrl.BASE_URL, url());

    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("В данном сценарии проверяется возможность войти в аккаунт через кнопку в форме восстановления пароля")
    public void enterForgotPasswordBtn() {

        app.forgotPasswordPage.open();
        app.forgotPasswordPage.clickEnterBtn();
        app.loginPage.login("kislenko-s@yandex.ru", "1Qwe%G");
        Assert.assertTrue("Пользователь не вошёл в аккаунт", app.homePage.isHomePageLoaded());
        Assert.assertEquals("Главная страница не отображается", PagesUrl.BASE_URL, url());

    }

    @After
    public void deleteUser() {

        String userAccessToken = UserRequest.login(createUser).then().extract().response().as(TokenResponse.class).getAccessToken();
        UserRequest.delete(userAccessToken);
    }

}
