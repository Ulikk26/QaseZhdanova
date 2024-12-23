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
    public void login(String user, String password) {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
    }
}