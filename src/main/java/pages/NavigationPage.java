package pages;

import com.microsoft.playwright.Page;

public class NavigationPage {
    private final Page navigationPage;
    private static final String XPATH = "";

    public NavigationPage(Page page) {
        this.navigationPage = page;
    }

    public void navigateTo(DataEntries locator) {
        navigationPage.locator(XPATH).click();
        navigationPage.locator(String.format("xpath", locator)).click();
    }
}
