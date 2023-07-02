import app.code_api_data.TokenResponse;
import app.code_api_data.UserRequest;
import app.pojo.CreateUserJson;
import app.url.PagesUrl;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.WebDriverRunner.url;

@DisplayName("Переход в личный кабинет")
public class ProfileTest extends BaseTest {

    CreateUserJson createUser = new CreateUserJson("kislenko-s@yandex.ru", "1Qwe%G", "Kislenko");

    @Before
    public void login() {

        UserRequest.create(createUser);
        app.homePage.open();
        app.homePage.clickEnterToAccountBtn();
        app.loginPage.login("kislenko-s@yandex.ru", "1Qwe%G");
        app.homePage.isHomePageLoaded();

    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("В данном сценарии проверяется возможность перехода в личный кабинет" +
            " с главной страницы авторизованным пользователем»")
    public void enterToAccount() {

        app.homePage.clickEnterToAccountBtn();
        Assert.assertTrue("Выход из профиля не был произведен", app.profilePage.isProfilePage());
        Assert.assertEquals("Отображается другая страница", PagesUrl.PROFILE_URL, url());

    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("В данном сценарии проверяется возможность выхода по кнопке «Выйти» в личном кабинете")
    public void logoutFromAccount() {

        app.homePage.clickEnterToAccountBtn();
        app.profilePage.clickLogoutBtn();
        Assert.assertTrue("Выход из профиля не был произведен", app.loginPage.isLoginPage());
        Assert.assertEquals("Отображается другая страница", PagesUrl.LOGIN_URL, url());

    }

    @After
    public void deleteUser() {

        String userAccessToken = UserRequest.login(createUser).then().extract().response().as(TokenResponse.class).getAccessToken();
        UserRequest.delete(userAccessToken);
    }
}
