package home_work_5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static home_work_5.TestData.*;

public class StudentsFormTests {
    @Test
    void formTest() {
        Configuration.startMaximized = true;
        StudentsFormPage studentForm = new StudentsFormPage();

        studentForm
                .openPage()
                .typeFirstName("My firtsname")
                .typeLastName("My lastname")
                .typeEmail(email)
                .selectMaleCheckbox()
                .typePhoneNumber(phoneNumber)
                .typeDateOfBirth(26, 8, 1988)
                .typePhysicsSubject()
                .selectSportHobbies()
                .uploadPicture()
                .typeCurrentAddress(address)
                .selectNCRState()
                .selectDelhiCity()
                .clickSubmitButton()

                //check that all data was sent
                .checkHeader()
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", phoneNumber)
                .checkResultsValue("Date of Birth", "26 August,1988")
                .checkResultsValue("Subjects", "Physics")
                .checkResultsValue("Hobbies", "Sports")
                .checkResultsValue("Picture", "1.png")
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", "NCR Delhi");
    }
}
