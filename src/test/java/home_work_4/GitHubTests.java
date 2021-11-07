package home_work_4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {

    @Test
    void checkGUnitCodePresence() {
        Configuration.startMaximized = true;
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(withText("Show 2 more pages…")).scrollTo().click();
        $(withText("SoftAssertions")).shouldBe(visible).click();
        $$("code").shouldHave(itemWithText("com.codeborne.selenide.junit5.SoftAssertsExtension"));



    }

}
