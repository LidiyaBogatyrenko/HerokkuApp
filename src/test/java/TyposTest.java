import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

@Test
public class TyposTest {
    /*
    Задача 5. Typos -
    Проверить соответствие параграфа орфографии Локатор: (By.xpath("(//p)[2]"))
     */
    public  void typos() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/typos");

        int refresh = 10;
        for (int i = 1; i <= refresh; i++) {
            driver.navigate().refresh();
            String text = driver.findElement(By.xpath("(//p)[2]")).getText();
            softAssert.assertEquals(text, "Sometimes you'll see a typo, other times you won't.");
        }
        driver.quit();
        softAssert.assertAll();
    }
}