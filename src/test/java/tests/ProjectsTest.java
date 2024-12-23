package tests;

import jdk.jfr.Description;
import models.Project;
import org.testng.annotations.Test;

public class ProjectsTest extends BaseTest {

    Project project = Project.builder()
            .projectName(projectName)
            .build();

    @Test(testName = "Проверка создания проекта", description = "Проверка создания проекта")
    @Description("Проверка создания проекта")
    public void checkCreateProject() {
        loginSteps.login(user, password);
        projectsSteps.create(project, "Public", projectName);
    }

    @Test(testName = "Проверка удаления проекта", description = "Проверка удаления проекта")
    @Description("Проверка удаления проекта")
    public void checkRemoveProject() {
        loginSteps.login(user, password);
        projectsSteps.removeProject(projectName);
    }
}