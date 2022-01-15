package yandex.boyko.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EtalonStudentRegistrationForm {

  @Test
  void fillFormTest() {
    open("https://demoqa.com/automation-practice-form");
    //personal data
    $("#firstName").setValue("Alex");
    $("#lastName").setValue("Boyko");
    $("#userEmail").setValue("boyko@yandex.ru");
    // gender
    $("[for=\"gender-radio-1\"]").click();
    //phone number
    $("#userNumber").setValue("9999999999");
    //calendar
    $("#submit").scrollTo();
    $("#dateOfBirthInput").click();
    //month
    $(".react-datepicker__month-select").selectOptionByValue("4");
    //year
    $(".react-datepicker__year-select").selectOptionByValue("1994");
    //date
    $("[aria-label=\"Choose Monday, May 23rd, 1994\"]").click();
    // subjects
    $("#subjectsInput").setValue("English").pressEnter();
    //hobbies
    $("[for=\"hobbies-checkbox-3\"]").click();
    //uploadFile
    $("input#uploadPicture").uploadFromClasspath("driver.jpg");
    //currentAdress
    $("#currentAddress").setValue("South Park");
    //state and city
    $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
    $("#react-select-4-input").setValue("Merrut").pressEnter();
    //sumbit
    $("#submit").click();

    //Assert test Completed
    $(".table-responsive").shouldHave(text("Alex"),
            text("Boyko"), text("boyko@yandex.ru"),
            text("Male"),
            text("9999999999"),
            text("23 May,1994"),
            text("English"),
            text("Music"),
            text("driver.jpg"),
            text("South Park"),
            text("Uttar Pradesh"),
            text("Merrut"));

  }
}
