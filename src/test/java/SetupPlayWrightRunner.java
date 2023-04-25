import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.FirstPage;
import pages.NavigationPage;

public class SetupPlayWrightRunner {
    protected Page page;
    protected BrowserContext browserContext;
    protected Browser browser;
    protected Playwright playwright;
    protected FirstPage firstPage;
    protected NavigationPage navigationPage;

    @BeforeAll
    public void init(){
        playwright = Playwright.create();
    }
    @BeforeEach
    public void setUp(){
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();

        firstPage = new FirstPage(page);
        navigationPage = new NavigationPage(page);
    }
    @AfterEach
    public void tearDow(){
        browserContext.close();
        browser.close();
    }
}
