package home_work_4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @Test
    void dragAndDropTest () {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("h3").shouldBe(visible, Duration.ofSeconds(30));
        $("#column-a").dragAndDropTo($("#column-b"));
        $$(".column").shouldHave(texts("B","A"));
    }
}
