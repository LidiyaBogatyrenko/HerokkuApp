import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.*;

public class CheckBoxTest {
    /*
    Задание 2: Checkboxes -
    проверить, что первый чекбокс unchecked,
    отметить первый чекбокс, проверить что он checked.
    Проверить, что второй чекбокс checked, сделать uncheck, проверить, что он unchecked.
    Локатор: By.cssSelector("[type=checkbox]”)
 */
    @Test
    public void checkBox() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        boolean check1Selected = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        assertFalse(check1Selected);

        driver.findElements(By.cssSelector("[type=checkbox]")).get(0).click();
        check1Selected = driver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        assertTrue(check1Selected);

        boolean check2Selected = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        assertTrue(check2Selected);

        driver.findElements(By.cssSelector("[type=checkbox]")).get(1).click();
        check2Selected = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        assertFalse(check2Selected);

        driver.quit();
    }
}