package home_work_8_junit;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тесты Github + изучение аннотаций Junit")
public class SearchGithub {

    @DisplayName("Поиск Java в Github")
    @Tag("blocker")
    @Tag("smoke")
    @Test
    void searchJava() {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").sendKeys("java");
        $("[data-test-selector=nav-search-input]").pressEnter();
        $(".flex-items-start").$("div").$("h3").shouldHave(Condition.text("Java"));
    }

    @Tag("blocker")
    @Tag("smoke")
    @ValueSource(strings = {"Java", "JavaScript"})  //argument provider
    @ParameterizedTest(name = "Поиск {0} в Github с помощью параметризированных тестов")
        //{0} это порядковый номер аргумента в методе searchGithub
    void searchGithubWithValueSourceAnnotation(String searchRequest) {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").sendKeys(searchRequest);
        $("[data-test-selector=nav-search-input]").pressEnter();
        $(".flex-items-start").$("div").$("h3").shouldHave(Condition.text(searchRequest));
    }

    //в аргументах метода может быть int, char, double
    @Tag("blocker")
    @Tag("smoke")
    @CsvSource(value = {
            "Java| Java is an object-oriented programming language",
            "JavaScript| JavaScript (JS) is a lightweight interpreted programming language"
    },
            delimiter = '|')//argument provider
    @ParameterizedTest(name = "Поиск {0} в Github и проверка наличия текста {1}")
    //{0} это порядковый номер аргумента в методе searchGithub
    void searchGithubWithCSVSourceAnnotation(String searchRequest, String expectedResultText) {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").sendKeys(searchRequest);
        $("[data-test-selector=nav-search-input]").pressEnter();
        $(".flex-items-start").$("div").$("p").shouldHave(Condition.text(expectedResultText));
    }

    @Tag("blocker")
    @Tag("smoke")
    @EnumSource(SearchQuery.class)
    @ParameterizedTest(name = "Поиск {0} в Github")
        //{0} это порядковый номер аргумента в методе searchGithub
    void searchGithubWithEnumSourceAnnotation(SearchQuery searchRequest) {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").sendKeys(searchRequest.toString());
        $("[data-test-selector=nav-search-input]").pressEnter();
        $(".flex-items-start").$("div").$("p").shouldHave(Condition.text(searchRequest.toString()));
    }


    static Stream<Arguments> searchGithubWithMethodSourceAnnotation() {
        return Stream.of(
                Arguments.of("Java", "Java is an object-oriented programming language"),
                Arguments.of("Javascript", "JavaScript (JS) is a lightweight interpreted programming language")
        );
    }

    @Tag("blocker")
    @Tag("smoke")
    @MethodSource
    @ParameterizedTest(name = "Поиск {0} в Github и проверка наличия текста {1}")
        //{0} это порядковый номер аргумента в методе searchGithub
    void searchGithubWithMethodSourceAnnotation(String searchRequest, String expectedResultText) {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").sendKeys(searchRequest.toString());
        $("[data-test-selector=nav-search-input]").pressEnter();
        $(".flex-items-start").$("div").$("p").shouldHave(Condition.text(expectedResultText));
    }

}
