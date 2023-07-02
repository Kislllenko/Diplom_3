package app;
import app.pages.*;

public class PageBuilder {

    public static LoginPage buildLoginPage() { return new LoginPage("/login"); }
    public static ProfilePage buildProfilePage() { return new ProfilePage("/account/profile"); }
    public static RegistrationPage buildRegistrationPage() { return new RegistrationPage("/register"); }
    public static HomePage buildHomePage() { return new HomePage("/"); }
    public static ForgotPasswordPage buildforgotPasswordPage() { return new ForgotPasswordPage("/forgot-password"); }

}
