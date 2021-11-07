package home_work_5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


public class StudentsFormTests {
    @Test
    void formTest() {
        Configuration.startMaximized = true;
        StudentsFormPage studentForm = new StudentsFormPage();

        studentForm
                .openPage()
                .setFirstName("My firtsname")
                .setLastName("My lastname")
                .setEmail("someemail@some.net")
                .selectMaleCheckbox()
                .setPhoneNumber("0123456789")
                .setDateOfBirth(26, 8, 1988)
                .setPhysicsSubject()
                .selectSportHobbies()
                .uploadPicture()
                .setCurrentAddress("My text")
                .selectNCRState()
                .selectDelhiCity()
                .clickSubmitButton()

        //check that all data was sent
                .checkHeader("Thanks for submitting the form")
                .checkResultsValue("Student Name", "My firtsname My lastname")
                .checkResultsValue("Student Email", "someemail@some.net")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "0123456789")
                .checkResultsValue("Date of Birth", "26 August,1988")
                .checkResultsValue("Subjects", "Physics")
                .checkResultsValue("Hobbies", "Sports")
                .checkResultsValue("Picture", "1.png")
                .checkResultsValue("Address", "My text")
                .checkResultsValue("State and City", "NCR Delhi");
    }
}
