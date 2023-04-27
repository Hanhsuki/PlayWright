import com.microsoft.playwright.*;

import java.util.Arrays;

public class EvaluateJavaScript {
    //Lấy xpath bằng cách mở f12 tab console, using document.querySelectorAll("")//lấy all element.
    //Convert to array: Array.from(document.querySelectorAll(""))
    //Filter locator in array: Array.from(document.querySelectorAll("")).filter(el => el.innerText === '').length === 1

    public void EvaluateJavaScriptTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions((Arrays.asList("geoLocation"))));
        Page page = browserContext.newPage();
        page.navigate("");
        boolean elementFound = (boolean) page.evaluate("element => Array.from(document.querySelectorAll('')).filter(el => el.innerText === '').length === 1", "text find element expected");
        if(elementFound){
            System.out.println("element found");
        } else {
            System.out.println("element not found");
        }

    }
}
