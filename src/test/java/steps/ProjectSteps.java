package steps;

import io.qameta.allure.Step;
import pages.ProjectPage;

public class ProjectSteps {

    ProjectPage projectPage;

    public ProjectSteps() {
        projectPage = new ProjectPage();
    }

    @Step("Открытие главной страницы с проектами")
    public void openProjectPage(String repositoryName) {
        projectPage.openPage(repositoryName);
        projectPage.waitTillOpened();
    }
}