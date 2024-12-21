package tests;

import jdk.jfr.Description;
import models.Project;
import models.Suite;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    Project project = Project.builder()
            .projectName(projectName)
            .build();

    Suite suite = Suite.builder()
            .suiteName(suiteName)
            .build();

    @Test(testName = "Проверка создания сьюта", description = "Проверка создания сьюта")
    @Description("Проверка создания сьюта")
    public void checkCreateSuite() {
        loginSteps.login();
        projectsSteps.create(project, "Public", repositoryName);
        suiteSteps.createSuite(repositoryName, suite, suiteName);
    }
}