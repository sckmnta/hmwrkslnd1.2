import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HwSlnd2 {
    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        // Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com/";
    }
    @Test
    void scssflTest() {
        /// open github
        open("");
        /// move mouse to "solutions" element
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        /// click to "Enterprise" element
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        /// check if it works
        $(".application-main").shouldHave(text("GitHub for enterprises"));
        /// далее попытался сравнить по ожидаемому и выдаваемому урл, но не вышло
        String expectedUrl = "https://github.com/enterprise";
        String currentUrl = url();
        assertEquals(expectedUrl, currentUrl);
//        assertEquals("https://github.com/enterprise", url());


    }
}
