package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.*;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;
    LoginSteps loginSteps;
    ProjectsSteps projectsSteps;
    NewProjectModal newProjectModal;
    ProjectPage createdProjectPage;
    SuitePageModal suitePageModal;
    SuiteSteps suiteSteps;
    CasePage casePage;
    CaseSteps caseSteps;
    ProjectSteps projectSteps;

    String baseUrl = System.getProperty("baseUrl", PropertyReader.getProperty("baseUrl"));
    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String login = System.getProperty("login", PropertyReader.getProperty("login"));
    String projectName = System.getProperty("projectName", PropertyReader.getProperty("projectName"));
    String repositoryName = System.getProperty("repositoryName", PropertyReader.getProperty("repositoryName"));
    String suiteName = System.getProperty("suiteName", PropertyReader.getProperty("suiteName"));
    String caseName = System.getProperty("caseName", PropertyReader.getProperty("caseName"));
    String caseDescription = System.getProperty("caseDescription", PropertyReader.getProperty("caseDescription"));

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.baseUrl = baseUrl;
//        Configuration.assertionMode= AssertionMode.valueOf("SOFT");
//         getWebDriver(); //вызов драйвера
//        WebDriver driver=new ChromeDriver();
//        setWebDriver(driver);
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        newProjectModal = new NewProjectModal();
        createdProjectPage = new ProjectPage();
        suitePageModal = new SuitePageModal();
        suiteSteps = new SuiteSteps();
        casePage = new CasePage();
        caseSteps = new CaseSteps();
        projectSteps = new ProjectSteps();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}