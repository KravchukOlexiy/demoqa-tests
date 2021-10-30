import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class PracticeFormTest {

    @Test
    void formTest () {
        Configuration.startMaximized = true;

        open ("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("My firtsname");
        $("#lastName").setValue("My lastname");
        $("#userEmail").setValue("someemail@some.net");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $(byText("26")).click();

        $("#subjectsInput").setValue("p");
        $(byText("Physics")).click();

        $(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("My text");

        $("#state").$("svg").click();
        $(byText("NCR")).click();

        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").scrollTo().click();

        //check that all data was sent
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $$("td").shouldHave(CollectionCondition.texts(
                "Student Name", "My firtsname My lastname",
                "Student Email", "someemail@some.net",
                "Gender", "Male",
                "Mobile", "0123456789",
                "Date of Birth", "26 August,1988",
                "Subjects", "Physics",
                "Hobbies", "Sports",
                "Picture", "1.png",
                "Address", "My text",
                "State and City", "NCR Delhi"));

    }
}
