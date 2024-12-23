package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    private static final String NEW_PROJECT_BUTTON = "Create new project",
            DELETE_BUTTON = "//span[text()='Delete project']//ancestor::button",
            REMOVE_BUTTON = "//div[@data-testid='remove']";

    @Step("Открытие страницы 'Проекты'")
    public ProjectsPage openPage() {
        open("projects");
        return this;
    }

    @Step("Ожидание загрузки страницы 'Проекты'")
    public void waitTillOpened() {
        $(byText(NEW_PROJECT_BUTTON)).shouldBe(Condition.visible, Condition.clickable);
//        $$("").should(CollectionCondition.texts()); //коллекция
    }

    @Step("Удаление проекта")
    public void removeProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $(By.xpath(String.format(REMOVE_BUTTON))).click();
        $(By.xpath(String.format(DELETE_BUTTON))).click();
    }

    @Step("Нажатие на кнопку 'Создать новый проект'")
    public void clickCreateNewProjectButton() {
        $(byText(NEW_PROJECT_BUTTON)).click();
    }
}