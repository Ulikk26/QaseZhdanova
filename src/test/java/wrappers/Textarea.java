package wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Textarea {

    String label;
    private static final String INPUT_FIELD_SUITE = "//label[text()='Description']//ancestor::div[1]//div[@class='toastui-editor-ww-container']//p";

    public Textarea(String label) {
        this.label = label;
    }

    public void write(String text) {
        $(By.xpath(String.format(INPUT_FIELD_SUITE, label))).sendKeys(text);
    }
}