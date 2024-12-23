package steps;

import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.NewProjectModal;
import pages.ProjectPage;
import pages.ProjectsPage;

public class ProjectsSteps {

    ProjectsPage projectsPage;
    NewProjectModal newProjectModal;
    ProjectPage projectPage;

    public ProjectsSteps() {
        projectsPage = new ProjectsPage();
        newProjectModal = new NewProjectModal();
        projectPage = new ProjectPage();
    }

    @Step("Создание нового проекта")
    public void create(Project project, String radiobutton, String repositoryName) {
        projectsPage.openPage();
        projectsPage.waitTillOpened();
        projectsPage.clickCreateNewProjectButton();
        newProjectModal.isPageOpened();
        newProjectModal.createProject(project);
        newProjectModal.clickRadioButton(radiobutton);
        newProjectModal.clickCreateProjectButton();
        projectPage.waitTillOpened();
        WebElement projectName = projectPage.checkNameProject(repositoryName);
        Assert.assertTrue(projectName.isDisplayed(), "Название проекта не отображается на странице");
    }

    @Step("Удаление проекта")
    public void removeProject(String projectName) {
        projectsPage.openPage();
        projectsPage.waitTillOpened();
        projectsPage.removeProject(projectName);
        WebElement name = projectPage.checkNameProject(projectName);
        Assert.assertFalse(name.isDisplayed(), "Проект не удален, название отображается на странице");
    }

    public void openActualPage(String nameRepository) {
        projectPage.openPage(nameRepository);
        projectPage.waitTillOpened();
    }
}