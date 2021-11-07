package home_work_5;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SuccessFormModalWindowComponent {
    SelenideElement
            header = $("#example-modal-sizes-title-lg"),
            table = $(".table-responsive");

    SuccessFormModalWindowComponent checkHeader(String headerText) {
        header.shouldHave(text(headerText));
        return this;
    }

    public SuccessFormModalWindowComponent checkResultsValue(String key, String value) {
        table
                .$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

}
