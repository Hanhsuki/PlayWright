import com.microsoft.playwright.*;

public class Timeouts {
    public void timeout() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        //Thời gian chờ mặc định cho các hàm wait. Được sử dụng để đợi cho các điều kiện của trang web trước khi thực hiện thao tác tiếp theo. Mặc định là 30s
        browserContext.setDefaultTimeout(40000);
        //set timeout cho page thì wait chỉ áp dụng cho các đối tượng page.
        Page page = browserContext.newPage();
        page.setDefaultTimeout(5000);
    }
}
