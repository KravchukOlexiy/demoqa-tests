package home_work_6_allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHabPage {

    static final String ISSUE_NAME = "Using ChromeOptions prefs with ChromeDriverFactory";

    @Step("Открываем главную страницу GitHab")
    void openGitHabSite() {
        open("https://github.com/selenide/selenide/");
    }

    @Step("Открываем страницу Issues")
    void clickIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с тексом: {issueName}")
    void checkIssueByText(String issueName) {
        $(byText(issueName)).shouldBe(visible);
    }
}
