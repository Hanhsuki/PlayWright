package pages;

import com.microsoft.playwright.Page;

public class FirstPage {
    private final Page firstPage;
    private static final String XPATH = "";

    public FirstPage(Page page) {
        this.firstPage = page;
    }

    public void action1(){
        firstPage.locator(XPATH).click();
    }
}
