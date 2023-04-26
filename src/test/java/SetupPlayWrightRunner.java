import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.FirstPage;
import pages.NavigationPage;
import services.EnvironmentReaderServices;

import java.nio.file.Path;
import java.nio.file.Paths;

@ExtendWith(TestWatcherExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    public void tearDow(TestInfo testInfo){
        browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("traces/" + testInfo.getDisplayName().replace("()", "") + ".zip")));
        browserContext.close();
        browser.close();
    }
    protected String getProperty(String key){
        return EnvironmentReaderServices.getProperty(key);
    }
}
