import com.microsoft.playwright.*;

public class BrowserBrowserContextAndPages {
    public void Browsers(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    /* So what is the browser context?
    => You can imagine it as an isolated session similar to Incognito mode.
    As a recommendation, you should use the browser context for each of your tests, because in doing so
    you will have an isolated context for your test, Immune. Have any issues with any cookies or anything that might be
    stored in your browser.
    */
    public void BrowsersContext(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
    }

    public void Page(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext1 = browser.newContext();
        BrowserContext browserContext2 = browser.newContext();
        Page page1 = browserContext1.newPage();
        Page page2 = browserContext2.newPage();
        page1.navigate("");
    }
}
