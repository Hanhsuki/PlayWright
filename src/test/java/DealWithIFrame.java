import com.microsoft.playwright.*;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DealWithIFrame {
    public void IFrameTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions((Arrays.asList("geoLocation"))));
        Page page = browserContext.newPage();
        page.navigate("");
        //c1
        page.frameLocator("").locator("").fill("");
        //c2
        page.frameByUrl("").locator("").click();
        //c3
        Page popup = page.waitForPopup(() -> {
            page.frameLocator("").locator("").fill("");
        });
        assertThat(popup.locator("")).containsText("");

    }
}
