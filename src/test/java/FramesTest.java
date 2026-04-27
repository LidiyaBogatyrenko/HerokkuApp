import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {
    /*
    Frames
    - Открыть iFrame
    - Проверить, что текст внутри параграфа равен “Your content goes here.”
     */
    @Test
    public void checkFrames() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //переходим на сайт и нажимаем на линк iFrame
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//*[contains(text(), 'iFrame')]")).click();
        //переключаемся во frame и проверяем текст в нём
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
        String textInFrame = driver.findElement(By.id("tinymce")).getText();
        Assert.assertEquals(textInFrame, "Your content goes here.");
        //выходим из frame
        driver.switchTo().defaultContent();
        driver.quit();
    }
}