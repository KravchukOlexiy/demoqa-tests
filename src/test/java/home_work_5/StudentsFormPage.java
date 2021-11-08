package home_work_5;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentsFormPage {

    String URL = "https://demoqa.com/automation-practice-form";

    private SelenideElement
            firstNameTextField = $("#firstName"),
            lastNameTextField = $("#lastName"),
            emailTextField = $("#userEmail#userEmail"),
            maleGenderCheckBox = $("[for=gender-radio-1]"),
            mobileTextField = $("#userNumber"),
            dateOfBirthField = $("#dateOfBirthInput"),
            monthSelector = $(".react-datepicker__month-select"),
            yearSelector = $(".react-datepicker__year-select"),
            subjectField = $("#subjectsInput"),
            sportsCheckbox = $(byText("Sports")),
            selectPictureButton = $("#uploadPicture"),
            currentAddressTextField = $("#currentAddress"),
            selectStateDropDown = $("#state"),
            selectCityDropDown = $("#city"),
            submitButton = $("#submit");

    StudentsFormPage openPage() {
        open(URL);
        return this;
    }

    StudentsFormPage setFirstName(String a) {
        firstNameTextField.setValue(a);
        return this;
    }

    StudentsFormPage setLastName(String a) {
        lastNameTextField.setValue(a);
        return this;
    }

    StudentsFormPage setEmail(String a) {
        emailTextField.setValue(a);
        return this;
    }

    StudentsFormPage selectMaleCheckbox() {
        maleGenderCheckBox.click();
        return this;
    }

    StudentsFormPage setPhoneNumber(String a) {
        mobileTextField.setValue(a);
        return this;
    }

    StudentsFormPage clickDateOfBirth() {
        dateOfBirthField.click();
        return this;
    }

    StudentsFormPage selectMonthNumber(int month) {
        monthSelector.selectOption(month);
        return this;
    }

    StudentsFormPage selectYear(String year) {
        yearSelector.selectOptionByValue(year);
        return this;
    }

    StudentsFormPage selectDay(String day) {
        $(byText(day)).click();
        return this;
    }

    StudentsFormPage setDateOfBirth(int day, int monthNumber, int year) {
        clickDateOfBirth();
        selectMonthNumber(monthNumber - 1);
        selectYear(String.valueOf(year));
        selectDay(String.valueOf(day));
        return this;
    }

    StudentsFormPage setPhysicsSubject() {
        subjectField.setValue("p");
        $(byText("Physics")).click();
        return this;
    }

    StudentsFormPage selectSportHobbies() {
        sportsCheckbox.click();
        return this;
    }

    StudentsFormPage uploadPicture() {
        selectPictureButton.uploadFromClasspath("1.png");
        return this;
    }

    StudentsFormPage setCurrentAddress(String a) {
        currentAddressTextField.setValue(a);
        return this;
    }

    StudentsFormPage selectNCRState() {
        selectStateDropDown.$("svg").click();
        $(byText("NCR")).click();
        return this;
    }

    StudentsFormPage selectDelhiCity() {
        selectCityDropDown.scrollTo().click();
        $(byText("Delhi")).click();
        return this;
    }

    SuccessWindowComponent clickSubmitButton() {
        submitButton.click();
        return new SuccessWindowComponent();
    }
}
