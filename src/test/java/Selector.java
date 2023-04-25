import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class Selector extends SetupPlayWrightRunner {
   @Test
    public void Selector() {
        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        //xpath
        page.locator("//a[@data-lid='hdr_best_buy_totaltech']").click();
        //CSS selector
        page.locator("//[data-lid='hdr_best_buy_totaltech']").click();
        //text
        page.locator("a:has-text(\"Deal of the day\")");
    }
}
