import com.microsoft.playwright.*;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DealWithShadowDom {
    public void ShadowTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions((Arrays.asList("geoLocation"))));
        Page page = browserContext.newPage();
        page.navigate("");
        page.locator("").fill("");
    }
}
