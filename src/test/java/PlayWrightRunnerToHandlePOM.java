import annotations.PlayWrightPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.FirstPage;
import pages.NavigationPage;
import services.EnvironmentReaderServices;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PlayWrightRunnerToHandlePOM {
    protected Page page;
    protected BrowserContext browserContext;
    protected Browser browser;
    protected Playwright playwright;
    @PlayWrightPage
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
        //Class này có tất cả các field vì vậy cần call superClass ở đây để tham chiếu all.
        initPage(this, page);
    }
    @AfterEach
    public void tearDow(){
        browserContext.close();
        browser.close();
    }

    public void initPage(Object object, Page page){
        Class<?> clazz = object.getClass().getSuperclass();
        for(Field field : clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(PlayWrightPage.class)){
                Class<?>[] type = {Page.class};
                try {
                    field.set(this, field.getType().getConstructor(type).newInstance(page));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e){
                    System.out.println("Did not manage to call constructor for playwright page with name" + field.getName());
                }
            }
        }
    }

    protected String getProperty(String key){
        return EnvironmentReaderServices.getProperty(key);
    }
}

