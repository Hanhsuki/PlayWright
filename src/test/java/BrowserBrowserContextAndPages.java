import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserBrowserContextAndPages {
    public void Browsers(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    /* So what is the browser context?
    => You can imagine it as an isolated session similar to Incognito mode.
    As a recommendation, you should use the browser context for each of your tests, because in doing so
    you will have an isolated context for your test.
     */
    public void BrowsersContext(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
    }
}
