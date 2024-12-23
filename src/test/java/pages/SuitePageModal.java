package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Builder;
import models.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;

public class SuitePageModal {

    private static final String CREATE_BUTTON = "[type=submit]",
            BUTTON = "//span[text()='%s']//ancestor::button",
            NAME_SUITE = "//a[text()='%s']";

    @Step("Ожидание загрузки модалки Сьют")
    public void waitTillOpened() {
        $(By.cssSelector(String.format(CREATE_BUTTON))).shouldBe(Condition.visible, Condition.clickable);
    }

    @Builder
    @Step("Создание нового сьюта")
    public SuitePageModal createSuite(Suite suite) {

        if (suite.getSuiteName() != null) {
            new Input("Suite name").write(suite.getSuiteName());
        }
        if (suite.getParentSuite() != null) {
            new Input("Parent suite").write(suite.getParentSuite());
        }
        if (suite.getDescription() != null) {
            new Input("Description").write(suite.getDescription());
        }
        if (suite.getPreconditions() != null) {
            new Input("Preconditions").write(suite.getPreconditions());
        }
        return this;
    }

    @Step("Нажатие на кнопку {nameButton}")
    public void clickButton(String nameButton) {
        $(By.xpath(String.format(BUTTON, nameButton))).click();
    }

    @Step("Нахождение названия сьюта {name}")
    public WebElement checkNameSuite(String name) {
        $(By.xpath(String.format(NAME_SUITE, name))).shouldBe(Condition.visible);
        return $(By.xpath(String.format(NAME_SUITE, name)));
    }
}