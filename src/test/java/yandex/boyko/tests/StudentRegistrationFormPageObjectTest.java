package yandex.boyko.tests;

import org.junit.jupiter.api.Test;
import yandex.boyko.page.RegistrationPage;

public class StudentRegistrationFormPageObjectTest extends TasteBase {

  yandex.boyko.page.RegistrationPage RegistrationPage = new RegistrationPage();


  @Test
  void fillFormTest() {
    //filling out the form
    RegistrationPage.openPage()
            .inputFirstName("Alex")
            .inputLastName("Boyko")
            .inputEmeil("boyko@yandex.ru")
            .putGender("Male") //Female | Male | Other
            .inputPhoneNumber("9999999999");
    RegistrationPage.calendarComponent.setDate();
    RegistrationPage.inputSubjects("English")
            .selectHobbies("Music")
            .uploadFileFromForm("driver.jpg")
            .inputCurrentAdress("South Park")
            .selectStateInCheckbox("Uttar Pradesh")
            .selectCityInCheckbox("Merrut")
            .clickButtonSubmit();


    //Check assertion
    RegistrationPage.checkResultTable("Student Name", "Alex Boyko")
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

