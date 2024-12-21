package wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Input {
    String label;
    private static final String INPUT_FIELD_PROJECT = "//label[text()='%s']//ancestor::div[contains(@class, 'UIUnIf')]//input",
            INPUT_FIELD_CASE = "//label[text()='%s']/parent::div//input";

    public Input(String label) {
        this.label = label;
    }

    public void write(String text) {
        $(By.xpath(String.format(INPUT_FIELD_PROJECT, label))).sendKeys(text);
    }

    public void clearInput(String label) {
        $(By.xpath(String.format(INPUT_FIELD_PROJECT, label))).clear();
    }

    public void writeCaseInput(String text) {
        $(By.xpath(String.format(INPUT_FIELD_CASE, label))).sendKeys(text);
    }
}