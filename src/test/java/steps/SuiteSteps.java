package steps;

import io.qameta.allure.Step;
import models.Suite;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ProjectPage;
import pages.SuitePageModal;

public class SuiteSteps {

    ProjectPage projectPage;
    SuitePageModal suitePageModal;
    ProjectSteps projectSteps;

    public SuiteSteps() {
        suitePageModal = new SuitePageModal();
        projectSteps = new ProjectSteps();
    }

    @Step("Создание нового сьюта")
    public void createSuite(String repositoryName, Suite suite, String nameSuite) {
        projectSteps.openProjectPage(repositoryName);
        projectPage.clickButton("Suite");
        suitePageModal.waitTillOpened();
        suitePageModal.createSuite(suite);
        suitePageModal.clickButton("Create");
        WebElement suiteName = suitePageModal.checkNameSuite(nameSuite);
        Assert.assertTrue(suiteName.isDisplayed(), "Название сценария не отображается на странице");
    }
}