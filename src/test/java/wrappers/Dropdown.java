package wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Dropdown {

    String label;
    private static final String INPUT_FIELD = "//label[text()='%s']/parent::div//input[@aria-autocomplete='list']",
            SELECTED_ELEMENT = "//div[text()='%s']";

    public Dropdown(String label) {
        this.label = label;
    }

    public void select(String option) {
        $(By.xpath(String.format(INPUT_FIELD, label)))
                .click();
        $(By.xpath(String.format(SELECTED_ELEMENT, option)))
                .click();
    }
}