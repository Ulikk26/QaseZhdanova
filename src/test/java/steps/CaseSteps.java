package steps;

import io.qameta.allure.Step;
import models.Case;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CasePage;
import pages.ProjectPage;

public class CaseSteps {

    ProjectPage projectPage;
    CasePage casePage;

    public CaseSteps() {
        projectPage = new ProjectPage();
        casePage = new CasePage();
    }

    @Step("Создание тест-кейса")
    public void create(String repositoryName, Case case1, String caseName) {
        casePage.openPage(repositoryName);
        casePage.waitTillOpened();
        casePage.createCase(case1);
        casePage.clickSaveButton();
        WebElement name = casePage.checkCaseName(caseName);
        Assert.assertTrue(name.isDisplayed(), "Название кейса не отображается на странице");
    }
}