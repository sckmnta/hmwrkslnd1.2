import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hwslnd2 {
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
        //String url = "https://github.com/enterprise";
        //String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        //assertEquals(url, currentUrl);
        //assertEquals("https://github.com/enterprise", WebDriverRunner.url());


    }
}