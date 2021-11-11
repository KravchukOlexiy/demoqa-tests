package home_work_6;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static home_work_6.GitHabPage.ISSUE_NAME;
import static io.qameta.allure.Allure.step;

public class TestWithLyamdaSteps {

    @Test
    void checkIssuePresenting() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/selenide/selenide");
        });

        step("Открываем страницу Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue с тексом: {ISSUE_NAME}}", () -> {
            $(byText(ISSUE_NAME)).shouldBe(visible);
        });
    }
}
