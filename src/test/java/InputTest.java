import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class InputTest {
    /*
    Задача 4. Inputs -
    Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP И Keys.ARROW_DOWN.
    Локатор: By.tagName(“input”)
     */
    @Test
    public void checkInput() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.tagName("input")).sendKeys("Прivет!@");
        String getText = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(getText, "");
        driver.findElement(By.tagName("input")).sendKeys("10");
        String getText2 = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(getText2,"10");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String getText3 = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(getText3, "11");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        String getText4 = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(getText4, "10");
        driver.quit();
        softAssert.assertAll();
    }
}