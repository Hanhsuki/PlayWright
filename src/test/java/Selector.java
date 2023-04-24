import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class Selector {
    @Test
    public void Selector() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext1 = browser.newContext();
        Page page = browserContext1.newPage();
        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        //xpath
        page.locator("//a[@data-lid='hdr_best_buy_totaltech']").click();
        //CSS selector
        page.locator("//[data-lid='hdr_best_buy_totaltech']").click();
    }
}
