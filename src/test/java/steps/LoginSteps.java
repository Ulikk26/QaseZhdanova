package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginSteps {
    LoginPage loginPage;
    ProjectsPage projectsPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }

    @Step("Авторизация")
    public void login() {
        loginPage.openPage();
        loginPage.login();
        projectsPage.waitTillOpened();
    }
}