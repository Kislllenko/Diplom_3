import app.code_api_data.TokenResponse;
import app.code_api_data.UserRequest;
import app.pojo.CreateUserJson;
import app.url.PagesUrl;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.WebDriverRunner.url;

@DisplayName("Регистрация")
public class RegistrationTest extends BaseTest {

    CreateUserJson createUser = new CreateUserJson("kislenko-s@yandex.ru", "1Qwe%G", "Kislenko");

    @Before
    public void login() {

        app.registrationPage.open();

    }

    @Test
    @DisplayName("Регистрация с валидными данными")
    @Description("В данном сценарии проверяется, что пользователь может быть зарегистрирован с валидными данными")
    public void registrationTest() {

        app.registrationPage.registration("Kislenko", "kislenko-s@yandex.ru", "1Qwe%G");
        app.loginPage.isLoginPage();
        Assert.assertEquals("Переход на форму логина не выполнен", PagesUrl.LOGIN_URL, url());
        String userAccessToken = UserRequest.login(createUser).then().extract().response().as(TokenResponse.class).getAccessToken();
        UserRequest.delete(userAccessToken);

    }

    @Test
    @DisplayName("Регистрация с невалидными данными")
    @Description("В данном сценарии проверяется, что пользователь не может быть зарегистрирован с не валидными данными")
    public void registrationWithWrongDataTest() {

        app.registrationPage.registration("Kislenko", "kislenko-s@yandex.ru", "1Qwe");
        Assert.assertTrue("Валидация не сработала", app.registrationPage.isWarningVisible());

    }

}
