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

    StudentsFormPage typeFirstName(String firstName) {
        firstNameTextField.setValue(firstName);
        return this;
    }

    StudentsFormPage typeLastName(String lastName) {
        lastNameTextField.setValue(lastName);
        return this;
    }

    StudentsFormPage typeEmail(String email) {
        emailTextField.setValue(email);
        return this;
    }

    StudentsFormPage selectMaleCheckbox() {
        maleGenderCheckBox.click();
        return this;
    }

    StudentsFormPage typePhoneNumber(String phoneNumber) {
        mobileTextField.setValue(phoneNumber);
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

    StudentsFormPage typeDateOfBirth(int day, int monthNumber, int year) {
        clickDateOfBirth();
        selectMonthNumber(monthNumber - 1);
        selectYear(String.valueOf(year));
        selectDay(String.valueOf(day));
        return this;
    }

    StudentsFormPage typePhysicsSubject() {
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

    StudentsFormPage typeCurrentAddress (String currentAddress) {
        currentAddressTextField.setValue(currentAddress);
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
