package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Builder;
import models.Case;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Dropdown;
import wrappers.Input;
import wrappers.Textarea;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CasePage {

    private static final String ADD_STEPS_BUTTON = "//*[text()=' Add step']//ancestor::button",
            SAVE_BUTTON = "//button[@id='save-case']",
            CASE_NAME = "//div[text()='%s']";

    @Step("Открытие страницы тест-кейс для проекта {nameRepository}")
    public CasePage openPage(String nameRepository) {
        open(String.format("case/" + nameRepository + "/create"));
        return this;
    }

    @Step("Ожидание загрузки страницы тест-кейс")
    public CasePage waitTillOpened() {
        $(By.xpath(String.format(ADD_STEPS_BUTTON))).shouldBe(Condition.visible, Condition.clickable);
        return this;
    }

    @Builder
    @Step("Создание тест-кейса")
    public CasePage createCase(Case testCase) {

        if (testCase.getTitle() != null) {
            new Input("Title").writeCaseInput(testCase.getTitle());
        }
        if (testCase.getStatus() != null) {
            new Dropdown("Status").select(testCase.getStatus());
        }
        if (testCase.getDescription() != null) {
            new Textarea("Description").write(testCase.getDescription());
        }
        return this;
    }

    @Step("Нажатие на кнопку 'Сохранить тест кейс'")
    public void clickSaveButton() {
        $(By.xpath(String.format(SAVE_BUTTON))).click();
    }

    @Step("Проверка отображения имени тест кейса '{name}'")
    public WebElement checkCaseName(String name) {
        $(By.xpath(String.format(CASE_NAME, name))).shouldBe(Condition.visible);
        return $(By.xpath(String.format(CASE_NAME, name)));
    }
}