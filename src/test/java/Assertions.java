import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Assertions {
    public void Assert() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions((Arrays.asList("geoLocation"))));
        Page page = browserContext.newPage();
        page.navigate("");

        //Timeout default = 5s
        Locator locator = page.locator("a:has-text(\"Deal of the day\")");
        locator.click();
        assertThat(page.locator("")).containsText("");
        assertThat(page.locator("")).containsText("", new LocatorAssertions.ContainsTextOptions().setTimeout(10000)); //timeout = mms
        assertThat(page.locator("")).isEnabled();
    }
}
