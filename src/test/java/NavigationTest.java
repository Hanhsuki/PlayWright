import org.junit.jupiter.api.Test;
import pages.DataEntries;

public class NavigationTest extends SetupPlayWrightRunner{
    @Test
    public void FirstTest(){
        page.navigate("url");
        //C1
        navigationPage.navigateTo(DataEntries.DATA1);
        firstPage.action1();
        //C2

    }
}
