import com.microsoft.playwright.*;

import java.util.Arrays;

public class Actions {
    public void ActionsWithLocator() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions((Arrays.asList("geoLocation"))));
        Page page = browserContext.newPage();
        page.navigate("");

        Locator locator = page.locator("a:has-text(\"Deal of the day\")");
        locator.click();
        locator.allTextContents();
        locator.count();
        locator.fill("text");
        locator.check(); // Checkbox

        Locator locator1 = page.locator("locator list menu", new Page.LocatorOptions().setHasText("menu1"));
        locator1.click();
    }
}
