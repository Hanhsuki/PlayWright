import com.microsoft.playwright.*;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DealWithPopUp {
    public void PopUpTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions((Arrays.asList("geoLocation"))));
        Page page = browserContext.newPage();
        page.navigate("");
        Page popup = page.waitForPopup(() -> {
            page.locator("").click();
        });
        assertThat(popup.locator("")).containsText("");
        page.bringToFront();
        page.locator("").fill("");
    }
}
