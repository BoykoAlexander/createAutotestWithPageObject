package yandex.boyko.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import yandex.boyko.page.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormWithJavaFaker extends TasteBase {


  yandex.boyko.page.RegistrationPage RegistrationPage = new RegistrationPage();
  Faker faker = new Faker();

  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();
  String email = faker.internet().emailAddress();
  String currentAddress = faker.address().streetAddress();


  @Test
  void fillFormTest() {
    //filling out the form
    RegistrationPage.openPage()
            .inputFirstName(firstName)
            .inputLastName(lastName)
            .inputEmeil(email)
            .putGender("Male") //Female | Male | Other
            .inputPhoneNumber("9999999999");
    RegistrationPage.calendarComponent.setDate();
    RegistrationPage.inputSubjects("English")
            .selectHobbies("Music")
            .uploadFileFromForm("driver.jpg")
            .inputCurrentAdress(currentAddress)
            .selectStateInCheckbox("Uttar Pradesh")
            .selectCityInCheckbox("Merrut");

    $("#submit").click();

    //Check assertion
    RegistrationPage.checkResultTable("Student Name", firstName + " " + lastName)
            .checkResultTable("Student Email", email)
            .checkResultTable("Gender", "Male")
            .checkResultTable("Mobile", "9999999999")
            .checkResultTable("Date of Birth", "23 May,1994")
            .checkResultTable("Subjects", "English")
            .checkResultTable("Hobbies", "Music")
            .checkResultTable("Picture", "driver.jpg")
            .checkResultTable("Address", currentAddress)
            .checkResultTable("State and City", "Uttar Pradesh Merrut");

  }
}


