package app.pages;
import app.AppConfig;
import com.codeborne.selenide.Selenide;
import helpers.Trim;
import io.qameta.allure.Step;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    @Step("Переход на страницу")
    public void open() {
        String url = Trim.rtrim(AppConfig.baseUrl, "/") + "/" + Trim.ltrim(pageUrl, "/");
        Selenide.open(url);
    }
}
