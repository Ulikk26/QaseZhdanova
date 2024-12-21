package pages;

import io.qameta.allure.Step;
import utils.PropertyReader;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String USER = "[name=email]",
            PASSWORD = "[name=password]",
            BUTTON_SING_IN = "Sign in";

    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String login = System.getProperty("login", PropertyReader.getProperty("login"));

    @Step("Открытие страницы авторизации")
    public LoginPage openPage() {
        open("login");
        return this;
    }

    @Step("Авторизация в проекте")
    public void login() {
        $(USER).setValue(user);
        $(PASSWORD).setValue(login);
        $(byText(BUTTON_SING_IN)).click();
    }
}