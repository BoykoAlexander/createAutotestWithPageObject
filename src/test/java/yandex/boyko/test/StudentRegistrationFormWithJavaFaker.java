package yandex.boyko.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import yandex.boyko.pages.components.TasteBase;

import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormWithJavaFaker extends TasteBase {


  RegistrationPages registrationPages = new RegistrationPages();
  Faker faker = new Faker();

  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();
  String email = faker.internet().emailAddress();
  String currentAddress = faker.address().streetAddress();


  @Test
  void fillFormTest() {
    //filling out the form
    registrationPages.openPage()
            .inputFirstName(firstName)
            .inputLastName(lastName)
            .inputEmeil(email)
            .putGenderFemale()
            .inputPhoneNumber("9999999999");
    registrationPages.CalendarComponent.SetDate();
    registrationPages.inputSubjects("English")
            .putHobbiesMusic()
            .uploadFileFromForm("driver.jpg")
            .inputCurrentAdress(currentAddress)
            .selectStateInCheckbox("Uttar Pradesh")
            .selectCityInCheckbox("Merrut");

    $("#submit").click();

    //Check assertion
    registrationPages.checkResultTable("Student Name", firstName + " " + lastName)
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


