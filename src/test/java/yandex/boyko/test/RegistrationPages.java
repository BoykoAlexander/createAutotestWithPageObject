package yandex.boyko.test;

import com.codeborne.selenide.SelenideElement;
import yandex.boyko.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPages {

  public CalendarComponent CalendarComponent = new CalendarComponent();

  SelenideElement
          firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          emailInput = $("#userEmail"),
          genderSelectionMale = $("[for=\"gender-radio-1\"]"),
          genderSelectionFemale = $("[for=\"gender-radio-2\"]"),
          genderSelectionOther = $("[for=\"gender-radio-3\"]"),
          phoneNumberInput = $("#userNumber"),
          subjectsInput = $("#subjectsInput"),
          hobbiesSelectionSport = $("[for=\"hobbies-checkbox-1\"]"),
          hobbiesSelectionReading = $("[for=\"hobbies-checkbox-2\"]"),
          hobbiesSelectionMusic = $("[for=\"hobbies-checkbox-3\"]"),
          checkResultForm = $(".table-responsive"),
          uploadFile = $("input#uploadPicture"),
          currentAdressInput = $("#currentAddress"),
          selectState = $("#react-select-3-input"),
          selectCity = $("#react-select-4-input");


  public RegistrationPages openPage() {
    open("https://demoqa.com/automation-practice-form");

    return this;
  }

  public RegistrationPages inputFirstName(String value) {
    firstNameInput.setValue(value);

    return this;
  }

  public RegistrationPages inputLastName(String value) {
    lastNameInput.setValue(value);

    return this;
  }

  public RegistrationPages inputEmeil(String value) {
    emailInput.setValue(value);

    return this;
  }

  public RegistrationPages putGenderMale() {
    genderSelectionMale.click();

    return this;
  }

  public RegistrationPages putGenderFemale() {
    genderSelectionFemale.click();

    return this;
  }

  public RegistrationPages putGenderOther() {
    genderSelectionOther.click();

    return this;
  }

  public RegistrationPages inputPhoneNumber(String value) {
    phoneNumberInput.setValue(value);

    return this;
  }

  public RegistrationPages inputSubjects(String value) {
    subjectsInput.setValue(value).pressEnter();

    return this;
  }

  public RegistrationPages putHobbiesSport() {
    hobbiesSelectionSport.click();

    return this;
  }

  public RegistrationPages putHobbiesReading() {
    hobbiesSelectionReading.click();

    return this;
  }

  public RegistrationPages putHobbiesMusic() {
    hobbiesSelectionMusic.click();

    return this;
  }

  public RegistrationPages uploadFileFromForm(String fileName) {
    uploadFile.uploadFromClasspath(fileName);

    return this;
  }

  public RegistrationPages inputCurrentAdress(String value) {
    currentAdressInput.setValue(value);

    return this;
  }

  public RegistrationPages selectStateInCheckbox(String value) {
    selectState.setValue(value).pressEnter();

    return this;
  }

  public RegistrationPages selectCityInCheckbox(String value) {
    selectCity.setValue(value).pressEnter();

    return this;
  }

  public RegistrationPages checkResultTable(String key, String value) {
    checkResultForm.$(byText(key)).parent().shouldHave(text(value));

    return this;
  }

}
