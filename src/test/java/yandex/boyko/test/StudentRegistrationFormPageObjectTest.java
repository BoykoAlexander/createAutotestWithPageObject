package yandex.boyko.test;

import org.junit.jupiter.api.Test;
import yandex.boyko.pages.components.TasteBase;

import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormPageObjectTest extends TasteBase {

  RegistrationPages registrationPages = new RegistrationPages();


  @Test
  void fillFormTest() {
    //filling out the form
    registrationPages.openPage()
            .inputFirstName("Alex")
            .inputLastName("Boyko")
            .inputEmeil("boyko@yandex.ru")
            .putGenderFemale()
            .inputPhoneNumber("9999999999");
    registrationPages.CalendarComponent.SetDate();
    registrationPages.inputSubjects("English")
            .putHobbiesMusic()
            .uploadFileFromForm("driver.jpg")
            .inputCurrentAdress("South Park")
            .selectStateInCheckbox("Uttar Pradesh")
            .selectCityInCheckbox("Merrut");

    $("#submit").click();

    //Check assertion
    registrationPages.checkResultTable("Student Name", "Alex Boyko")
            .checkResultTable("Student Email", "boyko@yandex.ru")
            .checkResultTable("Gender", "Male")
            .checkResultTable("Mobile", "9999999999")
            .checkResultTable("Date of Birth", "23 May,1994")
            .checkResultTable("Subjects", "English")
            .checkResultTable("Hobbies", "Music")
            .checkResultTable("Picture", "driver.jpg")
            .checkResultTable("Address", "South Park")
            .checkResultTable("State and City", "Uttar Pradesh Merrut");


  }
}

