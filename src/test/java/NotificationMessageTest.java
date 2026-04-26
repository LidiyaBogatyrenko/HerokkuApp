import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class NotificationMessageTest {
    /*
    Задание 8*. Notification Messages -
    кликнуть на кнопку, дождаться появления нотификации, проверить соответствие текста ожиданиям.
     */
    @Test
    public  void checkNotificationMessage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
        String fullTextNotification = driver.findElement(By.id("flash")).getText();
        String[] lines = fullTextNotification.split("\n");
        String textNotification = lines[0];
        Assert.assertEquals(textNotification, "Action successful");
        driver.quit();
    }
}