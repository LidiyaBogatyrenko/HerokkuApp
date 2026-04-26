import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DropdownTest {
    /*
    Задача 3: Dropdown -
    Взять все элементы дроп-дауна и проверить их наличие.
    Выбрать первый, проверить, что он выбран,
    выбрать второй, проверить, что он выбран.
    Локатор: By.id("dropdown")
     */
    @Test
    public  void checkDropdown() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        // проверка на наличие и наименование опций
        boolean visibleValue1 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).isDisplayed();
        softAssert.assertTrue(visibleValue1);
        String value1 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).getText();
        softAssert.assertEquals(value1, "Option 1");
        boolean visibleValue2 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).isDisplayed();
        softAssert.assertTrue(visibleValue2);
        String value2 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).getText();
        softAssert.assertEquals(value2, "Option 2");
        // Проверка выбора опции 1
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByIndex(1);
        String selectedValue1 = driver.findElement((By.xpath("//*[@id=\"dropdown\"]/option[2]"))).getText();
        softAssert.assertEquals(selectedValue1, "Option 1");
        // Проверка выбора опции 2
        driver.findElement((By.xpath("//*[@id=\"dropdown\"]/option[3]"))).click();
        select.selectByIndex(2);
        String selectedValue2 = driver.findElement((By.xpath("//*[@id=\"dropdown\"]/option[3]"))).getText();
        softAssert.assertEquals(selectedValue2, "Option 2");
        driver.quit();
        softAssert.assertAll();
    }
}