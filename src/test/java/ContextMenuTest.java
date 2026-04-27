import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.time.Duration;

public class ContextMenuTest {
    /*
    Context Menu
    - правый клик по элементу
    - валидация текста на алерте
    - закрытие алерта
     */
    @Test
    public void checkContextMenu() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot")))
                .build().perform();
        Alert alert= driver.switchTo().alert();
        String alertText = alert.getText();
        softAssert.assertEquals(alertText, "You selected a context menu");
        alert.accept();
        driver.quit();
        softAssert.assertAll();
    }
}