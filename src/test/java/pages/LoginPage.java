package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String USER = "[name=email]",
            PASSWORD = "[name=password]",
            BUTTON_SING_IN = "Sign in";

    @Step("Открытие страницы авторизации")
    public LoginPage openPage() {
        open("login");
        return this;
    }

    @Step("Авторизация в проекте")
    public void login(String user, String password) {
        $(USER).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(BUTTON_SING_IN)).click();
    }
}