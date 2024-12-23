package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Builder;
import models.Project;
import org.openqa.selenium.By;
import wrappers.Input;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectModal {

    private static final String CREATE_PROJECT_BUTTON = "[type=submit]",
            RADIOBUTTON = "//span[text()='%s']//ancestor::label//input";

    public NewProjectModal isPageOpened() {
        $(byText("Create new project")).shouldBe(Condition.visible);
        return this;
    }

    @Builder
    @Step("Создание нового акаунта с валидными данными")
    public NewProjectModal createProject(Project project) {

        if (project.getProjectName() != null) {
            new Input("Project name").write(project.getProjectName());
        }
        if (project.getProjectCode() != null) {
            new Input("Project code").clearInput("Project code");
            new Input("Project code").write(project.getProjectCode());
        }
        return this;
    }

    @Step("Выбрать кнопку {radiobutton}")
    public void clickRadioButton(String radiobutton) {
        $(By.xpath(String.format(RADIOBUTTON, radiobutton))).click();
    }

    @Step("Нажать на кнопку Create ")
    public void clickCreateProjectButton() {
        $(By.cssSelector(CREATE_PROJECT_BUTTON)).click();
    }
}