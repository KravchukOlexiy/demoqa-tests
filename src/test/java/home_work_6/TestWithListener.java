package home_work_6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithListener {

    @Test
    void checkIssuePresenting() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/selenide/selenide/");
        $("#issues-tab").click();
        $(withText("Using ChromeOptions prefs with ChromeDriverFactory")).shouldBe(visible, Duration.ofSeconds(10));

    }
}
