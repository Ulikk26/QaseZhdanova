package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPage {

    private static final String CREATE_SUITE_BUTTON = "//span[text()='Suite']//ancestor::button",
            BUTTON = "//span[text()='%s']//ancestor::button",
            NAME_REPOSITORY = "//h1[contains(., '%s')]";

    @Step("Создание нового акаунта с валидными данными")
    public ProjectPage openPage(String nameRepository) {
        open(String.format("project/" + nameRepository));
        return this;
    }

    @Step("Ожидание загрузки страницы 'Проект'")
    public ProjectPage waitTillOpened() {
        $(By.xpath(String.format(CREATE_SUITE_BUTTON))).shouldBe(Condition.visible, Condition.clickable);
        return this;
    }

    public void clickButton(String nameButton) {
        $(By.xpath(String.format(BUTTON, nameButton))).click();
    }

    public WebElement checkNameProject(String name) {
        return $(By.xpath(String.format(NAME_REPOSITORY, name)));
    }
}