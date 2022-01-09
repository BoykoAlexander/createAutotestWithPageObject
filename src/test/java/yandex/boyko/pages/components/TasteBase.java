package yandex.boyko.pages.components;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TasteBase {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1280x720";
  }
}
