package home_work_5;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SuccessWindowComponent {
    final String HEADER_TEXT = "Thanks for submitting the form";

    SelenideElement
            header = $("#example-modal-sizes-title-lg"),
            table = $(".table-responsive");

    SuccessWindowComponent checkHeader() {
        header.shouldHave(text(HEADER_TEXT));
        return this;
    }

    public SuccessWindowComponent checkResultsValue(String key, String tableValue) {
        table
                .$(byText(key))
                .parent().lastChild().shouldHave(text(tableValue));
        return this;
    }
}
