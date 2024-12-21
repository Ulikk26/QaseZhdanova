package tests;

import jdk.jfr.Description;
import models.Case;
import models.Project;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest {

    Project project = Project.builder()
            .projectName(projectName)
            .build();

    Case testCase = Case.builder()
            .title(caseName)
            .status("Draft")
            .description(caseDescription)
            .build();

    @Test(testName = "Проверка создания тест-кейса", description = "Проверка создания тест-кейса")
    @Description("Проверка создания тест-кейса")
    public void checkCreateCase() {
        loginSteps.login();
        projectsSteps.create(project, "Public", repositoryName);
        projectSteps.openProjectPage(repositoryName);
        caseSteps.create(repositoryName, testCase, caseName);
    }
}