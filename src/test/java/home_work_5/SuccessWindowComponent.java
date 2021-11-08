package home_work_5;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SuccessWindowComponent {
    SelenideElement
            header = $("#example-modal-sizes-title-lg"),
            table = $(".table-responsive");

    SuccessWindowComponent checkHeader(String headerText) {
        header.shouldHave(text(headerText));
        return this;
    }

    public SuccessWindowComponent checkResultsValue(String key, String tableValue) {
        table
                .$(byText(key))
                .parent().lastChild().shouldHave(text(tableValue));
        return this;
    }

}
