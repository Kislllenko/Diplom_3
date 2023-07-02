package app;

import app.pages.*;

public class App {

    public LoginPage loginPage;
    public ProfilePage profilePage;
    public RegistrationPage registrationPage;
    public HomePage homePage;
    public ForgotPasswordPage forgotPasswordPage;

    public App() {

        loginPage = PageBuilder.buildLoginPage();

        profilePage = PageBuilder.buildProfilePage();

        registrationPage = PageBuilder.buildRegistrationPage();

        homePage = PageBuilder.buildHomePage();

        forgotPasswordPage = PageBuilder.buildforgotPasswordPage();
    }
}
