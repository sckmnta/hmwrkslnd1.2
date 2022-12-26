import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class hwslnd2Optional {
    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = " https://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDropTest() {
        /// open site
        open("/drag_and_drop");
        /// drop object a to place b
        $("#column-a").dragAndDropTo("#column-b");
        //actions($("#column-a")).moveToElement($("column-b")); smthng went wrong
        ///check if they really changed
        $("#column-a").shouldHave(Condition.text("b")); ///successful test
        //$("#column-b").shouldHave(Condition.text("b")); ///unsuccessful test


    }
}
